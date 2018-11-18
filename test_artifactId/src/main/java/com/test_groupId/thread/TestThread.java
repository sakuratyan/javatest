package com.test_groupId.thread;

/**
 * TestThread
 */
public class TestThread {
    public TestThread(){
        Runner r = new Runner();
        // r.run();
        Thread t= new Thread(r);
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("TestThread :" + i);
        }

    }
}

/**
 * InnerTestThread
 */
class Runner implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runner :" + i);
        }
    }

}