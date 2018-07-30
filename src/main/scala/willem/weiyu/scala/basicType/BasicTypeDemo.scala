package willem.weiyu.scala.basicType

object BasicTypeDemo {

  def main(args: Array[String]): Unit = {
    println("hello" * 3)
    println("============")
    println(10 max 2)
    println("============")
    println(BigInt(2).pow(3))
    println("============")
    val str =
      """
        hello,
        multi line
        bye
      """
    println(str)
    println("============")

    //var定义变量后，可以更改
    var str1 = "hello"
    str1 = "hey"

    //val定义变量后，无法更改
    val str2 = "hello"
    //str2 = "hey"
  }
}
