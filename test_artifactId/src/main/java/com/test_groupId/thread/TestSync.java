package com.test_groupId.thread;

/**
 * TestSync
 */
public class TestSync implements Runnable {
    SyncRunner r = new SyncRunner();
    boolean flag = false;// static

    public TestSync() {
        // System.out.println(r);
        TestSync t = new TestSync("null");
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        // System.out.println(r);

        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = true;
        t2.start();
    }

    TestSync(String s) {

    }

    public void run() {
        if (!flag) {

            r.hi(Thread.currentThread().getName());
        } else {
            r.hi2();
        }
    }

}

class SyncRunner {
    private static int c = 0;

    synchronized void hi(String name) {
        // String name = Thread.currentThread().getName();

        // synchronized (this) {
        c++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + ": " + c);
        // }
    }

    // synchronized
     void hi2() {
        // c++;
        System.out.println("hi2");
    }
}