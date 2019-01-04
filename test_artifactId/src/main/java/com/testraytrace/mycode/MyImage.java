package com.testraytrace.mycode;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * TestImage
 */
public class MyImage extends Frame implements Runnable {
    public int HEIGHT = 400;
    public int WIDTH = 800;
    public int IM_W = WIDTH;
    public int IM_H = HEIGHT;

    HitableList world = new HitableList();

    Camera camera = new Camera(world);
    MyImage myImage = this; 
    /*
     * 自左上角开始自左向右。计数惯例是0开始
     */
    protected String imgName;
    public BufferedImage bi = new BufferedImage(IM_W, IM_H, BufferedImage.TYPE_INT_ARGB);

    public MyImage() {
        this.imgName = "default.png";
        world.addElements(new Sphere(new Vec3(0.0f, 0.0f, -1.0f), 0.5f));
        world.addElements(new Sphere(new Vec3(0.3f, 0.0f, -1.0f), 0.3f));
        // new Thread(new ConsoleProgress(this)).start();
        new Thread(new MyImage(this)).start();
    }

    protected MyImage(String imgName) {
        this.imgName = imgName;
    }

    public void launch() {
        // System.out.println("over");
        setBounds(100, 100, WIDTH, HEIGHT);
        this.setTitle("IMG");
        setVisible(true);
        myView();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // saveImage(imgName);
                System.exit(0);
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.toString());
                camera.chgeDir(e.getKeyCode());
                myView();
                repaint();
            }
        });
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
        int ns = 10; // 采样次数 消锯齿
        for (int j = this.IM_H - 1; j >= 0; j--) {
            for (int i = 0; i < this.IM_W; i++) {
                Vec3 color = new Vec3(0, 0, 0); // 初始化该点的像素
                for (int s = 0; s < ns; s++) {
                    float u = (float) (i + Math.random()) / (float) this.IM_W; // 添加随机数 消锯齿Math.random() <-- 0
                    float v = (float) (j + Math.random()) / (float) this.IM_H;
                    // Ray r = camera.GetRay(u, v); // 根据uv得出光线向量
                    color = color.Add(camera.getColor(u, v)); // 根据每个像素点上色 累加
                }
                color = color.Scale(1.0f / (float) ns); // 除以采样次数 求平均
                // gamma矫正
                // color = new Vec3((float) Math.sqrt(color.x()), (float) Math.sqrt(color.y()),
                // (float) Math.sqrt(color.z()));

                int ir = (int) (color.x() * 255.0 + 0.5);
                int ig = (int) (color.y() * 255.0 + 0.5);
                int ib = (int) (color.z() * 255.0 + 0.5);
                setRGB(i, this.IM_H - j - 1, setColor(ir, ig, ib));
            }
            this.value = 100;
        }

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

    /**
     * 默认是1-100之间的数字
     */
    protected long value = 0;
    MyImage mImage;

    MyImage(MyImage mImage) {
        this.mImage = mImage;
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mImage.repaint();
        } while (this.value < 100);
    }
}