package com.ruozedata.day01.homework

import java.sql.{Connection, DriverManager}



/**
  * Created by xujiapei on 2018/7/23.
  */
 class User (val id:Int,val name:String,val age:Int ){
   println("user start")

//   def hell0={
//     println("hell0")
//   }
//   /hell0

   println("user leave")
}
object User {
  def main(args: Array[String]): Unit = {
    //新建一个对象

    val u1=new User(1,"小明",8)

    //数据库连接
    val driver="com.mysql.jdbc.Driver"
    val url ="jdbc:mysql://localhost:3306/g3spark"
    val username ="root"
    val password ="123456"
    var connection:Connection=null
   try {
     Class.forName(driver)
     connection = DriverManager.getConnection(url, username, password)

     //    println(u1.id,u1.name,u1.age)
     val statement = connection.createStatement()
//     val sql = "Insert into  user values('" + u1.id + "','" + u1.name + "','" + u1.age + "')"
//      statement.executeUpdate(sql)
//
     val sql1="select * from user"

     val resultSet =statement.executeQuery(sql1)
         while (resultSet.next()) {
           println(resultSet.getString("id"))
           println(resultSet.getString("name"))
           println(resultSet.getString("age"))
         }
   }
    catch {
      case e=>e.printStackTrace()
    }
    finally {
        connection.close()
    }
  }


}
