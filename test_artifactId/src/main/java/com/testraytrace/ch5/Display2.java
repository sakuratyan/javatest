package com.testraytrace.ch5;

import com.testraytrace.ch3.*;

/**
 * Display2
 */
final public class Display2 extends com.testraytrace.ch3.Display {
    HitableList world = new HitableList();

    public static void main(String[] args) {
        new Display2("ch5.2.png").launch();
    }

    private Display2(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public void myView() {
        world.addElements(new Sphere(new Vec3(0.0f, 0.0f, -1.0f), 0.5f));
        world.addElements(new Sphere(new Vec3(0.3f, 0.0f, -1.0f), 0.3f));
        world.addElements(new Sphere(new Vec3(0.0f, -100.5f, -1.0f), 100f));

        super.myView();
    }

    @Override
    public Vec3 color(Ray r) {
        HitRecord rec = new HitRecord();
        if (world.hit(r, 0.0f, Float.MAX_VALUE, rec)) {
            // 有撞击点，按撞击点法向量代表的颜色绘制
            return new Vec3(rec.normal.x() + 1, rec.normal.y() + 1, rec.normal.z() + 1).Scale(0.5f);
        } else {
            return super.color(r);
        }
    }

}