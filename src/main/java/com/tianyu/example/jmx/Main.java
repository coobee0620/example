package com.tianyu.example.jmx;

import javax.management.MBeanInfo;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import java.util.Arrays;

/**
 * Main
 *
 * @Author yu.tian@mtime.com
 * @Date 18/8/9 14:07
 */
public class Main {
    private static MBeanServer mBeanServer;
    public static void main(String[] args) throws Exception{
        init();
        manage();

//        Thread.sleep(100000L);
    }
    private static void init() throws Exception{
        ServerImpl serverImpl = new ServerImpl();
        ServerMonitor serverMonitor = new ServerMonitor(serverImpl);
        mBeanServer = MBeanServerFactory.createMBeanServer();
        ObjectName objectName = new ObjectName("objectName:id=ServerMonitor1");
        mBeanServer.registerMBean(serverMonitor,objectName);

//        Runtime runtime = Runtime.getRuntime();
//        runtime.addShutdownHook(new Thread(()->{
//            try {
//                manage();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }));
    }
    private static void manage() throws Exception{
        ObjectName theObjectName = new ObjectName("objectName:id=ServerMonitor1");
        Long upTime = (Long) mBeanServer.getAttribute(theObjectName,
                "Uptime");
        System.out.println(mBeanServer.getMBeanCount());

        MBeanInfo mBeanInfo = mBeanServer.getMBeanInfo(theObjectName);
        System.out.println(mBeanInfo.getClassName());
        String memory = (String)mBeanServer.getAttribute(theObjectName,"Memory");
        System.out.println(upTime);
        System.out.println(memory);
    }
}