package com.testraytrace.ch5;

import com.testraytrace.ch3.*;

/**
 * Display
 */
public class Display1 extends com.testraytrace.ch3.Display {

    public static void main(String[] args) {
        System.out.println("start!");
        new Display1("ch5.1.png").launch();

    }

    private Display1(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public void myView() {
        super.myView();
        this.saveImage("ch5.png");
    }

    public float hitSphere(final Vec3 center, float radius, final Ray r) {
        Vec3 oc = r.origin().Subtract(center); // oc = A-C
        float a = r.direction().dot(r.direction()); // a = B·B
        float b = 2.0f * oc.dot(r.direction()); // b = 2B·oc
        float c = oc.dot(oc) - radius * radius; // c = oc^2 - R^2
        float discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return -1.0f;
        } else {
            return (-b - (float) Math.sqrt(discriminant)) / (2.0f * a);
        }
    }

    @Override
    public Vec3 color(Ray r) {
        float t = hitSphere(new Vec3(0, 0, -1), 0.5f, r);
        if (t > 0.0) {
            // t时刻（即交点）的坐标 - 圆心坐标 = 法向量 （并做了归一化）
            Vec3 N = r.point_at_parameter(t).Subtract(new Vec3(0, 0, -1)).normalize();
            return new Vec3(N.x() + 1, N.y() + 1, N.z() + 1).Scale(0.5f);
        }
        // 如果没撞点就返回天空背景
        Vec3 unit_dir = r.direction().normalize(); // 单位方向向量
        t = 0.5f * (unit_dir.y() + 1.0f); // 原本范围为[-1,1]调整为[0,1]
        return new Vec3(1.0f, 1.0f, 1.0f).Scale(1.0f - t).Add(new Vec3(0.5f, 0.7f, 1.0f).Scale(t));
        // 返回背景(1.0-t)*vec3(1.0, 1.0, 1.0) + t*vec3(0.5, 0.7, 1.0);
        // 沿着y轴线性插值，返回的颜色介于白色与天蓝色之间

    }

}