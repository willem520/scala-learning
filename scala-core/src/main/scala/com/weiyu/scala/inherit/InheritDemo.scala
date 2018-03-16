package com.gome.bigData.demo.inherit

class Person(name: String, age: Int) {
  println("======constructing Person")

  def walk(): Unit = println("walk like a normal person")
}

class Student(name: String, age: Int, var studentNo: String) extends Person(name, age) {
  println("======constructing Student")

  override def walk(): Unit = {
    super.walk()
    println("walk like a elegant swan")
  }

  def say(): Unit ={
    println("this is "+name+" and age is "+age+" and studentNo is "+studentNo)
  }
}

object InheritDemo {

  def main(args: Array[String]): Unit = {
    val student = new Student("john", 18, "1024")
    student.say()
    student.walk()
  }
}
