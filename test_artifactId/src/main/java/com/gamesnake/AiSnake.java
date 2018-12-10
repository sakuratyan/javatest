package com.gamesnake;

import java.awt.event.KeyEvent;

/**
 * AiSnake
 */
public class AiSnake {
    static int i = 0;
    static int d = KeyEvent.VK_DOWN;

    static void askPath(Snake s) {
        if (i++ == 5) {
            i = 0;
            change();
            s.direction = d;
        }
    }

    static void change(){
        if (d == KeyEvent.VK_DOWN) {
            d = KeyEvent.VK_RIGHT;
        }else if (d == KeyEvent.VK_RIGHT) {
            d= KeyEvent.VK_UP;
        }else if (d== KeyEvent.VK_UP) {
            d = KeyEvent.VK_LEFT;
        }else{
            d = KeyEvent.VK_DOWN;
        }
    }

}