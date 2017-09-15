package com.tianyu.example.hca;

/**
 * Interrupt
 *
 * @Author yu.tian@mtime.com
 * @Date 17/9/15 09:55
 */
public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted");
                    break;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted when sleep");
                    Thread.currentThread().interrupt();
                }
                Thread.yield();
            }
        });

        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
