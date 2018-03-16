package com.weiyu.bigData.akka

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

/**
  * Actor API：成员变量self及sender()方法的使用
  */
object Example_05 extends App {
  class FirstActor extends Actor with ActorLogging {
    //通过context.actorOf方法创建Actor
    var child: ActorRef = _

    //Hook方法，preStart()，Actor启动之前调用，用于完成初始化工作
    override def preStart(): Unit = {
      log.info("preStart() in FirstActor")
      child = context.actorOf(Props[MyActor],name = "myChild")
    }

    override def receive: Receive = {
      //向MyActor发送消息
      case x => child ! x; log.info("received "+x)
    }
  }

  class MyActor extends Actor with ActorLogging {
    self ! "message from self reference"

    override def receive: Receive = {
      case "test" => log.info("received test");sender()!"message from MyActor"
      case "message from self reference" => log.info("message from self reference")
      case _ => log.info("received unknown message")
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
