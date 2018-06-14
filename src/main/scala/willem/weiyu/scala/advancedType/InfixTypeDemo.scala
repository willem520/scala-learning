package willem.weiyu.scala.advancedType

case class People[S, T](val name : S, val age : T)

object InfixTypeDemo {

  def main(args: Array[String]): Unit = {
    //下面的代码是一种中置表达方法，相当于val p : People[String, Int]
    val p : String People Int = People("中置类型", 21)

    //中置表达式的模式匹配用法
    //模式匹配时可以直接用常量，也可以直接用变量
    p match {
      case "中置类型1" People 21 => println("matching is ok")
      case name People age => println("name:"+name+" age:"+age)
    }
  }
}
