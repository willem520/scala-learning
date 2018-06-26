package willem.weiyu.scala.functionalCombinators

/**
  * 移除任何对传入函数计算结果为false的元素。返回一个布尔值的函数通常被称为谓词函数[或判定函数]
  */
object FilterDemo {

  def main(args: Array[String]): Unit = {
    val numbers = List(1,2,3,7,9,12)
    numbers.filter(_%2 == 0).foreach(println)
  }
}
