package willem.weiyu.scala.loop

/**
  * @author weiyu
  * while循环
  * @create 2017/11/7
  */
object WhileLoop {

  def main(args: Array[String]): Unit = {
    while (true){
      println("======forever loop")
      Thread.sleep(1000)
    }
  }
}
