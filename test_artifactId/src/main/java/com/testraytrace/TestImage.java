package com.testraytrace;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * TestImage
 */
public class TestImage extends Frame {
    BufferedImage bi = new BufferedImage(400, 400, BufferedImage.TYPE_INT_BGR);
    final int HEIGHT = 600;
    final int WIDTH = 600;
    final int IM_W = HEIGHT;
    final int IM_H = WIDTH;

    public TestImage() {
        
    }

    public void launch(){
        setBounds(100, 100, HEIGHT, WIDTH);
        this.setTitle("IMG");
        setVisible(true);

    }

    public void paint(Graphics g) {
        g.drawImage(bi, 0, 0, IM_H, IM_W, null);
    }

    void adjBI(int x,int y, Color c){
        bi.setRGB(x, y, c.getRGB());
        // bi.getRGB(x, y);
    }

    // void saveImage(String s) {
    //     File file = new File("c:\\javaPic.png");

    //     try {
    //         if (file.exists()) {
    //             file.delete();
    //             file.createNewFile();
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     writeImage(bi, "png", file);

    // }

}