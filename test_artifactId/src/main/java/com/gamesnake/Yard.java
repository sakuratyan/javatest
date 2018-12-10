package com.gamesnake;

import java.awt.*;
import java.awt.event.*;

/**
 * interface Grid
 */
interface Grid {
    public static final int ROWS = 40;
    public static final int COLS = 50;
    public static final int BLOCK_SIZE = 20;
    public static Point GRID_OFFSET = new Point(BLOCK_SIZE, BLOCK_SIZE * 2);

}

/**
 * class Yard
 */
public class Yard extends Frame implements Grid {

    Egg egg = new Egg();
    Snake snake = new Snake(this,new Point(1,1), Color.green, 5,egg);

    public void launch() {
        this.setLocation(0, 0);
        this.setSize((COLS + 2) * BLOCK_SIZE, (ROWS + 3) * BLOCK_SIZE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                snake.changeDire(e.getKeyCode());
                // repaint();
                // System.out.println(e);
            }
        });

        new Thread(snake).start();
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Color oc = g.getColor();
        g.setColor(Color.gray);
        g.fillRect(GRID_OFFSET.x, GRID_OFFSET.y, COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);

        // 背景横竖线
        g.setColor(Color.darkGray);
        for (int i = 1; i < ROWS; i++) {
            g.drawLine(GRID_OFFSET.x, GRID_OFFSET.y + i * BLOCK_SIZE, GRID_OFFSET.x + COLS * BLOCK_SIZE,
                    GRID_OFFSET.y + i * BLOCK_SIZE);
        }
        for (int i = 1; i < COLS; i++) {
            g.drawLine(GRID_OFFSET.x + i * BLOCK_SIZE, GRID_OFFSET.y, GRID_OFFSET.x + i * BLOCK_SIZE,
                    GRID_OFFSET.y + ROWS * BLOCK_SIZE);
        }

        //egg
        egg.draw(g);
        // snake
        snake.draw(g);

        


        g.setColor(oc);
    }


}
