package com.tianyu.example.jmx;

/**
 * ServerMonitor
 *
 * @Author yu.tian@mtime.com
 * @Date 18/8/9 14:03
 */
public class ServerMonitor implements ServerMonitorMBean {
    private final ServerImpl target;
    private final long startTime;

    public ServerMonitor(ServerImpl target) {
        this.target = target;
        startTime = System.currentTimeMillis();
    }

    private Runtime runtime = Runtime.getRuntime();

    public long getUptime() {
        return System.currentTimeMillis()-startTime;
    }
    public String getMemory() {
        float freeMemory = (float)runtime.freeMemory();
        float totalMemory = (float)runtime.totalMemory();
        return "idle scale : "+(freeMemory/totalMemory)+"%; freeMemory="
                +(freeMemory)/(1024*1024)+" MB; totalMemory="+(totalMemory)/(1024*1024)+" MB";
    }
}