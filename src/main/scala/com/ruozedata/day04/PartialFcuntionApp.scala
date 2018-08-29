package com.ruozedata.day04

/**
  * Created by xujiapei on 2018/8/12.
  */
object
 PartialFcuntionApp extends App{
  def greeting :PartialFunction[Array[String],String]={


      case  Array("ruoze") =>"1"
      case  Array(x,y) =>"2"
      case  Array("ruoze",_*) =>"3"
      case  _ =>"4"

  }
  println(greeting(Array("ruoze")))
}
