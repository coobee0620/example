package com.tianyu.example.hca.jdkconcurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantIntLock
 *
 * @Author yu.tian@mtime.com
 * @Date 17/9/27 09:15
 */
public class ReentrantIntLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    public ReentrantIntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock ==1) {
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread())
                lock1.unlock();
            if (lock2.isHeldByCurrentThread())
                lock2.unlock();

            System.out.println(Thread.currentThread().getId() + "线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantIntLock r1 = new ReentrantIntLock(1);
        ReentrantIntLock r2 = new ReentrantIntLock(2);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        Thread.sleep(1000);

        t2.interrupt();
    }
}
