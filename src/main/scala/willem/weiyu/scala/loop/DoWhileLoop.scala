package willem.weiyu.scala.loop

/**
  * @author weiyu
  * do...while循环
  * @create 2017/11/7
  */
object DoWhileLoop {

  def main(args: Array[String]): Unit = {
    var count = 0
    do {
      println("======count" + count)
      count += 1
      Thread.sleep(500)
    } while (count < 10)
  }
}
