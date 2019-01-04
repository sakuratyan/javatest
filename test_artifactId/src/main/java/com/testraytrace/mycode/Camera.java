package com.testraytrace.mycode;

import java.awt.event.KeyEvent;

/**
 * Camera
 */
public class Camera {

    private Vec3 lower_left; // 画布左下角点
    private Vec3 horizontal; // 宽
    private Vec3 vertical; // 高
    private Vec3 origin; // 相机原点
    private float lens_radius;

    private Vec3 u = new Vec3();
    private Vec3 v = new Vec3();
    private Vec3 w = new Vec3();

    HitableList world;

    public Camera() {
        lower_left = new Vec3(-2.0f, -1.0f, -1.0f);
        horizontal = new Vec3(4.0f, 0.0f, 0.0f);
        vertical = new Vec3(0.0f, 2.0f, 0.0f);
        origin = new Vec3(0.0f, 0.0f, 0.0f);
    }

    public Camera(HitableList world) {
        // this();
        this.setCamera(lookfrom, lookat, vup, vfov, aspect, aperture, focus_dist);
        this.world = world;
    }

    /**
     *
     * @param u 距离lower_left的横向距离
     * @param v 距离lower_left的纵向距离
     * @return 光线向量
     */
    public Ray GetRay(float u, float v) {
        return new Ray(origin, lower_left.Add(horizontal.Scale(u)).Add(vertical.Scale(v)).Subtract(origin));
    }

    public Vec3 color(Ray r) {
        HitRecord rec = new HitRecord();
        if (world.hit(r, 0.0f, Float.MAX_VALUE, rec)) {
            // 有撞击点，按撞击点法向量代表的颜色绘制
            return new Vec3(rec.normal.x() + 1, rec.normal.y() + 1, rec.normal.z() + 1).Scale(0.5f);
        }
        Vec3 unit_dir = r.direction().normalize(); // 单位方向向量
        float t = 0.5f * (unit_dir.y() + 1.0f); // 原本范围为[-1,1]调整为[0,1]
        return new Vec3(1.0f, 1.0f, 1.0f).Scale(1.0f - t).Add(new Vec3(0.5f, 0.7f, 1.0f).Scale(t));
        // 返回背景(1.0-t)*vec3(1.0, 1.0, 1.0) + t*vec3(0.5, 0.7, 1.0);
        // 沿着y轴线性插值，返回的颜色介于白色与天蓝色之间
    }

    public Vec3 getColor(float u, float v) {
        Ray ray = this.GetRay(u, v);
        return color(ray);
    }

    /**
     *
     * @param lookfrom 相机位置
     * @param lookat   观察点
     * @param vup      相机的倾斜方向 view up
     * @param vfov     角度 field of view
     * @param aspect   宽高比
     * @param aperture 光圈
     * 
     * 
     */
    public void setCamera(Vec3 lookfrom, Vec3 lookat, Vec3 vup, float vfov, float aspect, float aperture,
            float focus_dist) {

        lens_radius = aperture / 2;

        float theta = (float) (vfov * Math.PI / 180);
        float half_height = (float) (Math.tan(theta / 2));
        float half_width = aspect * half_height;
        origin = lookfrom;
        w = lookfrom.Subtract(lookat).normalize(); // 相当于新的z
        u = vup.cross(w).normalize(); // 相当于新的x
        v = w.cross(u).normalize(); // 相当于新的y
        lower_left = origin.Subtract(u.Scale(half_width * focus_dist)).Subtract(v.Scale(half_height * focus_dist))
                .Subtract(w.Scale(focus_dist));
        horizontal = u.Scale(2 * half_width * focus_dist);
        vertical = v.Scale(2 * half_height * focus_dist);

    }

    Vec3 lookfrom = new Vec3();
    Vec3 lookat = new Vec3(0, 0, -1);
    Vec3 vup = new Vec3(0, 1, 0);
    float vfov = 90;
    float aspect = 2.0f;
    float focus_dist = 1.0f;
    float aperture = 2.0f;

    public void chgeDir(int code) {
        switch (code) {
        case KeyEvent.VK_RIGHT:
            // lookfrom.e[0] += 1;
            this.rotationVec3Y(new Vec3(0,0,1), -30);
            break;
        case KeyEvent.VK_LEFT:
            // lookfrom.e[0] -= 1;
            this.rotationVec3Y(new Vec3(0,0,1), 30);
            break;
        case KeyEvent.VK_UP:
            // lookfrom.e[1] += 1;
            this.rotationVec3X(new Vec3(0,0,1), -30);
            break;
        case KeyEvent.VK_DOWN:
            // lookfrom.e[1] -= 1;
            this.rotationVec3X(new Vec3(0,0,1), 30);
            break;
        default:
            break;
        }

        this.setCamera(lookfrom, lookat, vup, vfov, aspect, aperture, focus_dist);
    }

    Vec3 rotationVec3Y(Vec3 v, double theta) {
        v = MatricVec3.rotationVec3Y(v, theta);
        System.out.println(v);
        MatricVec3 mv3 = new MatricVec3(u, v, w);
        lookfrom = mv3.Multiply(v).Add(lookat);
        return lookfrom;
    }
    Vec3 rotationVec3X(Vec3 v, double theta) {
        v = MatricVec3.rotationVec3X(v, theta);
        System.out.println(v);
        MatricVec3 mv3 = new MatricVec3(u, v, w);
        lookfrom = mv3.Multiply(v).Add(lookat);
        return lookfrom;
    }
}