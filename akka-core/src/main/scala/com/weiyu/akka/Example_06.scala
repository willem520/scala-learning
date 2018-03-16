package com.weiyu.bigData.akka

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

/**
  * Actor API：unhandled方法的使用
  */
object Example_06 extends App {
  class FirstActor extends Actor with ActorLogging {
    override def receive: Receive = {
      //向MyActor发送消息
      case "test" => log.info("received test")
    }

    override def unhandled(message: Any): Unit = {
      log.info("unhandled message is {}",message)
    }
  }

  val system = ActorSystem("MyActorSystem")
  val systemLog = system.log

  //创建FirstActor对象
  val myactor = system.actorOf(Props[FirstActor],name = "firstActor")

  systemLog.info("准备向myactor发送消息")
  myactor!"test"
  myactor!123
  Thread.sleep(5000)
  system.terminate()
}
