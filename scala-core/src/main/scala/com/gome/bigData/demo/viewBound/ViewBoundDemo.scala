package com.gome.bigData.demo.viewBound

//用<%来进行视图界定
case class Student[T,S <% Comparable[S]](var name : T, var height : S)

object ViewBoundDemo {

  def main(args: Array[String]): Unit = {
    val s = Student("john","170")
    //下面这条语句在视图界定中是合法的，
    //因为Int类型此时会隐式转换为RichInt类，
    //而RichInt类属于Comparable继承层次结构
    val s2 = Student("john",170)
  }
}
