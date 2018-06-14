package willem.weiyu.scala.exception

import java.io.{FileNotFoundException, FileReader, IOException}

/**
  * @author weiyu@gomeholdings.com
  * @create 2017/11/9
  */
object ExceptionDemo {

  def main(args: Array[String]): Unit = {
    try {
      val file = new FileReader("input.txt")
    } catch {
      case ex : FileNotFoundException => {
        println("missing file exception")
      }
      case ex : IOException => {
        println("IO Exception")
      }
    } finally {
      println("Exiting finally...")
    }
  }
}
