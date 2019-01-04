package com.testraytrace.mycode;

public abstract class Material {
    /**
     * 材料的反射率
     *  Vec3 xyz [0f,1f]区间
     * 其他的范围太魔幻了
     * 默认全反射
     */
    Vec3 albedo  = new Vec3(1,1,1); // 反射率
    /**
     * 镜面的模糊程度，影响镜面反射方向
     * @区间 [0f,1f]
     */
    float fuzz; // 镜面模糊

    public abstract boolean scatter(Ray r, HitRecord rec);

    /**
     * 生成一个单位球内的随机坐标
     * 
     * @return 单位球内的随机坐标 用于镜面模糊
     */
    public Vec3 randomInUnitSphere() {
        Vec3 p;
        do {
            // 随机坐标 区间[-1,+1]
            p = new Vec3((float) (Math.random()), (float) (Math.random()), (float) (Math.random())).Scale(2.0f)
                    .Subtract(new Vec3(1.0f, 1.0f, 1.0f));
        } while (p.dot(p) >= 1.0f); // 如果坐标在球内则采用，否则再次生成
        return p;
    }
}