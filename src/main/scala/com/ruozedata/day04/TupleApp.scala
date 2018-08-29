package com.ruozedata.day04

/**
  * Created by xujiapei on 2018/8/12.
  */
object TupleApp  extends  App{
   val a =(1,2,3,4,5)
   println(a._1+""+a._3)

  val ipPort="192.168.199.151:5601"

  val b=ipPort.split(":")
  println(b(1)+" "+b(0))


  //多行字符串
  val c=
    """
      |1
      |2
      |3
      |4
    """.stripMargin
   println(c)


  val name ="若泽数据"
  //字符串插值
  println(s"hello:$name")













}
