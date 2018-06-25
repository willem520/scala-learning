package willem.weiyu.scala.array

import scala.collection.mutable.ArrayBuffer

/**
  * @author weiyu
  * 变长数组
  * @create 2017/11/13
  */
object ArrayBufferDemo {

  def main(args: Array[String]): Unit = {
    val arrBuf = ArrayBuffer[String]()

    //+=在尾部添加元素
    arrBuf += "hey"

    //添加多个元素
    arrBuf +=("hi","hello")

    //++=添加集合
    arrBuf ++= Array("this", "is", "a", "test")

    //删除末尾n个元素
    arrBuf.trimEnd(2)

    arrBuf.foreach(println)
  }
}
