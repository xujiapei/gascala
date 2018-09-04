import org.apache.spark.sql.SparkSession

/**
  * Created by xujiapei on 2018/9/3.
  */
object sql01 {
  def main(args: Array[String]): Unit = {

//    val conf = new SparkConf().setAppName("SplitTest").setMaster("local[2]")
//    val sc = new SparkContext(conf)
    val spark = SparkSession
      .builder()
      .appName("sparksql")
      .master("local[2]")
      .getOrCreate()
    val df = spark.read.json("C:\\Users\\xujiapei\\Desktop\\people.json")
    // val df =spark.read.format("json").load("C:\\Users\\xujiapei\\Desktop\\people.json")
    import spark.implicits._  //注意这里不是spark不是某个类，而是上面的变量 但是为什么这样子写呢
//    df.show()
    //展示元数据信息
    df.printSchema()

//    df.select("name").show()
   df.select($"name" , $"age" + 1).show(2)
    df.filter($"age" >20).show(1)

    df.groupBy("age").count().show()
    //临时视图，针对于当前session有效
//    df.createOrReplaceTempView("people_tmp")
////    spark.sql("select * from people_tmp").show()
//    //全局视图，针对于application级别有效
//    df.createOrReplaceGlobalTempView("people_global")
//    spark.newSession().sql("select * from global_temp.people_global").show()
//    spark.newSession().sql("select * from people_tmp").show()







    spark.close()

  }
}
