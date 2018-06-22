package willem.weiyu.scala.traitt

trait Hello{
  def sayHi = println("hello!!!")
}

class People(var name:String,var age:Int)

object TraitDemo {

  def main(args: Array[String]): Unit = {
    // 可以在创建类的对象时，指定该对象混入某个trait，这样，就只有这个对象混入该trait的方法，而类的其他对象则没有
    val p1 = new People("zhangsan",17) with Hello
    p1.sayHi

    val p2 = new People("lisi",20)
    //无此方法
    //p2.sayHi
  }
}
