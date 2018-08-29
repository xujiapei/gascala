package com.ruozedata.day03
import scala.collection.mutable._
/**
  * Created by xujiapei on 2018/7/28.
  */
object ArrayApp {
  def main(args: Array[String]): Unit = {
    val a =new Array[String](5)
    val b = Array("aaa","bbb","ccc")

    for(ele <- b){
      println(ele)
    }

    for(i <- 0.until(b.length)){
      println(b(i))
    }

    val c =new ArrayBuffer()
  }
}
