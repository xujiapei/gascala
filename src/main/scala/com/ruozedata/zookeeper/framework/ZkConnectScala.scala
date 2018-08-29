package com.ruozedata.zookeeper.framework

import java.util.concurrent.CountDownLatch

import org.apache.log4j.Logger
import org.apache.zookeeper.Watcher.Event
import org.apache.zookeeper._
import org.apache.zookeeper.data.Stat
import org.slf4j.LoggerFactory


/**
  * Created by xujiapei on 2018/8/27.
  * scala源生操作zk的api
  *
  */
object ZkConnectScala {
  private val logger = LoggerFactory.getLogger(ZkConnectScala.getClass)
   val connected = new CountDownLatch(1)
  def main(args: Array[String]): Unit = {
    val zk =new ZooKeeper("192.168.137.251:2181",5000,new ZkConnectScala());
    println(zk.getState)
//    connected.await(); // <=== 代码就挂起了
    Thread.sleep(10000)
    println(zk.getState)
      //创建节点
//    zk.create("/scalaconnect","scala".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    //获取子节点
    List(zk.getChildren("/scalaconnect",null)).foreach(println)
   //获取节点的值
    val stat =new Stat()
    logger.warn(new String(zk.getData("/scalaconnect",null,stat)))
    //节点是否存在
    logger.warn(zk.exists("/scalaconnect",true).toString)
    //修改节点值
//    zk.setData("/scalaconnect","scala_change1".getBytes(),1)
//    logger.warn(new String(zk.getData("/scalaconnect",null,stat)))

    //删除节点,注意这里是数据的版本号
    zk.delete("/scalaconnect",2)
    zk.close()
  }
}

class ZkConnectScala extends Watcher{

  def process(watchedEvent: WatchedEvent) {
//          if(Event.KeeperState.SyncConnected == watchedEvent.getState()) {
//             logger.warn("接收到watch通知", watchedEvent);
//             connected.countDown(); // ==> 触发await往下走
//          }
  }
}