package com.testraytrace.ch9;


/**
 * 记录撞击点的时间，坐标，单位法向量，材质
 */
public class HitRecord {
    public float t; // 相撞的时间
    /** 
     * 撞击点的坐标
    */
    public Vec3 p; 
    /**
     * 撞击点的单位法向量
     */
    public Vec3 normal; 

    /**
     * 撞击的材质
     */
    public Material matPtr; 
    /**
     * 反射光线
     */
    public Ray reflectedRay;
    /**
     * 折射光线
     */
    public Ray refractedRay;
    /**
     * 折射光线向量
     * 是否有折射光线
     */
    public Vec3 refractedVec3;
    /**
     * 折射？入射 2选1
     */
    public Ray ref2Ray;

    public HitRecord() {
        // t = 0;
        // p = new Vec3(0, 0, 0);
        // normal = new Vec3(0, 0, 0);
    }
}