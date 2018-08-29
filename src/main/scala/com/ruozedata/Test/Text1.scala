package com.ruozedata.Test

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xujiapei on 2018/8/22.
  */
object Text1 {
  def main(args: Array[String]): Unit = {


//    val sparkConf = new SparkConf().setAppName("LogApp").setMaster("local[2]")
//    val sc = new SparkContext(sparkConf)
//    val a = sc.parallelize(1 to 9, 9)
//    a.collect().foreach(println(_))
//
//    sc.stop()
    Iterator(5).foreach(println)
  }
}
