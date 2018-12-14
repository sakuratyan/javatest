package com.testraytrace.ch1;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * TestImage
 */
public class MyImage extends Frame {
    public final int HEIGHT = 720;
    public final int WIDTH = 1080;
    public final int IM_W = WIDTH;
    public final int IM_H = HEIGHT;
    /*
     * 自左上角开始自左向右。计数惯例是0开始
     */
    public BufferedImage bi = new BufferedImage(IM_W, IM_H, BufferedImage.TYPE_INT_ARGB);

    public static void main(String[] args) {
        new MyImage().launch();
    }

    // public TestImage() {
    // System.out.println(bi.getHeight());
    // System.out.println(bi.getWidth());

    // }

    public void launch() {
        myView();
        System.out.println("over");
        setBounds(100, 100, WIDTH, HEIGHT);
        this.setTitle("IMG");
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawImage(bi, 0, 0, IM_W, IM_H, null);
    }

    public void setRGB(int x, int y, int c) {
        bi.setRGB(x, y, c);
        // bi.getRGB(x, y);
    }

    public int setColor(int r, int g, int b) {
        return setColor(r, g, b, 0xFF);
    }

    public int setColor(int r, int g, int b, int a) {
        return ((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | ((b & 0xFF) << 0);
    }

    public void myView() {
        int r, g, b;
        for (int j = this.IM_H - 1; j >= 0; j--) {
            for (int i = 0; i < this.IM_W; i++) {
                r = (int) (i * 255.0 / IM_W + 0.5);
                g = (int) (j * 255.0 / IM_H + 0.5);
                // b = (int)(0.2*255+0.5);
                b = 0;
                setRGB(i, this.IM_H - j - 1, setColor(r, g, b));
            }
        }
        saveImage("ch1.0.png");
    }

    protected void saveImage(String s) {
        File file = new File("test_artifactId/src/main/java/com/testraytrace/.image", s);

        try {
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
            ImageIO.write(bi, "png", file);
            // System.out.println(file.getPath()+" saved");
            System.out.println(file.getName() + " saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}