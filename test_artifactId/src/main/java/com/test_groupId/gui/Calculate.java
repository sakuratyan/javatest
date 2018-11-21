package com.test_groupId.gui;

import java.awt.*;
import java.awt.event.*;

/**
 * Calculate
 */
public class Calculate {

    public Calculate() {
        new TFFrame2();
    }
}

class TFFrame2 extends Frame {
    int i = 0;
    int j = 0;

    TFFrame2() {
        TextField tf1 = new TextField();
        TFListener fl1 = new TFListener();
        tf1.addActionListener(fl1);
        // tf.setEchoChar('*');
        TextField tf2 = new TextField();
        TFListener2 fl2 = new TFListener2();
        tf2.addActionListener(fl2);
        // Button
        Button butt = new Button("ye me te");
        butt.addActionListener(new ButtonMonitor());

        // panel 1,3
        Panel p = new Panel(new GridLayout(1, 3));
        p.add(tf1);
        p.add(tf2);
        p.add(butt);
        add(p);
        pack();
        setVisible(true);

    }

    class TFListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            TextField tf = (TextField) a.getSource();
            System.out.println(tf.getText());
            i = Integer.valueOf(tf.getText());
            tf.setText("");
        }
    }

    class TFListener2 implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            TextField tf = (TextField) a.getSource();
            System.out.println(tf.getText());
            j = Integer.valueOf(tf.getText());
            tf.setText("");
        }
    }

    class ButtonMonitor implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            Button b = (Button) a.getSource();
            b.setLabel(Integer.toString(i + j));
            System.out.println(i+" "+j);
        }
    }
}
