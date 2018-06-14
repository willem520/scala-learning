package willem.weiyu.scala.operator

/**
  * @author weiyu@gomeholdings.com
  *         位运算符
  * @create 2017/11/7
  */
object BitwiseOperatorDemo {
  def main(args: Array[String]): Unit = {
    //60 = 0011 1100
    val a = 60
    //13 = 0000 1101
    val b = 13

    //12 = 0000 1100
    println("a & b = "+(a & b))
    //61 = 0011 1101
    println("a | b = "+(a | b))
    //49 = 0011 0001
    println("a ^ b = "+(a ^ b))
    //-61 = 1100 0011
    println("~a  = "+(~a))
    //240 = 1111 0000
    println("a << 2 = "+(a << 2))
    //15 = 1111
    println("a >> 2 = "+(a >> 2))
    //15 = 0000 1111
    println("a >>> 2 = "+(a >>> 2))
  }
}
