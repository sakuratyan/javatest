package com.gamesnake;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Snake
 */
public class Snake implements Runnable, Grid {
    int direction = KeyEvent.VK_DOWN;
    // Point tp = new Point();

    private final long SPEED = 100;
    private Frame yard = null;
    private Egg g = null;
    private Point snakeHead = null;// new Point();
    private Color snakeColor = null;
    private int defaultlength = 0;

    ArrayList<Node> sl = new ArrayList<>();

    Snake(Frame f, Point p, Color c, int length, Egg g) {
        sl.add(new Node(p, c));
        for (int i = 1; i < length; i++) {
            sl.add(new Node(new Point(p.x + i, p.y), c.darker()));
        }

        // for new snake
        snakeHead = (Point) p.clone();
        snakeColor = new Color(c.getRGB());
        defaultlength = length;

        this.yard = f;
        this.g = g;

    }

    //new snake
    private void newsnake(){
        sl.clear();
        Point p = new Point(snakeHead);
        Color c =  new Color(snakeColor.getRGB());
        sl.add(new Node(p, c));
        for (int i = 1; i < defaultlength; i++) {
            sl.add(new Node(new Point(p.x + i, p.y), c.darker()));
        }
        direction = KeyEvent.VK_DOWN;
    }

    int eat(Egg g) {

        if (sl.get(0).p.equals(g.e.p)) {
            addTail(g);
            g.randomBir(this);
        }
        return 0;
    }

    private void addTail(Egg g) {
        // Color c = g.e.c;

        Color c = Color.black;
        Point p = new Point();
        p.x = g.e.p.x;
        p.y = g.e.p.y;
        sl.add(new Node(p, c));
    }

    void draw(Graphics g) {
        for (Node v : sl) {
            v.draw(g);
        }
    }

    void changeDire(int dir) {
        if (direction == KeyEvent.VK_DOWN | direction == KeyEvent.VK_UP) {
            if (dir == KeyEvent.VK_LEFT | dir == KeyEvent.VK_RIGHT) {
                direction = dir;
            }
        }

        if (direction == KeyEvent.VK_LEFT | direction == KeyEvent.VK_RIGHT) {
            if (dir == KeyEvent.VK_DOWN | dir == KeyEvent.VK_UP) {
                direction = dir;
            }
        }
        // forward();
    }

    void forward() {
        switch (direction) {
        case KeyEvent.VK_LEFT:
            move(-1, 0);
            break;
        // case 38:
        case KeyEvent.VK_UP:
            move(0, -1);
            break;
        // case 39:
        case KeyEvent.VK_RIGHT:
            move(1, 0);
            break;
        // case 40:
        case KeyEvent.VK_DOWN:
            move(0, 1);
            break;
        }
        limitedPoint();
        this.eat(g);
    }

    private void limitedPoint() {
        if (sl.get(0).p.x == 0 | sl.get(0).p.x == COLS + 1 | sl.get(0).p.y == 0 | sl.get(0).p.y == ROWS + 1) {
            newsnake();
        }

        for (int i = 1; i < sl.size(); i++) {
            if (sl.get(0).p.equals(sl.get(i).p)) {
                newsnake();
            }
        }
    }

    private void move(int x, int y) {
        bodymove();
        if (x != 0) {
            sl.get(0).p.x += x;
        }
        if (y != 0) {
            sl.get(0).p.y += y;
        }
    }

    private void bodymove() {
        // 放弃最后一P：内存？泄露.NONONO 没什么用
        // tp = sl.get(sl.size()-1).p;
        for (int i = sl.size() - 1; i > 0; i--) {
            sl.get(i).p.x = sl.get(i - 1).p.x;
            sl.get(i).p.y = sl.get(i - 1).p.y;
        }
    }

    int getlength() {
        return sl.size();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(SPEED);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AiSnake.askPath(this);
            this.forward();
            this.yard.repaint();
        }
    }

}

class Node implements Grid {
    Point p = null;
    Color c = null;

    Node(Point p, Color c) {
        this.p = p;
        this.c = c;
    }

    void draw(Graphics g) {
        Color oc = g.getColor();
        g.setColor(this.c);
        g.fillRect(GRID_OFFSET.x + (this.p.x - 1) * BLOCK_SIZE, GRID_OFFSET.y + (this.p.y - 1) * BLOCK_SIZE, BLOCK_SIZE,
                BLOCK_SIZE);
        g.setColor(oc);
    }
}