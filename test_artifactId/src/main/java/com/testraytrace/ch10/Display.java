package com.testraytrace.ch10;

import com.testraytrace.ch9.*;

/**
 * Display
 */
public class Display extends com.testraytrace.ch9.Display {

    public static void main(String[] args) {
        long o = System.currentTimeMillis();
        new Display("ch10.png").launch();
        System.out.println("total time: " + (System.currentTimeMillis() - o));
    }

    @Override
    public void myView() {
        HitableList world = new HitableList();

        world.addElements(new Sphere(new Vec3(0.0f, 0.0f, -1.0f), 0.5f, new Metal(new Vec3(0.9f, 0.9f, 0.9f), 0.0f)));
        world.addElements(
                new Sphere(new Vec3(0.0f, -100.5f, -1.0f), 100f, new Metal(new Vec3(0.8f, 0.6f, 0.2f), 0.9f)));
        world.addElements(new Sphere(new Vec3(-1.5f, 0, -2), 0.5f, new Dielectic(1.5f)));

        float aspect = (float) this.IM_W / (float) this.IM_H;
        Camera camera = new Camera(new Vec3(2, 2, 1), new Vec3(0, 0, -1), new Vec3(0, 1, 0), 40, aspect);
        // Camera camera = new Camera();

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