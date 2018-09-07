package com.spark_sql.day03

import org.apache.spark.sql.SparkSession

/**
  * Created by xujiapei on 2018/9/5.
  */
object sql03_1 {
  def main(args: Array[String]): Unit = {
    val spark =SparkSession.builder().master("local[2]").appName("sql03_1").getOrCreate()
    import spark.implicits._


//    val empRdd =spark.sparkContext.textFile("D:\\Data\\TestData\\emp.txt")

    val studentdf=spark.read.format("text").load("D:\\Data\\TestData\\emp.txt")

//    val sdf=  studentdf.write.format("csv").mode("append")
//      .option("name","sss")
//      .text("D:\\Data\\TestData\\emp1.csv")


      studentdf.rdd.coalesce(1)
          .saveAsTextFile("D:\\Data\\TestData\\haha.txt")

//      .save("D:\\Data\\TestData\\emp1.csv")


//    studentdf.show(false)


     spark.stop()
  }
}
