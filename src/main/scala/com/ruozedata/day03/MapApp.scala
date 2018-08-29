package com.ruozedata.day03
import scala.collection.mutable.HashMap
/**
  * Created by xujiapei on 2018/7/28.
  */
object MapApp extends App{
   val a=Map("ruoze" ->30,"jepson" ->18)
//   a.getOrElse("asdasd",30)

  for((key,value) <-a ){
    println(key+"~~"+value)
  }

  Iterator
}
