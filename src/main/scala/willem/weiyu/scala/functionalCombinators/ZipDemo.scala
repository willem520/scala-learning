package willem.weiyu.scala.functionalCombinators

/**
  * 将两个列表中的内容聚合到一个对偶列表
  */
object ZipDemo {

  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3)
    val list2 = List("a", "b", "c","d")

    val list3 = list1.zip(list2)
    println(list3)
  }
}
