package willem.weiyu.scala.seq

import scala.collection.immutable.Queue

/**
  * @author weiyu
  * 队列操作
  * @create 2017/11/13
  */
object QueueDemo {

  def main(args: Array[String]): Unit = {
    var que = Queue(1,2,3)

    //出队
    println(que.dequeue)

    //入队
    println(que.enqueue(4))
  }
}
