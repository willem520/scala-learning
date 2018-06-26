package willem.weiyu.scala.functionalCombinators

/**
  * 对列表中的每个元素应用一个函数，返回应用后的元素所组成的列表
  */
object MapDemo {

  def main(args: Array[String]): Unit = {
    val numbers = List(1,2,3,7)
    numbers.map(BigInt(_).pow(2)).foreach(println)
  }
}
