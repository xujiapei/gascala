package com.ruozedata.day04

/**
  * Created by xujiapei on 2018/8/12.
  */
object FunctionApp {
  def main(args: Array[String]): Unit = {
    val f=List(List(1,2),List(3,4),List(5,6))
    f.foreach(println)
    f.flatten
    f.flatMap(x =>x)
    f.flatMap(_.map(_*2))





  }

}
