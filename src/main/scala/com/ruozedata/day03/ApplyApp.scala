package com.ruozedata.day03

/**
  * Created by xujiapei on 2018/7/28.
  * 伴生对象和类一般写在一个类中
  */
object ApplyApp {
  println("alllyapp object enter")

  var count=0;

  def inscr: Unit ={
    count+=1
  }

  def static(): Unit ={
    println("hahah")
  }
  println("alllyapp object leace")
}

class ApplyApp{

}

object Applytest{
  def main(args: Array[String]): Unit = {
//    ApplyApp.static()

    val a =new ApplyApp()
    println(a)

  }
}