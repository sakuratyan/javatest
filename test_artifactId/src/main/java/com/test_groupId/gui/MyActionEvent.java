package com.test_groupId.gui;

/**
 * I cant do it! MyActionEvent (⊙﹏⊙)
 */
public class MyActionEvent {

    public MyActionEvent() {
        T t = new T();
        t.add(new MyMonitor());
    }
}

class T {
    MyButton m;
    Thread t;

    T() {
        m = new MyButton();
        t = new Thread(m);
        t.start();
    }

    void add(MyActionListener a) {
        m.add(a);
    }
}

class MyButton /* extends MyAction */ implements Runnable {
    MyActionListener m;
    MyActionListener[] arrm = new MyActionListener[10];
    int i = 0;

    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String actionevent = "actionevent";
            System.out.println(actionevent);
            // myActionPerformed();
            if (arrm.length == 0) {
                new MyAction().myActionPerformed("myActionPerformed:null");
                ;
            } else {
                for (MyActionListener var : arrm) {
                    var.myActionPerformed(actionevent);
                }
            }
        }
    }

    void add(MyActionListener a) {
        arrm[i++] = a;
    }

}

interface MyActionListener {
    static int i = 0;

    void myActionPerformed(String actionevent);
}

class MyAction implements MyActionListener {
    public void myActionPerformed(String actionevent) {
        System.out.println("MyActionListener;null");

    }
}

class MyMonitor implements MyActionListener {
    public void myActionPerformed(String actionevent) {
        System.out.println("MyMonitor:myActionPerformed");
    }
}