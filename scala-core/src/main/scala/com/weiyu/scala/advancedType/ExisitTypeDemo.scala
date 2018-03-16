package com.gome.bigData.demo.advancedType

/**
  * @author weiyu@gomeholdings.com
  * @create 2017/11/17
  */
object ExistTypeDemo {

  def print(x:Array[_]) = println(x)

  def print2(x:Array[T] forSome {type T}) = println(x)

  //Map[_,_]相当于Map[T,U] forSome {type T;type U}
  def print3(x:Map[_,_]) = println(x)

  def main(args: Array[String]): Unit = {
    print(Array("Google","Baidu","Twitter","Facebook"))

    println("======")
    print2(Array("Google","Baidu","Twitter","Facebook"))

    println("======")
    print3(Map(1 ->"Google",2->"Baidu",3->"Twitter",4->"Facebook"))
  }
}
