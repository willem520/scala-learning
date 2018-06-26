package willem.weiyu.scala.basicDataStructure

import scala.collection.immutable.Stack

/**
  * @author weiyu
  * 栈操作
  * @create 2017/11/13
  */
object StackDemo {

  def main(args: Array[String]): Unit = {
    val stack = Stack(1,2,3)

    //出栈
    println(stack.top)

    //入栈
    println(stack.push(5))
  }
}
