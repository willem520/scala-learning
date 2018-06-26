package willem.weiyu.scala.advancedType

class Person {
  private var name : String = null
  private var age : Int = 0

  //this.type返回实际类型
  def setName(name : String) : this.type ={
    this.name = name
    this
  }

  def setAge(age : Int) : this.type ={
    this.age = age
    this
  }

  override def toString: String = "name:"+name+" age:"+age
}

class Student extends Person{
  private var studentNo : String = null

  def setStudentNo(studentNo : String):this.type ={
    this.studentNo = studentNo
    this
  }

  override def toString: String = super.toString+" studentNo:"+studentNo
}

object ThisTypeDemo {

  def main(args: Array[String]): Unit = {
    println(new Student().setName("john").setAge(22).setStudentNo("no0001"))
  }
}
