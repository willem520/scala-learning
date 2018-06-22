package willem.weiyu.scala.clazz

/**
  * 对于var修饰的参数：外部可读/可改写 （实际上是：编译器为该类参数（字段）自动生成了getter和setter）
  * 对于val修饰的参数：外部可读/不可改写（实际上是：编译器为该类参数（字段）只生成了getter没有生成setter）
  * 对于private var修饰的参数：内部可读/可改写 （编译器不会为私有类参数（字段）自动生成getter和setter）
  * 对于private val修饰的参数：内部可读/不可改写 （编译器不会为该类参数（字段）自动生成getter和setter）
  *
  * @param str
  */
class ConstructorDemo(val str: String){
  println(str)
}

object ClassConstructorDemo {

  def main(args: Array[String]): Unit = {
    val demo = new ConstructorDemo("hello")
    println(demo.str)
  }
}
