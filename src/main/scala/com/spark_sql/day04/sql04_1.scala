package com.spark_sql.day04

import org.apache.spark.sql.SparkSession

/**
  * Created by xujiapei on 2018/9/5.
  */
object sql04_1 {
  def main(args: Array[String]): Unit = {
    val spark =SparkSession.builder().master("local[2]").appName("sql04_1").getOrCreate()
    import spark.implicits._
    val likes =spark.sparkContext.textFile("D:\\Data\\TestData\\hobbies.txt")

    val peopledf = likes.map(_.split("\t")).map(x=>Person(x(0),x(1)))
//      .collect().foreach(println)
      .toDF()

    peopledf.printSchema()
    peopledf.show(false)
    peopledf.createOrReplaceTempView("person")

    spark.udf.register("like_nums",(x:String) =>x.split(",").size)

    spark.sql("select name,love,like_nums(love) from person").show(false)

    peopledf.groupBy("name").agg(
      "ca" ->"as"
    )


    spark.stop()
  }
  case class Person(Name:String,love:String)
}
