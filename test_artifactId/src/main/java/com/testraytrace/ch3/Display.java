
package com.testraytrace.ch3;

import com.testraytrace.ch1.*;

/**
 * Display
 */
public class Display extends MyImage {

    private Vec3 lower_left = new Vec3(-2.0f, -1.0f, -1.0f);
    private Vec3 horizontal = new Vec3(4.0f, 0.0f, 0.0f);
    private Vec3 vertical = new Vec3(0.0f, 2.0f, 0.0f);
    private Vec3 origin = new Vec3(0.0f, 0.0f, 0.0f);

    public static void main(String[] args) {
        new Display().launch();
    }

    @Override
    public void myView() {

        int r, g, b;
        for (int i = HEIGHT - 1; i >= 0; i--) {
            // for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                float u = (float) j / (float) WIDTH;
                float v = (float) i / (float) HEIGHT;
                Ray ray = new Ray(origin, lower_left.Add(horizontal.Scale(u)).Add(vertical.Scale(v)));
                Vec3 color = color(ray);

                r = (int) (color.x() * 255.0 + 0.5);
                g = (int) (color.y() * 255.0 + 0.5);
                b = (int) (color.z() * 255.0 + 0.5);
                // System.out.println(setColor(r, g, b));
                setRGB(i, j, setColor(r, g, b));
            }
        }

        this.saveImage("ch3.png");
    }



    public Vec3 color(Ray r) {
        Vec3 unit_dir = r.direction().normalize(); // 单位光线的方向 并归一化
        float t = 0.5f * (unit_dir.y() + 1.0f); // 取出y的坐标值，原本范围为[-1,1]调整为[0,1]
        return new Vec3(1.0f, 1.0f, 1.0f).Scale(1.0f - t).Add(new Vec3(0.5f, 0.7f, 1.0f).Scale(t));
        // 返回背景(1.0-t)*vec3(1.0, 1.0, 1.0) + t*vec3(0.5, 0.7, 1.0);
        // 沿着y轴线性插值，所以返回的颜色介于白色与天蓝色之间，即模拟天空的颜色
    }
}