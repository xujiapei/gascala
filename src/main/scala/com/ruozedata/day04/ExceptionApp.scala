package com.ruozedata.day04

import java.io.FileNotFoundException

import scala.io.Source

/**
  * Created by xujiapei on 2018/8/12.
  */
object ExceptionApp extends  App{
  try {
//    val i = 1 / 0
     val b =Source.fromFile("d:asdasd")
  }


  catch {
    //模式匹配
    case e:ArithmeticException =>throw new RuntimeException("除数不能为0")
    case e:FileNotFoundException =>println("123")
//    case e:rintln("12")
  }
  finally {

  }
}
