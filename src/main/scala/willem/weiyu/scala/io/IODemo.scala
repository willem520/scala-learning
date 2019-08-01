package willem.weiyu.scala.io

import java.io.FileWriter

import scala.io.Source
import scala.util.Random

object IODemo {

  def write(): Unit = {
    println("writing。。。")
    val writer = new FileWriter("examples/data.txt", true)
    writer.append("scala io test\n")
    writer.close()
  }

  def read(): Unit = {
    println("reading。。。")
    val file = Source.fromFile("examples/data.txt", "UTF-8")
    val lines = file.getLines()
    lines.foreach(println)
    file.close()
  }

  def main(args: Array[String]): Unit = {
    for (_ <- 1 to 3) {
      val flag = Random.nextBoolean()
      if (flag) {
        read()
      }
      else {
        write()
      }
    }
  }
}
