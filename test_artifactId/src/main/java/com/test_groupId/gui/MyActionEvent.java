package com.test_groupId.gui;

import java.awt.*;

/**
 * I cant do it!
 * MyActionEvent
 * 
 */
public class MyActionEvent {

    public MyActionEvent() {
        Frame f = new Frame("MyActionEvent ");
        MyButton b = new MyButton("ye me te");

        f.add(b);
        f.pack();
        f.setVisible(true);
    }
}

class MyButton extends Button {
    static boolean flasg = false;
    MyButton(String s) {
        super(s);
    }

    void addMyActionListener(MyActionListener m) {
        
    }
}

class Manager implements Runnable{

    static MyActionListener[] action = null;

    Manager(){

    }
    public void run(){

        while (true) {
            check();
            //action[0].myActionPerformed();
        }
    }
    MyActionListener check(){
        return null;
    }
}


interface MyActionListener{
    static int i = 0;
    void myActionPerformed();
}
class MyMonitor implements MyActionListener{
    public void myActionPerformed() {
        System.out.println("Press");
    }
}