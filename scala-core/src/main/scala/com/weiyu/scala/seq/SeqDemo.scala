package com.weiyu.bigData.scala.seq

object SeqDemo extends App {
  val numbers = Seq(11, 2, 5, 1, 6, 3, 9)

  println("======")
  println(numbers.max)

  println("======")
  println(numbers.min)

  case class Book(title : String, pages : Int)

  val books = Seq(
    Book("future of Scala developers", 85),
    Book("Parallel algorithms", 240),
    Book("Object Oriented Programming", 130),
    Book("Mobile Development", 495)
  )

  println("======")
  println(books.maxBy(_.pages))

  println("======")
  println(books.filter(_.pages > 120))

  val abcd = Seq('a', 'b', 'c', 'd')
  val efg = Seq('e', 'f', 'g')
  val hijk = Seq('h', 'i', 'j', 'k')
  val lmn = Seq('l', 'm', 'n')

  val test = Seq(abcd,efg,hijk,lmn)
  println("======")
  println(test.flatten)
}
