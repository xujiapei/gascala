package com.spark_core.day04.homework

import scala.collection.mutable.HashMap
import scala.io.Source

/**
  * Created by xujiapei on 2018/8/24.
  */
object homework1 {
  def main(args: Array[String]): Unit = {
     val file =Source.fromFile("E:\\个人整理文档\\emp.txt")
     var m2= new HashMap[String,String]()

     for ( line <- file.getLines()){

      val array =line.split("\t")
      m2 += (array(4).split("-")(0) -> line)




     }
    file.close()
  }
}
