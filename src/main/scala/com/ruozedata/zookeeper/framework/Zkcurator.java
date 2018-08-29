package com.ruozedata.zookeeper.framework;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xujiapei on 2018/8/28.
 * 通过curator操作ZK
 */
class Zkcurator {
    private static Logger logger = (Logger) LoggerFactory.getLogger(Zkconnectjava.class);
        public static  void main(String[] args) throws  Exception{
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            CuratorFramework client =
                    CuratorFrameworkFactory.builder()
                            .connectString("192.168.137.251:2181")
                            .sessionTimeoutMs(10000)
                            .connectionTimeoutMs(10000)
                            .retryPolicy(retryPolicy)
                            .build();
            //启动客户端
            client.start();
            Thread.sleep(10000);
//            logger.warn(client.getState().toString());
            //创建节点
//            client.create().creatingParentContainersIfNeeded()
//                    .withMode(CreateMode.PERSISTENT).forPath("/haha/curator","curator_haha".getBytes());
            //删除节点
//            client.delete().guaranteed().forPath("/haha/curator");
            //读取节点数据
//            byte[] b1=client.getData().forPath("/curator");
//            logger.warn("节点数据:{}",new String(b1));
            //更新节点数据
            //             client.setData().forPath("/haha","haha".getBytes());

//            logger.warn(client.checkExists().forPath("/haha").toString());

//             client.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT)
//                     .inBackground().forPath("/hwhwhw1");






        }


}
