package com.gome.bigData.akka

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

/**
  * ActorPath
  */
object Example_08 extends App {
  class FirstActor extends Actor with ActorLogging {
    //通过context.actorOf方法创建Actor
    var child: ActorRef = _

    override def preStart(): Unit = {
      log.info("preStart() in FirstActor")
      child = context.actorOf(Props[MyActor],name = "myActor")
    }

    override def receive: Receive = {
      //向MyActor发送消息
      case x => child ! x; log.info("received "+x)
    }
  }

  class MyActor extends Actor with ActorLogging {
    override def receive: Receive = {
      case "test" => log.info("received test");
      case _ => log.info("received unknown message")
    }
  }

  val system = ActorSystem("MyActorSystem")
  val systemLog = system.log

  //创建FirstActor对象
  val firstActor = system.actorOf(Props[FirstActor],name = "firstActor")
  //获取ActorPath
  val firstActorPath = system.child("firstActor")
  systemLog.info("firstActorPath-->{}",firstActorPath)

  //通过system.actorSelection方法获取ActorRef
  val myActor = system.actorSelection(firstActorPath)

  //直接指定其路径
  val myActor2 = system.actorSelection("/user/firstActor")

  //使用相对路径
  val myActor3 = system.actorSelection("../firstActor")

  systemLog.info("准备向myActor发送消息")
  myActor2!"test"
  myActor2!123
  Thread.sleep(5000)
  system.terminate()
}
