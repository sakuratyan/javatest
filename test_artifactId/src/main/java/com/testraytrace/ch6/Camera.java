package com.testraytrace.ch6;

/**
 * Camera
 */
public class Camera {

    private Vec3 lower_left;    //画布左下角点
    private Vec3 horizontal;    //宽
    private Vec3 vertical;      //高
    private Vec3 origin;        //相机原点

    HitableList world;

    public Camera() {
        lower_left = new Vec3(-2.0f, -1.0f, -1.0f);
        horizontal = new Vec3(4.0f, 0.0f, 0.0f);
        vertical = new Vec3(0.0f, 2.0f, 0.0f);
        origin = new Vec3(0.0f, 0.0f, 0.0f);
    }
    public Camera(HitableList world){
        this();
        this.world = world;
    }

    /**
     *
     * @param u 距离lower_left的横向距离
     * @param v 距离lower_left的纵向距离
     * @return 光线向量
     */
    public Ray GetRay(float u, float v)
    {
        return new Ray(origin, lower_left.Add(horizontal.Scale(u)).Add(vertical.Scale(v)));
    }

    public Vec3 color(Ray r) {
        HitRecord rec = new HitRecord();
        if (world.hit(r, 0.0f, Float.MAX_VALUE, rec)) {
            // 有撞击点，按撞击点法向量代表的颜色绘制
            return new Vec3(rec.normal.x() + 1, rec.normal.y() + 1, rec.normal.z() + 1).Scale(0.5f);
        }
        Vec3 unit_dir = r.direction().normalize();  //单位方向向量
        float t = 0.5f * (unit_dir.y() + 1.0f);     //原本范围为[-1,1]调整为[0,1]
        return new Vec3(1.0f, 1.0f, 1.0f).Scale(1.0f - t).Add(new Vec3(0.5f, 0.7f, 1.0f).Scale(t));
        //返回背景(1.0-t)*vec3(1.0, 1.0, 1.0) + t*vec3(0.5, 0.7, 1.0); 沿着y轴线性插值，返回的颜色介于白色与天蓝色之间
    }

}