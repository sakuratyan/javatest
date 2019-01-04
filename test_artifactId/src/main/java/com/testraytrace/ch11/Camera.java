package com.testraytrace.ch11;

import com.testraytrace.ch9.*;

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
        this();
        this.world = world;
    }

    public static void main(String[] args) {
        // Camera c = new Camera(new Vec3(0, 0, -1), new Vec3(0, 0, -1), new Vec3(0, 1, 0), 90, 2);
        // System.out.println(c.lower_left);
        // System.out.println(c.horizontal);
        // System.out.println(c.vertical);
        randomInUnitSphere();
    }

     /**
     *
     * @param lookfrom 相机位置
     * @param lookat 观察点
     * @param vup 相机的倾斜方向 view up
     * @param vfov 角度 field of view
     * @param aspect 宽高比
     */
    public Camera(Vec3 lookfrom, Vec3 lookat, Vec3 vup, float vfov, float aspect, float aperture){
        float focus_dist = (lookfrom.Subtract(lookat)).length();
        lens_radius = aperture / 2;

        float theta = (float)(vfov * Math.PI / 180);
        float half_height = (float)( Math.tan(theta/2) );
        float half_width = aspect * half_height;
        origin = lookfrom;
        w = lookfrom.Subtract(lookat).normalize();      //相当于新的z
        u = vup.cross(w).normalize();                   //相当于新的x
        v = w.cross(u).normalize();                     //相当于新的y
        lower_left = origin.Subtract(u.Scale(half_width*focus_dist)).Subtract(v.Scale(half_height*focus_dist)).Subtract(w.Scale(focus_dist));
        horizontal = u.Scale(2*half_width*focus_dist);
        vertical = v.Scale(2*half_height*focus_dist);
    }

    /**
     *
     * @param u 距离lower_left的横向距离
     * @param v 距离lower_left的纵向距离
     * @return 光线向量
     */
    public Ray GetRay(float u, float v)
    {
        Vec3 rd = randomInUnitSphere().Scale(lens_radius);
        Vec3 offset = this.u.Scale(rd.x()).Add(this.v.Scale(rd.y()));
        return new Ray(origin.Add(offset), lower_left.Add(horizontal.Scale(u)).Add(vertical.Scale(v)).Subtract(origin).Subtract(offset));
    }

    /**
     * 生成一个单位球内的随机坐标，模拟光圈棱镜
     * 
     * @return 单位球内的随机坐标
     */
    public static Vec3 randomInUnitSphere() {
        Vec3 p;
        do {
            // 随机坐标 区间[-1,+1]
            //2*2平面随机一点减去点(1,1,1)
            p = new Vec3((float) (Math.random()), (float) (Math.random()), 0).Scale(2.0f)
                    .Subtract(new Vec3(1.0f, 1.0f, 0.0f));
            // System.out.println(p);
        } while (p.dot(p) >= 1.0f); // 如果坐标在球内则采用，否则再次生成
        return p;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}