package com.testraytrace.ch4;

import com.testraytrace.ch1.*;
import com.testraytrace.ch3.*;

/**
 * Display
 */
public class Display extends MyImage {

    public static void main(String[] args) {
        System.out.println("start!");
    }

    @Override
    public void myView() {

    }

    /**
     * 是否碰到那个球
     * 
     * @param center 球的圆心
     * @param radius 球的半径
     * @param r      光线
     * @return 光线是否碰到球
     * 球的公式 (p-C)^2 = R^2
     * 光线方程 p(t) = A + t*B
     * 联立得 (A + t*B - C)^2 = R^2
     * ==>B^2*t^2 + 2B(A-C)t + (A^2-C^2-R^2) = 0
     * 判断光线与球有交点：求根公式
     */
    public boolean hitSphere(final Vec3 center, float radius, final Ray r) {
        Vec3 oc = r.origin().Subtract(center); // oc = A-C
        float a = r.direction().dot(r.direction()); // a = B·B
        float b = 2.0f * oc.dot(r.direction()); // b = 2B·oc
        float c = oc.dot(oc) - radius * radius; // c = oc^2 - R^2
        float discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * @param r 光线
     * @return 光线代表像素的颜色
     */
    public Vec3 color(Ray r) {
        if (hitSphere(new Vec3(0, 0, -1), 0.5f, r)) {
            return new Vec3(0, 0, 1);
        } else {
            Vec3 unit_dir = r.direction().normalize(); // 单位方向向量
            float t = 0.5f * (unit_dir.y() + 1.0f); // 原本范围为[-1,1]调整为[0,1]
            return new Vec3(1.0f, 1.0f, 1.0f).Scale(1.0f - t).Add(new Vec3(0.5f, 0.7f, 1.0f).Scale(t));
            // 返回背景(1.0-t)*vec3(1.0, 1.0, 1.0) + t*vec3(0.5, 0.7, 1.0);
            // 沿着y轴线性插值，返回的颜色介于白色与天蓝色之间
        }
    }

}