package willem.weiyu.scala.clazz

/**
  * 对于var修饰的参数：外部可读/可改写 （实际上是：编译器为该类参数（字段）自动生成了getter和setter）
  * 对于val修饰的参数：外部可读/不可改写（实际上是：编译器为该类参数（字段）只生成了getter没有生成setter）
  * 对于private var修饰的参数：内部可读/可改写 （编译器不会为私有类参数（字段）自动生成getter和setter）
  * 对于private val修饰的参数：内部可读/不可改写 （编译器不会为该类参数（字段）自动生成getter和setter）
  *
  */
class Person1(var firstName:String, var lastName:String){
  println("the constructor begins")
  private val HOME = "/root"
  var age = 30

  override def toString = s"$firstName $lastName is $age years old"

  def printHome = println(s"HOME = $HOME")

  def printFullName= println(this)

  printHome
  printFullName
  println("still in the constructor")
}

class Person2{
  var age = 30
  val gender = "male"
  private val healthy = false
}

class Person3(var age:Int, val gender:String, private val healthy:Boolean)

class Person4(private var _age:Int){
  def age = _age // this is getter
  def age_=(newAge: Int) = _age = newAge //this is setter
}

object ClassConstructorDemo {

  def main(args: Array[String]): Unit = {
    val p1 = new Person1("willem", "wei")
    println("============")

    val p2 = new Person2
    println(p2.age)
    p2.age = 40
    println(p2.age)
    println(p2.gender)
    //error, no setter for gender
    //p2.gender = "female"
    //error, invisible out of class
    //println(p2.healthy)
    println("============")

    val p3 = new Person3(20,"female",true)
    println(p3.age)
    p3.age = 30
    println(p3.age)
    println(p3.gender)
    //error, no setter for gender
    //p3.gender = "male"
    //error, invisible out of class.
    //println(p3.healthy)
    println("============")

    val p4 = new Person4(30)
    println(p4.age)
    p4.age = 40
    println(p4.age)
  }
}
