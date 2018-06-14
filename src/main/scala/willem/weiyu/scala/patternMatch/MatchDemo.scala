package willem.weiyu.scala.patternMatch

/**
  * @author weiyu@gomeholdings.com
  * 简单模式匹配
  * @create 2018/02/24
  */
object MatchDemo {

  def numMatch(): Unit ={
    for(i <- 1 to 20){
      i%2 match {
        case 0 => println(i+" is even")
        case _ => println(i+" is odd")
      }
    }
  }

  def numMatch2(): Unit ={
    for(i <- 1 to 20){
      i match {
          //守卫条件
        case _ if i % 3 == 0 => println(i+"可以被3整除")
        case _ if i % 5 == 0 => println(i+"可以被5整除")
        case _ => //无此行运行会报错
      }
    }
  }

  def constantPattern(x : Any): String ={
    x match {
      case 5 => "five"
      case true => "true"
      case "test" => "String"
      case null => "null"
      case Nil => "empty list"
      case _  => "Other constant"
    }
  }

  def variablePattern(x : Any) : Any = x match {
    case 5 => "five"
    case y => y
  }

  case class Person(name : String, age : Int)
  def constructorPattern(p : Person): String = p match {
    case Person(_,_) => "Person"
    case _ => "Other"
  }

  def sequencePattern(p : List[String])= p match {
    case List(_,second,_*) => second
    case _ => "Other"
  }

  def tuplePattern(p : Any) = p match {
    case (one, _, _) => one
    case _ => "Other"
  }

  def typePattern(x : Any)= x match {
    case _: String => "String"
    case _ : Int => "Int"
    case _ : Double => "Double"
  }

  def variableBindingPattern(x : Any) = x match {
    //变量绑定，采用变量名（这里是e)
    //与@符号，如果后面的模式匹配成功，则将
    //整体匹配结果作为返回
    case List(_, e@List(_, _, _)) => e
    case _ => Nil
  }

  def patternInForLoop(x : Map[Any, Any])= {
    for((nation, capital) <- x)
      println(nation+":"+capital)
  }

  def main(args: Array[String]): Unit = {
    //常量模式
    println("******常量模式******")
    println(constantPattern(5))


    //变量模式
    println("******变量模式******")
    println(variablePattern("xxx"))

    //构造器模式
    println("******构造器模式******")
    println(constructorPattern(Person("dave",21)))

    //序列模式
    println("******序列模式******")
    println(sequencePattern(List("spark","hive","sparkSql")))

    //元组模式
    println("******元组模式******")
    println(tuplePattern(("spark","hive","sparkSql")))

    //类型模式
    println("******类型模式******")
    println(typePattern(5.2))

    //类型模式
    println("******变量绑定模式******")
    println(variableBindingPattern(List(List(1,2,3),List(2,3,4))))

    //for循环中的模式匹配
    println("******for循环中的模式匹配******")
    println(patternInForLoop(Map("China"->"Beijing","American"->"Washington DC")))
  }
}
