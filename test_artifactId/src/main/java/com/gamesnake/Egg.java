package com.gamesnake;

import java.awt.*;

/**
 * Egg
 */
public class Egg implements Grid {
    Node e = new Node(new Point(10, 10), Color.BLUE);

    void draw(Graphics g) {
        e.draw(g);
    }

    void randomBir() {
        Point p = new Point();
        p.x = (int) (Math.random() * COLS) + 1;
        p.y = (int) (Math.random() * ROWS) + 1;
        setPoint(p);
    }

    void randomBir(Snake s){
        randomBir();
        while (true) {
            for (Node vNode : s.sl) {
                if (this.e.p.equals(vNode.p)) {
                    randomBir();
                    continue;
                }
            }
            break;
        }
        
    }

    void setPoint(Point p) {
        e.p = p;
    }
}