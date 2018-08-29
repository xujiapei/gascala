package com.ruozedata.day04

import scala.io.Source

/**
  * Created by xujiapei on 2018/8/12.
  */
object FileApp extends App{
//   val file =Source.fromFile()

  def sum(a:Int,b:Int)=a+b
  //currying 将原来接受的两个参数拆分
  def sum2(a:Int)(b:Int)=a+b

  println(sum(2,2))
  println(sum2(2)(4))

/*
*
*
* */

  def readXML()={
    println(12)
  }

  def readAPI():Unit={
    val context =Source.fromURL("http://www.baidu.com")

    for(line <- context.getLines()){
      println(line)
    }

  }
  readAPI()


}
