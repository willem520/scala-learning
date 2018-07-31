package willem.weiyu.scala.closure

/**
  * @author weiyu
  * 闭包
  * @create 2017/11/7
  */
object ClosureDemo {
  val factor = 3

  val multiply = (i:Int) => i * factor

  def main(args: Array[String]): Unit = {
    println("==== 3 * 3 = " + multiply(3))
  }
}
