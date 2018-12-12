package com.testraytrace.ch1;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * TestImage
 */
public class MyImage extends Frame {
    public final int HEIGHT = 600;
    public final int WIDTH = 600;
    public final int IM_W = HEIGHT;
    public final int IM_H = WIDTH;
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
        setBounds(100, 100, HEIGHT, WIDTH);
        this.setTitle("IMG");
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawImage(bi, 0, 0, IM_H, IM_W, null);
    }

    public void setRGB(int x, int y, int c) {
        bi.setRGB(x, y, c);
        // bi.getRGB(x, y);
    }

    public int setColor(int r, int g, int b) {
        return setColor2(r, g, b, 0xFF);
    }

    public int setColor2(int r, int g, int b, int a) {
        return ((a & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | ((b & 0xFF) << 0);
    }

    public void myView() {
        // int c = 0;
        int r, g, b;
        for (int i = 0; i < bi.getHeight(); i++) {
            for (int j = 0; j < bi.getWidth(); j++) {
                r = (int) (i * 255.0 / HEIGHT + 0.5);
                g = (int) (j * 255.0 / WIDTH + 0.5);
                // b = (r + g) / 2;
                b = 0;
                setRGB(i, j, setColor(r, g, b));
            }
        }
    }

    protected void saveImage(String s) {
        File file = new File("test_artifactId/src/main/java/com/testraytrace/.image",s);

        try {
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
            ImageIO.write(bi, "png", file);
            System.out.println(file.getPath()+" saved");
            // System.out.println(file.getName()+" saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}