package com.ruozedata.day03

/**
  * Created by xujiapei on 2018/7/28.
  *
  * case class
  * 1)不需要new可以直接使用
  * 2)模式匹配
  */
object CaseClassApp {
  def main(args: Array[String]): Unit = {
    println(Dog("够").name)
  }
}


case class Dog(name:String)