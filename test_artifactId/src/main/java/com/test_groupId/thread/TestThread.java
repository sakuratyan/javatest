package com.test_groupId.thread;

/**
 * TestThread
 */
public class TestThread {
    public TestThread(){
        // testRunner();
        testRunner2();
    }
    void testRunner(){
        Runner r = new Runner();
        // r.run();
        Thread t= new Thread(r);
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("TestThread :" + i);
        }
    }

    void testRunner2(){
        Runnner2 r= new Runnner2();
        r.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("TestThread :" + i);
        }
    }
}



//这个方法好一点，还可以继承其他类
class Runner implements Runnable {
    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runner :" + i);
        }
    }

}
class Runnner2 extends Thread{
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runner :" + i);
        }
    }

/**
 * 
 *     What will be run.
   private Runnable target;
   target.run();
 * 
 */
    // void test(Runnable a){
    //     this.run = a.run;
    // }
}