package com.test_groupId.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * MyMouseAdapter
 */
public class MyMouseAdapter {

    public MyMouseAdapter() {
        new MouseFrame().launch();
    }

}

class MouseFrame extends Frame {
    ArrayList<Point> arrl = new ArrayList<>();

    void launch() {
        this.addMouseListener(new MouseMonitor());
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawLine(0, 0, 458, 500);
        g.setColor(Color.GREEN);
        for (Point var : arrl) {
            g.fillOval(var.x, var.y, 10, 10);
        }
    }
    void add(Point p){
        arrl.add(p);
    }
}

class MouseMonitor extends MouseAdapter{
    public void mousePressed(MouseEvent e){
        MouseFrame mf = (MouseFrame)e.getSource();
        mf.add(new Point(e.getX(),e.getY()));
        System.out.println(e.getX()+" "+e.getY());
        mf.repaint();
    }
}
