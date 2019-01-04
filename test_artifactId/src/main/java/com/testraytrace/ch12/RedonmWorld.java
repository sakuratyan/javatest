package com.testraytrace.ch12;

import com.testraytrace.ch9.*;

import java.util.*;

/**
 * RedonmWorld
 */
public class RedonmWorld {
    

    static HitableList  random_scene() {
        HitableList world = new HitableList();

        // 超大漫反射球作为地板
        world.addElements(new Sphere(new Vec3(0.0f, -1000.0f, 0.0f), 1000.0f, new Lambertian(new Vec3(0.5f, 0.5f, 0.5f))));
        // 定义三大球
        world.addElements(new Sphere(new Vec3(0, 1, 0), 1.0f, new Dielectic(1.5f)));
        world.addElements(new Sphere(new Vec3(-4, 1, 0), 1.0f, new Lambertian(new Vec3(0.4f, 0.2f, 0.1f))));
        world.addElements(new Sphere(new Vec3(4, 1, 0), 1.0f, new Metal(new Vec3(0.7f, 0.6f, 0.5f), 0.0f)));

        // 生成地面小球
        int i = 1;
        for (int a = -11; a < 11; a++) {
            for (int b = -11; b < 11; b++) {
                /* 两个for循环中会产生（11+11）*(11+11)=484个随机小球 */
                float choose_mat = (float) Math.random();
                /* 产生一个（0，1）的随机数，作为设置小球的材质的阀值 */
                Vec3 center = new Vec3((float) (a + 0.9 * (Math.random())), 0.2f, (float) (b + 0.9 * (Math.random())));
                /* 球心的x,z坐标散落在是（-11，11）之间的随机数 */
                if ((center.Subtract(new Vec3(4, 0.2f, 0))).length() > 0.9) {
                    /* 避免小球的位置和最前面的大球的位置太靠近 */
                    if (choose_mat < 0.8) { // diffuse
                        /* 材料阀值小于0.8，则设置为漫反射球，漫反射球的衰减系数x,y,z都是（0，1）之间的随机数的平方 */
                        world.addElements(new Sphere(center, 0.2f,
                                new Lambertian(new Vec3((float) ((Math.random()) * (Math.random())),
                                        (float) ((Math.random()) * (Math.random())),
                                        (float) ((Math.random()) * (Math.random()))))));
                    } else if (choose_mat < 0.95) {
                        /* 材料阀值大于等于0.8小于0.95，则设置为镜面反射球，镜面反射球的衰减系数x,y,z及模糊系数都是（0，1）之间的随机数加一再除以2 */
                        world.addElements(new Sphere(center, 0.2f,
                                new Metal(new Vec3((float) (0.5f * (1 + (Math.random()))),
                                        (float) (0.5f * (1 + (Math.random()))), (float) (0.5f * (1 + (Math.random())))),
                                        (float) (0.5 * (1 + (Math.random()))))));
                    } else {
                        /* 材料阀值大于等于0.95，则设置为介质球 */
                        world.addElements(new Sphere(center, 0.2f, new Dielectic(1.5f)));
                    }
                }
            }
        }
        return world;
    }
}