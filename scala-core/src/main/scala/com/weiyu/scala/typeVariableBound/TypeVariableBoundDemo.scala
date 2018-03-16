package com.gome.bigData.demo.typeVariableBound

case class Person(var name : String, var age : Int)

class TypeVariableBound {
  //采用<:进行类型变量界定
  def compare[T <: Comparable[T]](first : T, second : T) ={
    if (first.compareTo(second) > 0)
      first
    else
      second
  }
}

object TypeVariableBoundDemo {

  def main(args: Array[String]): Unit = {
    val tvb = new TypeVariableBound
    println(tvb.compare("A", "B"))

    //下面这一行代码会报错，这是因为Person类并没有实现Comparable接口
    //println(tvb.compare(Person("stephen",19),Person("john",20)))
  }
}
