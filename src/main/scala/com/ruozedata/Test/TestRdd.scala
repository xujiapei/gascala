package com.ruozedata.Test

import org.apache.spark._

/**
  * Created by xujiapei on 2018/8/22.
  */
object TestRdd {
  def sumOfEveryPartition(input: Iterator[Int]): Int = {
    var total = 0
    input.foreach { elem =>
      total += elem
    }
    total
  }
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Rdd Test").setMaster("local[2]")
    val spark = new SparkContext(conf)
//    val input = spark.parallelize(List(1, 2, 3, 4, 5, 6), 2)//RDD有6个元素，分成2个partition
//    val result = input.mapPartitions(
//      partition => Iterator(sumOfEveryPartition(partition))
//
//    )//partition是传入的参数，是个list，要求返回也是list，即Iterator(sumOfEveryPartition(partition))
//
//    result.foreach {
//      println(_)//6 15
//    }

    val a = spark.parallelize(1 to 10, 3)

    val b = a.map(myfuncPerElement).collect
    val c =  a.mapPartitions(myfuncPerPartition).collect

    spark.stop()
  }
  //map的输入函数，其参数e为rdd元素值
  def myfuncPerElement(e:Int):Int = {
    println("e="+e)
    e*2
  }
  //mapPartitions的输入函数。iter是分区中元素的迭代子，返回类型也要是迭代子
  def myfuncPerPartition ( iter : Iterator [Int] ) : Iterator [Int] = {
    println("run in partition")
    var res = for (e <- iter ) yield e*2
    res
  }

}
