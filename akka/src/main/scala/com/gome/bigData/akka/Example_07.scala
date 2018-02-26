package com.gome.bigData.akka

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

/**
  * Actor API：成员变量self及sender()方法的使用
  */
object Example_07 extends App {
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
    var parentActorRef : ActorRef = _

    override def preStart(): Unit = {
      //通过context.parent获取其父Actor的ActorRef
      parentActorRef = context.parent
    }

    override def receive: Receive = {
      case "test" => log.info("received test");parentActorRef!"message from ParentActorRef"
      case _ => log.info("received unknown message")
    }
  }

  val system = ActorSystem("MyActorSystem")
  val systemLog = system.log

  //创建FirstActor对象
  val myactor = system.actorOf(Props[FirstActor],name = "firstActor")
  //获取ActorPath
  val myActorPath = system.child("firstActor")
  //通过system.actorSelection方法获取ActorRef
  val myActor = system.actorSelection(myActorPath)
  systemLog.info("准备向myactor发送消息")
  myActor!"test"
  myActor!123
  Thread.sleep(5000)
  system.terminate()
}
