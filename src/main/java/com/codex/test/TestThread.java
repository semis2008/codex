package com.codex.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ningwang4 on 16/11/1.
 */
public class TestThread{


    private Lock threadLock = new ReentrantLock();

    private boolean flag = false;

    int count =65;//A-Z 65-90   a-z 97-123

    Thread aThread = new Thread(new Runnable() {
        public void run() {
            while (true) {
                // 锁定
                threadLock.lock();
                try {
                    if ( count > 90) {
                        return;
                    }
                    if (flag) {
                        // aThread的任务
                        System.out.println("aThread --> " + (char)count++);
                        flag = !flag;
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    // 释放锁
                    threadLock.unlock();
                }
            }
        }
    });

    Thread bThread = new Thread(new Runnable() {
        public void run() {
            while (true) {
                // 锁定
                threadLock.lock();
                try {
                    if ( count >90 ) {
                        return;
                    }
                    if (!flag) {
                        // aThread的任务
                        System.out.println("bThread --> " + (char)count++);
                        flag = !flag;
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    // 释放锁
                    threadLock.unlock();
                }
            }
        }
    });

    public void startTwoThread() {
        aThread.start();
        bThread.start();
    }

    public static void main(String[] args) {
        TestThread twoThreadPrinter = new TestThread();
        twoThreadPrinter.startTwoThread();
    }

}
