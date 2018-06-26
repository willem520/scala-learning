package willem.weiyu.scala.basicDataStructure

/**
  * @author weiyu
  * 数组
  * @create 2018/02/22
  */
object ArrayDemo {

  def main(args: Array[String]): Unit = {
    val numberArray = new Array[Int](10)
    numberArray.foreach(println)

    println("******")
    //这种调用方式其实是调用其apply方法进行数组创建操作
    val strArray = Array("first","second")
    strArray(1) = "hello"
    strArray.foreach(println)
  }

}