package com.test_groupId.gui;

import java.awt.*;

/**
 * TestPanel
 */
public class TestPanel {

    public TestPanel() {
        new MyFrame(100, 100, 200, 200, Color.ORANGE);
    }

}

class MyFrame extends Frame {

    MyFrame(int px, int py, int pw, int ph, Color c) {
        Frame f = new Frame("public class TestPanel extends Frame{");
        f.setBounds(2 * px, 2 * py, 2 * pw, 2 * ph);
        f.setBackground(c.darker());
         f.setLayout(null);
        //f.setLayout(new BorderLayout());
        Panel p = new Panel(null);
        p.setBounds(px, py, pw, ph);
        p.setBackground(c.brighter());
        f.add(p);
        //f.setResizable(false);
        f.setVisible(true);

    }
}