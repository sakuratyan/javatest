package com.testraytrace.ch9;

import com.testraytrace.ch1.MyImage;

/**
 * Display
 */
public class Display extends MyImage {

    public static void main(String[] args) {
        long o = System.currentTimeMillis();
        new Display("ch9.png").launch();

        System.out.println("total time: "+(System.currentTimeMillis()-o));
    }

    @Override
    public void myView() {
        HitableList world = new HitableList();
        Camera camera = new Camera(world);
        world.addElements(new Sphere(new Vec3(0.0f, 0.0f, -1.0f), 0.5f, new Metal(new Vec3(0.9f, 0.9f, 0.9f), 0.0f)));
        world.addElements(new Sphere(new Vec3(0.0f, -100.5f, -1.0f), 100f, new Metal(new Vec3(0.8f, 0.6f, 0.2f), 0.9f)));
        world.addElements(new Sphere(new Vec3(-1.5f,0,-2), 0.5f, new Dielectic(1.5f)));


        int ns = 100; // 采样次数 消锯齿
        for (int j = this.IM_H - 1; j >= 0; j--) {
            for (int i = 0; i < this.IM_W; i++) {
                Vec3 color = new Vec3(0, 0, 0); // 初始化该点的像素
                for (int s = 0; s < ns; s++) {
                    float u = (float) (i + Math.random()) / (float) this.IM_W; // 添加随机数 消锯齿Math.random() <-- 0
                    float v = (float) (j + Math.random()) / (float) this.IM_H;
                    Ray r = camera.GetRay(u, v); // 根据uv得出光线向量
                    color = color.Add(this.color(r,world)); // 根据每个像素点上色 累加
                }
                color = color.Scale(1.0f / (float) ns); // 除以采样次数 求平均
                //gamma矫正
                color  = new Vec3((float)Math.sqrt(color.x()), (float)Math.sqrt(color.y()), (float)Math.sqrt(color.z())); 

                int ir = (int) (color.x() * 255.0 + 0.5);
                int ig = (int) (color.y() * 255.0 + 0.5);
                int ib = (int) (color.z() * 255.0 + 0.5);
                setRGB(i, this.IM_H - j - 1, setColor(ir, ig, ib));
            }
            // this.value = (int) (100.0 * (this.IM_H - j) / this.IM_H);
            this.value = 100;
        }

    }

    public Vec3 color(Ray r, HitableList world){
        return color(r, world, 1);
    }
    public Vec3 color(Ray r, HitableList world, int depth)
    {
        HitRecord rec = new HitRecord();
        if(world.hit(r, 0.001f, Float.MAX_VALUE, rec)){
            //任何物体有撞击点
            // Wrapper wrapper = new Wrapper();
            if(depth < 50 && rec.matPtr.scatter(r, rec)){
                //材料的反射系数是反射过来的光的 xyz都不同程度的缩小
                return color(rec.ref2Ray, world, depth+1).Multiply(rec.matPtr.albedo);
            }else{
                // System.out.println("真能反射那么多次吗！");真有！
                return new Vec3(0,0,0);
            }
        }
        else{
            //没有撞击点，绘制背景
            Vec3 unit_dir = r.direction().normalize();  //单位方向向量
            float t = 0.5f * (unit_dir.y() + 1.0f);     //原本范围为[-1,1]调整为[0,1]
            return new Vec3(1.0f, 1.0f, 1.0f).Scale(1.0f - t).Add(new Vec3(0.5f, 0.7f, 1.0f).Scale(t));
            //返回背景(1.0-t)*vec3(1.0, 1.0, 1.0) + t*vec3(0.5, 0.7, 1.0); 沿着y轴线性插值，返回的颜色介于白色与天蓝色之间
        }
    }

    protected Display(String imgName) {
        this.imgName = imgName;
    }
}