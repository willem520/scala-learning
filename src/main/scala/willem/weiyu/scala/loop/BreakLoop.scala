package willem.weiyu.scala.loop

object BreakLoop {

  def main(args: Array[String]): Unit = {
    import scala.util.control.Breaks._
    //类似于continue功能
    for (i <- 0 to 10){
      breakable{
        if (i==5) break
        println("======i:"+i)
      }
    }
    println("******")

    //类似于break功能
    breakable{
      for (i <- 0 to 10){
        if (i==5) break
        println("======i:"+i)
      }
    }
  }
}
