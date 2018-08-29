package com.ruozedata.day04

/**
  * Created by xujiapei on 2018/8/12.
  */
object MatchApp {
  def main(args: Array[String]): Unit = {

    def greeting (array:Array[String]):Unit={

      array match {
        case  Array("ruoze") =>println("1")
        case  Array(x,y) =>println("2")
        case  Array("ruoze",_*) =>println("3")
        case  _ =>println("4")
      }
    }
    greeting(Array("ruoze","2","312"))



  }
}
