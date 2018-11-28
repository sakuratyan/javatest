package com.gamesnake;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Yard
 */
public class Yard extends Frame {
    private static final int ROWS = 40;
    private static final int COLS = 50;
    private static final int BLOCK_SIZE = 20;
    Point startP = new Point(BLOCK_SIZE, BLOCK_SIZE * 2);

    public void launch() {
        this.setLocation(0, 0);
        this.setSize((COLS + 2) * BLOCK_SIZE, (ROWS + 3) * BLOCK_SIZE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Color oc = g.getColor();
        g.setColor(Color.gray);
        g.fillRect(startP.x, startP.y, COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);

        // 背景横竖线
        g.setColor(Color.darkGray);
        for (int i = 1; i < ROWS; i++) {
            g.drawLine(startP.x, startP.y + i * BLOCK_SIZE, startP.x + COLS * BLOCK_SIZE, startP.y + i * BLOCK_SIZE);
        }
        for (int i = 1; i < COLS; i++) {
            g.drawLine(startP.x + i * BLOCK_SIZE, startP.y, startP.x + i * BLOCK_SIZE, startP.y + ROWS * BLOCK_SIZE);
        }

        g.drawString("str", 100, 100);
        // snake
        Snake snake = new Snake(new Point(5, 5));
        ArrayList<Point> sl = snake.getLocation();
        g.setColor(Color.blue);
        this.drawPoint(g, sl.get(0));

        g.setColor(oc);
    }

    int drawPoint(Graphics g, Point p) {
        g.fillRect(startP.x + (p.x - 1) * BLOCK_SIZE, startP.y + (p.y - 1) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);

        return 0;
    }

}