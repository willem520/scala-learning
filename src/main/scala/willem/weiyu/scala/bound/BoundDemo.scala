package willem.weiyu.scala.bound

class Pair1[T](val first : T, val second : T){
  //下界通过[R >: T]的意思是泛型R的类型必须是T的超类
  def replaceFirst[R >: T](newFirst : R) = new Pair1[R](newFirst, second)

  override def toString: String = first+"---"+second
}

class Book(val name :String){
  override def toString: String = "name--"+name
}

class Ebook(name : String) extends Book(name)

class Pbook(name : String) extends Book(name)

class WeirdBook(name : String) extends Pbook(name)

object BoundDemo {

  def main(args: Array[String]): Unit = {
    val first = new Ebook("hello")
    val second = new Pbook("hey")
    val p1 = new Pair1(first, second)
    println(p1)

    val newFirst = new Book("generic")
    val p2 = p1.replaceFirst(newFirst)
    println(p2)

    val weirdFirst = new WeirdBook("weird")
    val p3 = p1.replaceFirst(weirdFirst)
    println(p3)

    val p4 = new Pair1(second,second)
    println(p4)

    val thirdBook=new Book("Super Books")
    val p5=p4.replaceFirst(thirdBook)
    println(p5)

    //下面这条语句会报错
    //type mismatch; found : cn.scala.xtwy.lowerbound.Pair1[cn.scala.xtwy.lowerbound.Pbook] required: cn.scala.xtwy.lowerbound.Pbook
    //val p6:Pbook=p4.replaceFirst(weirdFirst)
  }
}
