package com.ruozedata.day05

/**
  * Created by xujiapei on 2018/7/26.
  */
object Dog {
  def main(args: Array[String]): Unit = {
    implicit def dogTosuperdog(dog:Dog):SuperDog=new SuperDog("joey")
    val d1=new Dog("巨人")
    d1.speak()
    println("~~~~~~")
    d1.say()
  }
}

class  Dog(val name :String){
   def speak(): Unit ={
     println(name +" welcome to nba")
   }
}

class  SuperDog (val name :String){
  def say(): Unit ={
    println(name +"   all star")
  }
}