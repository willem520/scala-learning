package com.weiyu.bigData.akka

import akka.actor.{ActorSystem, TypedActor, TypedProps}
import akka.event.Logging

import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.duration._

object TypeActor01 extends App {

  trait Squarer {
    //fire-and-forget消息
    def squareDontCare(i : Int) : Int
    //非阻塞send-request-reply消息
    def square(i : Int) : Future[Int]
    //阻塞式的send-request-reply消息
    def squareNowPlease(i : Int) : Option[Int]
    //阻塞式的send-request-reply消息
    def squareNow(i : Int) : Int
  }

  class SquarerImpl(val name : String) extends Squarer {
    def this() = this("SquarerImpl")

    override def squareDontCare(i: Int): Int = i * i

    override def square(i: Int): Future[Int] = Promise.successful(i * i).future

    override def squareNowPlease(i: Int): Option[Int] = Some(i * i)

    override def squareNow(i: Int): Int = i * i
  }

  val system = ActorSystem("TypeActorSystem")
  val log = Logging(system,this.getClass)

  //使用默认构造函数创建Typed Actor
  val mySquarer : Squarer = TypedActor(system).typedActorOf(TypedProps[SquarerImpl](), "mySquarer")

  //使用非默认构造函数创建Typed Actor
  val otherSquarer : Squarer = TypedActor(system).typedActorOf(TypedProps(classOf[Squarer], new SquarerImpl("SquarerImpl")), "otherSquarer")

  //fire-forget消息发送
  mySquarer.squareDontCare(10)

  //send-request-reply消息发送
  val oSquare = mySquarer.squareNowPlease(10)
  log.info("oSquare=" + oSquare)

  val iSquare = mySquarer.squareNow(10)
  log.info("iSquare=" + iSquare)

  //request-reply-with-future消息发送
  val fSquare = mySquarer.square(10)
  val result = Await.result(fSquare, 5 second)
  log.info("fSquare=" + result)

  system.terminate()
}
