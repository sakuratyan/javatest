package com.test_groupId.gui;

import java.awt.*;
import java.awt.event.*;

/**
 * TestPaint
 */
public class TestPaint {

    public TestPaint() {
        new PaintFrame().launchFrame();
    }
}

class PaintFrame extends Frame implements Runnable {
    int x = 0, y = 0;
    Color c = new Color(0, 0, 0);

    public void launchFrame() {
        setBounds(100, 100, 458, 500);
        setVisible(true);
        new Thread(this).start();

        // key code left37 up38 right39 down40
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                // case 37:
                case KeyEvent.VK_LEFT:
                    x--;
                    break;
                // case 38:
                case KeyEvent.VK_UP:
                    y++;
                    break;
                // case 39:
                case KeyEvent.VK_RIGHT:
                    x++;
                    break;
                // case 40:
                case KeyEvent.VK_DOWN:
                    y--;
                    break;
                default:
                    break;
                }
                repaint();
                // System.out.println(e);
            }
        });
    }

    public void paint(Graphics g) {
        // super.paint(g);
        Color cOrigin = g.getColor();
        g.setColor(new Color(100, 20, 130));
        //g.fill3DRect(50, 50, 200, 500, false);
        g.setColor(c);
        g.fillOval(250 + x * 10, 250 - y * 10, 200, 200);
        g.setColor(new Color(100, 120, 230));
        //g.fillRect(250, 50, 200, 200);
        g.setColor(cOrigin);
        // System.out.println(this.getBounds());
    }

    // key

    public void run() {
        Thread.currentThread().setName("runnable");
        // System.out.println("runnable");

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
            this.repaint();
        }

    }
}