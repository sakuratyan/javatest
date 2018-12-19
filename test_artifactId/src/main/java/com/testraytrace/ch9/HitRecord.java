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

    public HitRecord() {
        // t = 0;
        // p = new Vec3(0, 0, 0);
        // normal = new Vec3(0, 0, 0);
    }
}