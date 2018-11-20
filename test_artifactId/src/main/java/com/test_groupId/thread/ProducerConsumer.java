package com.test_groupId.thread;

/**
 * ProducerConsumer
 */
public class ProducerConsumer implements Runnable {
    Bun bun = new Bun(0);

    enum Aenumclass {
        producer, consumer
    };

    Aenumclass swho = Aenumclass.producer;

    public ProducerConsumer() {
        ProducerConsumer pc = new ProducerConsumer("null");
        addPro(pc);
        /** 非常坑爹，线程启动那么慢吗！
         * 所以紧接着就main执行下一句 addCon的第一句覆盖了swho.
        */
        addCon(pc);
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("bun num:"+pc.bun.getid());
        }
    }

    ProducerConsumer(String s) {

    }

    public void run() {
        switch (swho) {
        case producer:
            Producer pro = new Producer(1);
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pro.produce(bun);
            }
            // break;
        case consumer:
            Consumer con = new Consumer(4);
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                con.eat(bun);
            }
            // break;
        default:
            break;
        }
    }

    void addPro(ProducerConsumer pc) {
        pc.swho =Aenumclass.producer;
        Thread t = new Thread(pc);
        t.start();
    }

    void addCon(ProducerConsumer pc) {
        pc.swho =Aenumclass.consumer;
        Thread t = new Thread(pc);
        t.start();
    }

}

// steamed bun
class Bun {
    int id;

    Bun(int i) {
        id = i;
    }

    synchronized int add(int i) {
        id += i;
        return 0;
    }

    synchronized int sub(int i) {
        id -= i;
        return 0;
    }

    int getid() {
        return id;
    }

}

class Producer {
    int id;
    int sp = 1;

    Producer(int i) {
        id = i;
    }

    int produce(Bun b) {
        b.add(sp);
        return 0;
    }

}

class Consumer {
    int id;
    int sp = 2;

    Consumer(int i) {
        id = i;
    }

    int eat(Bun b) {
        b.sub(sp);
        return 0;
    }
}