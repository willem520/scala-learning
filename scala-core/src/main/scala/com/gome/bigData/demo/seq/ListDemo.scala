package com.gome.bigData.demo.seq

/**
  * @author weiyu@gomeholdings.com
  *         list操作
  */
object ListDemo {

  def main(args: Array[String]): Unit = {
    //字符串列表
    var site = List("google", "baidu", "sina")
    println(site.::("twitter"))

    //取第一个元素
    println("第一个元素是：" + site.head)

    //取除第一个元素外的其他元素
    println("剩余元素是：" + site.tail)

    //整形列表
    var nums = 1 :: (2 :: (3 :: (4 :: Nil)))

    //空表
    var empty = Nil

    var site2 = "facebook" :: "taobao" :: Nil

    //使用:::运算符
    println("site:::site2 =" + (site ::: site2))
    //使用Set.:::()方法
    println("site.:::(site2) =" + site.:::(site2))
    //使用concat()方法
    println("List.concat(site,site2) = " + List.concat(site, site2))

    //重复元素2，10次
    println(List.fill(10)(2))

    //List.tabulate
    println(List.tabulate(6) { n => n * n })

    //
    println(site.reverse)
  }
}
