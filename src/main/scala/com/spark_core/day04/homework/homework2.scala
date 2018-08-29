package com.spark_core.day04.homework

import org.apache.spark._
import org.apache.spark.SparkContext._


import org.apache.hadoop.mapred.lib.MultipleTextOutputFormat

/**
  * Created by xujiapei on 2018/8/24.
  */
class RDDMultipleTextOutputFormat extends MultipleTextOutputFormat[Any, Any] {
  override def generateFileNameForKeyValue(key: Any, value: Any, name: String): String =
    key.asInstanceOf[String]
}



object homework2 {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SplitTest").setMaster("local[2]")
    val sc = new SparkContext(conf)
    sc.parallelize(List(("w", "www"), ("b", "blog"), ("c", "com"), ("w", "bt")))
      .map(value => (value._1, value._2 + "Test"))
      .partitionBy(new HashPartitioner(3))
      .saveAsHadoopFile("E:\\个人整理文档\\22\\", classOf[String], classOf[String],
        classOf[RDDMultipleTextOutputFormat])
    sc.stop()
  }
}
