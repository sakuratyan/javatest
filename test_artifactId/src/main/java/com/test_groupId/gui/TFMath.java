package com.test_groupId.gui;

import java.awt.*;
import java.awt.event.*;

/**
 * TFMAth
 */
public class TFMath {

    public TFMath() {
        new TFMAth2().LaunchFrame();
    }
}

class TFMAth2 extends Frame {
    TextField n1, n2, n3;

    public void LaunchFrame() {
        n1 = new TextField(10);
        n2 = new TextField(10);
        n3 = new TextField(15);

        Label l = new Label("+");

        Button b = new Button("=");
        b.addActionListener(new MyMathMonitor());
        setLayout(new FlowLayout());

        add(n1);
        add(l);
        add(n2);
        add(b);
        add(n3);
        pack();
        setVisible(true);

    }
    class MyMathMonitor implements ActionListener {
    
        public void actionPerformed(ActionEvent e) {
            int num1 = Integer.parseInt(n1.getText());
            int num2 = Integer.parseInt(n2.getText());
            n3.setText("" + (num1 + num2));
        }
    }
}
/*
class MyMathMonitor implements ActionListener {
    TFMAth2 m;

    MyMathMonitor(TFMAth2 a) {
        this.m = a;
    }

    public void actionPerformed(ActionEvent e) {
        int n1 = Integer.parseInt(m.n1.getText());
        int n2 = Integer.parseInt(m.n2.getText());
        // m.n3.setText(Integer.toString(n1+n2));
        m.n3.setText("" + (n1 + n2));
    }
}
*/