package com.testraytrace.ch6;

import java.util.Calendar;
import java.util.Date;
import com.testraytrace.ch1.*;

/**
 * Display
 */
public class Display extends MyImage {

    public static void main(String[] args) {
        long o = new Date().getTime();
        new Display("ch6.png").launch();
        System.out.println(new Date().getTime()-o);
    }

    @Override
    public void myView() {
        HitableList world = new HitableList();
        Camera camera = new Camera(world);
        world.addElements(new Sphere(new Vec3(0.0f, 0.0f, -1.0f), 0.5f));
        world.addElements(new Sphere(new Vec3(0.3f, 0.0f, -1.0f), 0.3f));
        world.addElements(new Sphere(new Vec3(0.0f, -100.5f, -1.0f), 100f));
        int ns = 100; // 采样次数 消锯齿

        for (int j = this.IM_H - 1; j >= 0; j--) {
            for (int i = 0; i < this.IM_W; i++) {
                Vec3 color = new Vec3(0, 0, 0); // 初始化该点的像素
                for (int s = 0; s < ns; s++) {
                    float u = (float) (i + Math.random()) / (float) this.IM_W; // 添加随机数 消锯齿Math.random() <-- 0
                    float v = (float) (j + Math.random()) / (float) this.IM_H; 
                    Ray r = camera.GetRay(u, v); // 根据uv得出光线向量
                    color = color.Add(camera.color(r)); // 根据每个像素点上色 累加
                }
                color = color.Scale(1.0f / (float) ns); // 除以采样次数 求平均
                // float v = (float) j / (float) IM_H; // 竖直 不过是从左上角开始的，用的时候取 1-v
                // float u = (float) i / (float) IM_W; // 水平
                // Ray r = camera.GetRay(u, v); // 根据uv得出光线向量
                // Vec3 color = camera.color(r);
                int ir = (int) (color.x() * 255.0 + 0.5);
                int ig = (int) (color.y() * 255.0 + 0.5);
                int ib = (int) (color.z() * 255.0 + 0.5);
                setRGB(i, this.IM_H - j - 1, setColor(ir, ig, ib));
            }
            // this.value = (int) (100.0 * (this.IM_H - j) / this.IM_H);
            this.value = 100;
        }
    }

    private Display(String imgName) {
        this.imgName = imgName;
    }

    void testTime() {
        int c = 100000000;
        System.out.println(testTimeSys(c));
        System.out.println(testTimeCld(c));
        System.out.println(testTimeDat(c));
    }

    private long testTimeSys(int c) {
        long o = System.currentTimeMillis();
        for (int i = 0; i < c; i++) {
            System.currentTimeMillis();
        }
        return System.currentTimeMillis() - o;
    }

    private long testTimeCld(int c) {
        long o = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < c; i++) {
            Calendar.getInstance().getTimeInMillis();
        }
        return Calendar.getInstance().getTimeInMillis() - o;
    }

    private long testTimeDat(int c) {
        long o = new Date().getTime();
        for (int i = 0; i < c; i++) {
            new Date().getTime();
        }
        return new Date().getTime() - o;
    }

    private static void prime(long l) {
        long o = new Date().getTime();
        long oi = new Date().getTime();
        int index = 0;
        boolean isPrime = true;
        for (long i = 0; i < l; i++) {
            isPrime = true;
            for (long j = i / 2; j > 2; j--) { // j = (long) Math.sqrt((double) i)
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(index++ + "\t time:" + (new Date().getTime() - o) + "\t num:" + i + "\t currenttime:"
                        + (new Date().getTime() - oi));
                oi = new Date().getTime();

            }
        }
    }

}