
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
        System.out.println("start");
        new Display().launch();
    }

    @Override
    public void myView() {

        int r, g, b;
        for (int j = this.IM_H - 1; j >= 0; j--) {
            for (int i = 0; i < this.IM_W; i++) {
                float v = (float) j / (float) IM_H; // 竖直 不过是从左上角开始的，用的时候取 1-v
                float u = (float) i / (float) IM_W; // 水平
                // Ray ray = new Ray(origin,
                // lower_left.Add(horizontal.Scale(u)).Add(vertical.Scale(v)));
                Ray ray = new Ray(origin, lower_left.Add(horizontal.Scale(u)).Add(vertical.Scale(1 - v)));
                Vec3 color = color(ray);

                r = (int) (color.x() * 255.0 + 0.5);
                g = (int) (color.y() * 255.0 + 0.5);
                b = (int) (color.z() * 255.0 + 0.5);
                // r = (int)(255.99f*color.x());
                // g = (int)(255.99f*color.y());
                // b = (int)(255.99f*color.z());
                // setRGB(i, this.IM_H - j - 1, setColor(r, g, b));
                setRGB(i, j, setColor(r, g, b));
            }
        }

        // this.saveImage("ch3.0.png");
    }

    public Vec3 color(Ray r) {
        Vec3 unit_dir = r.direction().normalize(); // 单位光线的方向 并归一化
        float t = 0.5f * (unit_dir.y() + 1.0f); // 取出y的坐标值，原本范围为[-1,1]调整为[0,1]
        // System.out.println(t + " " + r.direction());
        return new Vec3(1.0f, 1.0f, 1.0f).Scale(1.0f - t).Add(new Vec3(0.5f, 0.7f, 1.0f).Scale(t));
        // 返回背景(1.0-t)*vec3(1.0, 1.0, 1.0) + t*vec3(0.5, 0.7, 1.0);
        // 沿着y轴线性插值，所以返回的颜色介于白色与天蓝色之间，即模拟天空的颜色
        // return new Vec3(1.0f, 1.0f, 1.0f).Scale(t).Add(new Vec3(0.5f, 0.7f,
        // 1.0f).Scale(1 - t));
        // return new Vec3(0.5f, 0.7f, 1.0f);
    }

    protected Display() {
    }

    private Display(String imgName){
        // this.imgName = imgName;
        super(imgName);
    }
}