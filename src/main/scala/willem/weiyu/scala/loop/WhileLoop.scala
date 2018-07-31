package willem.weiyu.scala.loop

object WhileLoop {

  def main(args: Array[String]): Unit = {
    while (true){
      println("======forever loop")
      Thread.sleep(1000)
    }
  }
}
