package com.ruozedata.zookeeper.framework;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;


/**
 * Created by xujiapei on 2018/8/26.
 *
 * java操作zk的api
 */
public class Zkconnectjava implements Watcher{
   private static Logger logger = (Logger) LoggerFactory.getLogger(Zkconnectjava.class);

   private static CountDownLatch connected = new CountDownLatch(1);
   public static void main(String[] args) throws Exception{
      ZooKeeper zk =new ZooKeeper("192.168.137.251:2181",5000,new Zkconnectjava());
      logger.warn("客户端连接服务器");
      logger.warn("连接状态:{}",zk.getState());
//     Thread.sleep(10000);
      connected.await(); // <=== 代码就挂起了
      logger.warn("连接状态:{}", zk.getState());
      //创建节点
//      zk.create("/javaconnet","java".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
      //更新节点
//       zk.setData("/javaconnet","hello".getBytes(),0);
//       获取节点
       logger.warn("节点状态:{}",zk.exists("/javaconnet",true));
//       zk连接状态
       logger.warn(zk.getState().toString());
       //节点的子节点
       logger.warn(zk.getChildren("/ruoze",null).toString());
      //删除节点
       zk.delete("/haha",-1);

   }

   @Override
   public void process(WatchedEvent watchedEvent) {
      if(Event.KeeperState.SyncConnected == watchedEvent.getState()) {
         logger.warn("接收到watch通知", watchedEvent);
         connected.countDown(); // ==> 触发await往下走
      }
   }
}
