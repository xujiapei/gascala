package com.ruozedata.day02.homework

import common.io.{ReadWriteFormat, SaveMode, TraversableIO}

import scala.collection.mutable.ListBuffer
import scala.reflect.ClassTag

/**
  * Created by xujiapei on 2018/8/20.
  */
object ScalaIOApp {
  def main(args: Array[String]): Unit = {

    /**
      * 封装 Scala Traversable IO
      * 作业: 输出一百万条  Data(domain: String,traffic: String,time: Date) 到文本文件
      */

    implicit def traversableSaveToFile[T: ClassTag](value: Traversable[T]) = TraversableIO(value);

    val list = ListBuffer[Data]()
    for (i <- 1 to 1000000) {
      list += Data.randomTestData
    }

    list
      .writer
      .format(ReadWriteFormat.Text)
      .mode(SaveMode.Overwrite)
      .text("D:\\data\\TestData\\data.txt")


    println("输出完毕")
  }

}
