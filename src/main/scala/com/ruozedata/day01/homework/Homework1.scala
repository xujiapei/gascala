package com.ruozedata.day01.homework
import scalikejdbc._
import scalikejdbc.config.DBs

/**
  * Created by xujiapei on 2018/7/28.
  */
object Homework1 {
  def main(args: Array[String]): Unit = {
 //初始化数据库连接
    DBs.setup()
    /** 查询数据并返回单个列, 并将列数据封装到集合中

     */
//    val List:List[String] =DB readOnly { implicit session =>
//      sql"select * from user".map(rs => rs.string("name")).list().apply()
//    }
//    for(s <- List){
//      println(s)
//    }


    /**
      * 查询数据库,并将数据封装成对象,并返回一个集合
      */
    val userses:List[User] =DB readOnly {
      implicit session => sql"select * from user".map(rs => new User(rs.int("id"),rs.string("name"),
        rs.int("age"))).list().apply()
    }
    for (usr <- userses)
      println(usr)

    /**
      * 插入数据, 使用autoCommit
      */
//    val insertResult :Int =DB.autoCommit{ implicit session =>
//      SQL("insert into user(id,name,age) values(2,'小王',5)").bind().update().apply()
//    }
//    println(insertResult) //1表示插入成功


    /**
      * 插入数据, 并返回主键
      */
//    val id: Long = DB.localTx(implicit session => {
//      sql"INSERT INTO user(id, name, age) VALUES (3,'小黑',15)".bind().updateAndReturnGeneratedKey("id").apply()
//    })
//    println(id)

    /**
      * 更新数据
      */

    DB.localTx{
      implicit session => sql"update user set age =99 where id =1 ".bind().update().apply()

    }

    /**
      * 使用事务插入数据库
      */
    val tx:Int =DB.localTx{
      implicit session =>
        sql"Insert into user(id,name,age) values(3,'houhou',100)".bind().update().apply()

    }
    println(s"tx=${tx}")


  }
}
