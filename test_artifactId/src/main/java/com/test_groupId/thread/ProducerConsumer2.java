package com.test_groupId.thread;

/**
 * ProducerConsumer2
 */
public class ProducerConsumer2 {
    public ProducerConsumer2() {
        SyncStack ss = new SyncStack();
        new Thread(new Producer2(ss)).start();
        new Thread(new Consumer2(ss)).start();

    }
}

class Producer2 implements Runnable {

    SyncStack ss = null;

    Producer2(SyncStack s) {
        this.ss = s;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("pro:" + ss.push(new SteamedBun(i))); 
        }
    }
}

class Consumer2 implements Runnable {
    SyncStack ss = null;

    Consumer2(SyncStack s) {
        this.ss = s;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("cons:" +ss.pop());
        }
    }
}

class SteamedBun {
    int id;

    SteamedBun(int i) {
        id = i;
    }
    @Override
    public String toString() {
        return "SteamBun " + id ;
    }
}

class SyncStack {
    SteamedBun[] arrBuns = new SteamedBun[8];
    int index = 0;

    synchronized SteamedBun push(SteamedBun b) {
        while (index == arrBuns.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();

        arrBuns[index] = b;
        index++;
        return b;
    }

    synchronized SteamedBun pop() {
        while (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();

        index--;
        return arrBuns[index];
    }
}
