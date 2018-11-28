package com.gamesnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 * Snake
 */
public class Snake {

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
            g.fillRect(GRID_OFFSET.x + (this.p.x - 1) * BLOCK_SIZE, GRID_OFFSET.y + (this.p.y - 1) * BLOCK_SIZE,
                    BLOCK_SIZE, BLOCK_SIZE);
            g.setColor(oc);
        }
    }

    ArrayList<Point> sl = new ArrayList<>();

    Snake(Point p) {
        sl.add(p);
    }

    int eat(Egg g) {
        // snake.add(e)
        return 0;
    }

    ArrayList<Point> getLocation() {
        return sl;
    }

    int getlength() {
        return sl.size();
    }

}
