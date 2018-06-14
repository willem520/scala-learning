package willem.weiyu.scala.caseClass

abstract class Person

case class Student(name : String, age : Int, studentNo : Int) extends Person

case class Teacher(name : String, age : Int, teacherNo : Int) extends Person

case class Nobody(name : String) extends Person

//SchoolClass为接收多个Person类型参数的类
case class SchoolClass(classDescription : String, person : Person*)

object CaseClassDemo {

  def main(args: Array[String]): Unit = {
    //case class会自动生成apply方法，从而省去new操作
    val sc = SchoolClass("测试",Teacher("老师",34,1000),Student("学生",21,1001))
    sc match {
      case SchoolClass(_,_,Student(name, age, studentNo)) => println(name+":"+age+":"+studentNo)
      case _ => println("Nobody")
    }
  }
}
