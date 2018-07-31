package willem.weiyu.scala.operator

/**
  * @author weiyu
  * 逻辑运算符
  * @create 2018/7/31
  */
object LogicOperatorDemo {

  def main(args: Array[String]): Unit = {
    val a = true
    val b = false

    println("a && b=" + (a && b))
    println("a || b=" + (a || b))
    println("!(a && b)=" + !(a && b))
  }
}
