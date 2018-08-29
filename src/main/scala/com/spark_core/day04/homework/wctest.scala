package com.spark_core.day04.homework

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

import scala.io.Source

/**
  * Created by xujiapei on 2018/8/24.
  */
object wctest extends  App{
      val sparkConf = new SparkConf().setAppName("LogApp").setMaster("local[2]")
      val sc = new SparkContext(sparkConf)


      val rdd =sc.textFile("E:\\个人整理文档\\emp.txt")
      val result=rdd.flatMap(_.split("\n")).map(x => (x.split("\t")(4).split("-")(0),x))
        .partitionBy(new HashPartitioner(3))
        .saveAsHadoopFile("G:\\高级班学习\\spark_core\\homework\\day04\\", classOf[String], classOf[String],
          classOf[RDDMultipleTextOutputFormat])
//      /result.repartition(1).saveAsTextFile("E:\\个人整理文档\\test.txt")

//
//      val map=result.collectAsMap()
//
//      for((k,v) <- map){
//        println(k,v)
//      }



     sc.stop()
}
