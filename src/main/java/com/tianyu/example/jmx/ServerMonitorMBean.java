package com.tianyu.example.jmx;

/**
 * ServerMonitorMBean
 *
 * @Author yu.tian@mtime.com
 * @Date 18/8/9 14:05
 */
public interface ServerMonitorMBean {
    public long getUptime();
    public String getMemory();
}