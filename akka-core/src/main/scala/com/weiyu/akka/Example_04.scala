package com.weiyu.bigData.akka

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

object Example_04 extends App {

  class FirstActor extends Actor with ActorLogging {
    //通过context.actorOf方法创建Actor
    val child = context.actorOf(Props[MyActor], name = "myChild")

    override def receive: Receive = {
      case x => child ! x; log.info("received "+x)
    }
  }

  class MyActor extends Actor with ActorLogging {

    override def receive: Receive = {
      case "test" => log.info("received test")
      case _ => log.info("received unknown message")
    }
  }

  //创建ActorSystem对象
  val system = ActorSystem("MyActorSystem")
  //返回ActorSystem的LoggingAdapter
  val systemLog = system.log
  //创建FirstActor
  val myactor = system.actorOf(Props[FirstActor],name = "firstActor")

  systemLog.info("准备向myactor发送消息")
  //向myactor发送消息
  myactor!"test"
  myactor!123
  Thread.sleep(1000)
  //关闭ActorSystem，停止程序的运行
  system.terminate()
}
