package com.gome.bigData.demo.regex

/**
  * @author weiyu@gomeholdings.com
  * 正则表达式
  * @create 2017/11/9
  */
object RegexDemo {

  def main(args: Array[String]): Unit = {
    //验证邮箱
    println("======")
    val mailReg = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$".r
    for (str <- mailReg findAllIn "weiyu@gomeholdings.com") println(str)

    //验证手机号
    println("======")
    val phoneReg = "(86)*0*13\\d{9}".r
    for (str <- phoneReg findAllIn("13566666666")) println(str)

    //IP地址
    println("======")
    val ipReg = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)".r
    for(ipReg(one, two, three, four) <- ipReg findAllIn "192.168.0.1") {
      println("IP子段1："+one)
      println("IP子段2："+two)
      println("IP子段3："+three)
      println("IP子段4："+four)
    }
  }
}
