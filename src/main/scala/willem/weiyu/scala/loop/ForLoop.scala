package willem.weiyu.scala.loop

/**
  * @author weiyu
  * for循环
  * @create 2017/11/7
  */
object ForLoop {

  def main(args: Array[String]): Unit = {
    //简单for循环
    for (i <- 0 to 10)
      println("======i:"+i)
    println("======")

    //双重for循环
    for(i <- 0 to 5; j <- 0 to 5)
      println("======i:"+i+",j:"+j)
    println("======")

    //带守卫的for循环
    for (i <- 0 to 10 if i%2 == 0)
      println("======i:"+i)
  }
}
