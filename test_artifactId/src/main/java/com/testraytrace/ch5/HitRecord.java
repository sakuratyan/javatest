package com.testraytrace.ch5;

import com.testraytrace.ch3.*;

/**
 * HitRecord
 */
public class HitRecord {
    public float t; // 相撞的时间
    public Vec3 p; // 撞击点的坐标
    public Vec3 normal; // 撞击点的法向量

    public HitRecord() {
        // t = 0;
        // p = new Vec3(0, 0, 0);
        // normal = new Vec3(0, 0, 0);
    }
}