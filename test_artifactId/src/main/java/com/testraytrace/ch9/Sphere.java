package com.testraytrace.ch9;

/**
 * Sphere
 */
public class Sphere implements Hitable {

    Vec3 center;
    float radius;
    /**
     * 材质，决定反射系数和镜面模糊
     */
    Material mat;

    /**
     * 
     * @param center
     * @param radius
     */
    public Sphere(Vec3 center, float radius, Material mat) {
        this.center = center;
        this.radius = radius;
        this.mat = mat;
    }

    @Override
    public boolean hit(Ray r, float t_min, float t_max, HitRecord rec) {
        Vec3 oc = r.origin().Subtract(center);
        float a = r.direction().dot(r.direction());
        float b = 2 * oc.dot(r.direction());
        float c = oc.dot(oc) - radius * radius;
        float discriminant = b * b - 4.0f * a * c;
        if (discriminant > 0) {
            // 优先选取符合范围的根较小的撞击点，若没有再选取另一个根
            float discFactor = (float) Math.sqrt(discriminant);
            float temp = (-b - discFactor) / (2.0f * a);
            if (temp < t_max && temp > t_min) {
                rec.t = temp;
                rec.p = r.point_at_parameter(rec.t);
                rec.normal = (rec.p.Subtract(center)).Scale(1.0f / radius);
                rec.matPtr = this.mat;
                return true;
            }
            temp = (-b + discFactor) / (2.0f * a);
            if (temp < t_max && temp > t_min) {
                rec.t = temp;
                rec.p = r.point_at_parameter(rec.t);
                rec.normal = (rec.p.Subtract(center)).Scale(1.0f / radius);
                rec.matPtr = this.mat;
                return true;
            }
        }
        return false;
    }
}