package willem.weiyu.scala.basicDataStructure

import com.alibaba.fastjson.JSON
import scala.collection.JavaConversions._
/**
 * @Author weiyu005@ke.com
 * @Description
 * @Date 2019/8/1 17:59
 */
object JsonDemo {

  def main(args: Array[String]): Unit = {
    val str = "{\"hello\":\"123\"}"
    val json = JSON.parseObject(str).toMap
    val map = json
    map.foreach(item => {
      println(item._1, item._2)
    })
  }
}
