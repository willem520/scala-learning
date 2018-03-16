package com.gome.bigData.demo.io

import java.io.FileWriter

import scala.io.Source
import scala.util.Random

object IODemo {

  def write(): Unit ={
    println("writing。。。")
    val writer = new FileWriter("E://data.txt",true)
    writer.append("scala io test\n")
    writer.close()
  }

  def read(): Unit ={
    println("reading。。。")
    val file = Source.fromFile("E://data.txt","UTF-8")
    val lines = file.getLines()
    lines.foreach(println)
    file.close()
  }

  def main(args: Array[String]): Unit = {
    val flag = Random.nextBoolean()
    if(flag)
      read()
    else
      write()
  }
}
