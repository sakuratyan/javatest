package com.gamesnake;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Snake
 */
public class Snake {

    ArrayList<Point> sl = new ArrayList<>();
    
    Snake(Point p){
        sl.add(p);
    }

    int eat(Egg g){
        //snake.add(e)
        return 0;
    }
    
    ArrayList<Point> getLocation(){
        return sl;
    }
    
}