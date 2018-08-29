package com.ruozedata.day01.class_source

/**
  * Created by xujiapei on 2018/7/22.
  */
object RuozeHelloWorld {
  def main(args: Array[String]): Unit = {
//    println("hello 若泽")


//    1.until(10)

//    Range(1,10,0)
    //默认参数
    def loadSparkConf(filename:String ="spark-defualt"): Unit ={

      println(filename)
    }

//    loadSparkConf()
//    loadSparkConf("nihao")

    def teacher(spark:String,linux:String): Unit ={
      println(spark)
      println(linux)
    }
    teacher("ruoze","jepson")
    //变长参数

    def sum(nums:Int*) ={
      var result=0
      for(num <- nums){
        result+=num
      }
      result
    }
    println(sum(2,4,6))

    println(sum(1.to(10):_*))


    println("~~~~")


    def printeacher( teacher : String *){
       for(teachers <-teacher ){
         println(teachers)
       }
    }

    printeacher(Array("1","2"):_*)


  }
}
