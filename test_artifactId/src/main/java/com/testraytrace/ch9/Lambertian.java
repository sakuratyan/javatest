package com.testraytrace.ch9;

public class Lambertian extends Material {

    public Lambertian() {
    }

    public Lambertian(Vec3 albedo) {
        this.albedo = albedo;
    }

    /**
     *
     * @param r 光线
     * @param rec 碰撞点
     * @param wrapper 包装 衰减系数
     * @return 是否
     */
    public boolean scatter(Ray r, HitRecord rec) {
        Vec3 target = rec.p.Add(rec.normal).Add(randomInUnitSphere());  //相对位置->绝对位置 （p + N） + S
        rec.ref2Ray = new Ray(rec.p, target.Subtract(rec.p));             //源点p 方向->ps
        // wrapper.attenuation = albedo;
        return true;
    }



}