package com.test_groupId.thread;

/**
 * TestDeadLock
 */
public class TestDeadLock implements Runnable {
    String s1 = "String s1";
    String s2 = "String s2";
    static int c = 0;
    boolean flag = true;

    public TestDeadLock() {
        TestDeadLock t = new TestDeadLock("null");
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.flag = false; 
        t2.start();
    }

    TestDeadLock(String s) {

    }

    public void run() {
        if (flag) {
            System.out.println(Thread.currentThread().getName() + ":flag-" + flag);
            synchronized (s1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s2) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (!flag) {
            System.out.println(Thread.currentThread().getName() + ":flag-" + flag);
            synchronized (s2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s1) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
            System.out.println(Thread.currentThread().getName() + ":" + c++);
    }
}