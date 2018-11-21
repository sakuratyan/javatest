package com.test_groupId.gui;

import java.awt.*;
import java.awt.event.*;

/**
 * TestActionEvent
 */
public class TestActionEvent {
    public TestActionEvent(){
        Frame f =new Frame();
        Button b = new Button("ye me te");
        Monitor m = new Monitor();
        b.addActionListener(m);
        b.addActionListener(m);
        f.add(b);
        f.pack();
        f.setVisible(true);
    }
    
}

class Monitor implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("Press");
        System.out.println(e);
        System.out.println(e.getActionCommand());
        System.out.println(e.paramString());
    }
}