package com.gome.bigData.akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage

class Ping(pong : ActorRef) extends Actor{
  var count = 0

  def incrementAndPrint: Unit ={
    count +=1
    println(s"$count:ping")
  }

  override def receive: Receive = {
    case StartMessage =>
      incrementAndPrint
      pong!PongMessage
    case PingMessage =>
      incrementAndPrint
      if (count > 99){
        sender!StopMessage
        println("ping stopped")
        context.stop(self)
      }else{
        sender!PongMessage
      }
    case _ => println("Ping got unexpected information")
  }
}

class Pong extends Actor {
  var count = 0
  def receive = {
    case StopMessage =>
      println("pong stopped")
      context.stop(self)
    case PongMessage =>
      count += 1
      println(s"$count:pong")
      sender ! PingMessage
    case _ => println("Pong got unexpected information")
  }
}

object PingPongDemo {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("PingPongDemo")
    val pongActor = system.actorOf(Props[Pong],"pong")
    val pingActor = system.actorOf(Props(new Ping(pongActor)),"ping")
    pingActor!StartMessage
  }
}
