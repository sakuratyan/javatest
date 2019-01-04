package com.testraytrace.ch12;

import com.testraytrace.ch9.*;

/**
 * Display
 */
public class Display extends com.testraytrace.ch9.Display {

    public static void main(String[] args) {
        long o = System.currentTimeMillis();
        new Display("ch12.png").launch();
        System.out.println("total time: " + (System.currentTimeMillis() - o));
    }

    @Override
    public void myView() {
        HitableList world = RedonmWorld.random_scene();

        Vec3 lookfrom = new Vec3(13,2,3);
        Vec3 lookat = new Vec3();
        float aspect = (float) this.IM_W / (float) this.IM_H;
        Camera camera = new Camera(lookfrom, new Vec3(0, 0, 0), new Vec3(0, 1, 0), 20, aspect,2.0f,0.7f*(lookfrom.Subtract(lookat)).length());

        int ns = 100; // 采样次数 消锯齿
        for (int j = this.IM_H - 1; j >= 0; j--) {
            for (int i = 0; i < this.IM_W; i++) {
                Vec3 color = new Vec3(0, 0, 0); // 初始化该点的像素
                for (int s = 0; s < ns; s++) {
                    float u = (float) (i + Math.random()) / (float) this.IM_W; // 添加随机数 消锯齿Math.random() <-- 0
                    float v = (float) (j + Math.random()) / (float) this.IM_H;
                    Ray r = camera.GetRay(u, v); // 根据uv得出光线向量
                    color = color.Add(this.color(r, world)); // 根据每个像素点上色 累加
                }
                color = color.Scale(1.0f / (float) ns); // 除以采样次数 求平均
                // gamma矫正
                color = new Vec3((float) Math.sqrt(color.x()), (float) Math.sqrt(color.y()),
                        (float) Math.sqrt(color.z()));

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
        super(imgName);
    }
}