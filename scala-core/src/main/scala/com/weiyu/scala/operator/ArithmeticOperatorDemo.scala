package com.gome.bigData.demo.operator

/**
  * @author weiyu@gomeholdings.com
  * 算数运算符
  * @create 2017/11/7
  */
object ArithmeticOperatorDemo {
  def main(args: Array[String]): Unit = {
    val a = 10
    val b = 20
    val c = 25
    println("a + b = "+(a+b))
    println("a - b = "+(a-b))
    println("a * b = "+(a*b))
    println("b / a = "+(b/a))
    println("b % a = "+(b%a))
    println("c % a = "+(c%a))
  }
}
