package willem.weiyu.scala

// 重命名成员
import java.util.{HashMap => JHashMap}
// 引入java.util包的所有成员，但隐藏ArrayList
import java.util.{ArrayList => _,_}
/**
  * @author weiyu
  * @create 2017/9/16
  * 默认情况下，Scala总会引入java.lang._ 、scala._和Predef._
  */
object HelloScala {

  def main(args: Array[String]): Unit = {
    val map :JHashMap[String, String] = new JHashMap[String,String]()
    println("======Hello Scala!")
  }
}
