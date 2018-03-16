package com.gome.bigData.demo.function

object FuncDemo {

  def mapFunc(): Unit = {
    List("Spark" -> 1, "Hive" -> 2, "Hadoop" -> 3, "Storm" -> 4).map(_._1).foreach(println)
  }

  def flatMapFunc(): Unit = {
    List(List(1, 2, 3, 4), List(3, 5, 6)).flatMap(x => x).foreach(println)
  }

  def filterFunc(): Unit = {
    Array(1, 2, 4, 5, 9, 3).filter(_ > 3).foreach(println)
  }

  def reduceFunc(): Unit ={
    println(Array(1,2,4,3,5).reduce(_+_))
  }

  def foldFunc(): Unit ={
    println(Array(1,2,4,3,5).fold(10)(_+_))
  }

  def scanFunc(): Unit ={
    Array(1,2,4,3,5).scan(0)(_+_).foreach(println)
  }

  def main(args: Array[String]): Unit = {
    //map函数
    mapFunc()
    println("======")

    //flatMap函数
    flatMapFunc()
    println("======")

    //filter函数
    filterFunc()
    println("======")

    //reduce函数
    reduceFunc()
    println("======")

    //fold函数
    foldFunc()
    println("======")

    //scan函数
    scanFunc()
    println("======")
  }
}
