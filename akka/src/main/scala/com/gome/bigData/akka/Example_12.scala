package com.gome.bigData.akka

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

/**
  * 消息处理：!(Fire-Forget)
  */
object Example_12 extends App {
  //定义几种不同的消息
  case class Start(var msg : String)
  case class Run(var msg : String)
  case class Stop(var msg : String)

  class ExampleActor extends Actor with ActorLogging {
    val other = context.actorOf(Props[OtherActor],"OtherActor")

    override def receive: Receive = {
      //使用fire-and-forget消息模型向OtherActor发送消息，隐式地传递sender
      case Start(msg) => other ! msg
      //使用fire-and-forget消息模型向OtherActor发送消息，直接调用tell方法，显式指定sender
      case Run(msg) => other.tell(msg, sender)
    }
  }

  class OtherActor extends Actor with ActorLogging {
    override def receive: Receive = {
      case s : String =>log.info("received message: "+s)
      case _ => log.info("received unknown message")
    }
  }

  //创建ActorSystem,ActorSystem为创建和查找Actor的入口
  //ActorSystem管理的Actor共享配置信息如分发器(dispatchers)、部署（deployments）等
  val system = ActorSystem("MessageProcessingSystem")
  val systemLog = system.log

  //创建ContextActor对象
  val exampleActor = system.actorOf(Props[ExampleActor],name = "exampleActor")

  //使用fire-and-forget消息模型想exampleActor发送消息
  exampleActor!Run("Running")
  exampleActor!Start("Starting")

  system.terminate()
}
