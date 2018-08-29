package com.ruozedata.day03

/**
  * Created by xujiapei on 2018/7/28.
  * 1)object 的类不需要new可以直接使用
  * 2)类似于静态类
  */
object Timer {
   var count=0
  def currentCount():Long={
    count=count+1 //count+=1
    count
  }

  def main(args: Array[String]): Unit = {
    println(Timer.currentCount())
    println(Timer.currentCount())
    println(Timer.currentCount())
  }
}

class Timer{

}
