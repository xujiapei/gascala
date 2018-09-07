package com.spark_sql.day02

import org.apache.spark.sql.SparkSession


/**
  * Created by xujiapei on 2018/9/4.
  */
object sql02 {
  def main(args: Array[String]): Unit = {

    val spark=SparkSession.builder().master("local[2]").appName("sql02").getOrCreate()

    import spark.implicits._

    val peopleDF =  spark.sparkContext.textFile("C:\\Users\\xujiapei\\Desktop\\people.txt")
          .map(_.split(","))
            .map(x => Person(x(0),x(1).trim.toInt)).toDF()
//          .collect().foreach(println)
    peopleDF.createOrReplaceTempView("people")
    val teenagersDF = spark.sql("SELECT name, age FROM people WHERE age BETWEEN 13 AND 19")

    teenagersDF.map(x=> "name :" +x(0)).show()

    teenagersDF.map(x=> "name :" +x.getAs("name")).show()

//    implicit val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String, Any]]
//
//    teenagersDF.map(teenager => teenager.getValuesMap[Any](List("name", "age"))).collect()

  }
}

case class Person(name:String,age:Int)