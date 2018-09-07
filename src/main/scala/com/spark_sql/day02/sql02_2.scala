package com.spark_sql.day02

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types._

/**
  * Created by xujiapei on 2018/9/4.
  */
object sql02_2 {
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().master("local[2]").appName("sql02").getOrCreate()
    import spark.implicits._
    val rdd=spark.sparkContext.textFile("C:\\Users\\xujiapei\\Desktop\\people.txt")
      .map(x=>{
        val columns = x.split(",",3)
        try {
          Row(columns(0),
            columns(1).trim.toInt)
        }catch {
          case _:Exception => Row("",2)
        }
      })



    val structType = StructType(Array(
       StructField("name",StringType,false),
       StructField("age",IntegerType,true)
       )
    )

    val peopleDF=spark.createDataFrame(rdd,structType)

    peopleDF.createOrReplaceTempView("people")
    spark.sql("select * from people").show()

//    println(peopleDF.count())
    spark.stop()
  }
}
