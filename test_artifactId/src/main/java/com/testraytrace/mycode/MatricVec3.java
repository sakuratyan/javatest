package com.testraytrace.mycode;

/**
 * Matrices
 */
public class MatricVec3 {
    Vec3 i = new Vec3(1, 0, 0);
    Vec3 j = new Vec3(0, 1, 0);
    Vec3 k = new Vec3(0, 0, 1);

    MatricVec3() {
    }

    MatricVec3(Vec3 i, Vec3 j, Vec3 k) {
        if (i != null) {
            this.i = i;
        }
        if (j != null) {
            this.j = j;
        }
        if (k != null) {
            this.k = k;
        }
    }

    public static void main(String[] args) {
        // Vec2 v2 = new Vec2(3, 5);
        // System.out.println(v2);
        // Vec2 nv2 = MatricVec2.rotaionVec2(v2, 180);
        // System.out.println(nv2);
        Vec3 v3 = new Vec3(3, 2, 1);
        System.out.println(v3);
        v3 = MatricVec3.rotationVec3X(v3, 180);
        System.out.println(v3);

    }

    /**
     * @param v     需要旋转的向量
     * @param theta j轴旋转角度,
     * @return
     */
    static Vec3 rotationVec3Y(Vec3 v, double theta) {
        theta = (theta * Math.PI / 180);
        // Vec2 i = new Vec2((float) Math.cos(theta), );
        // Vec2 j = new Vec2((float) Math.sin(theta), (float) Math.cos(theta));
        Vec3 i = new Vec3((float) Math.cos(theta), 0, (float) Math.sin(theta));
        Vec3 k = new Vec3(-(float) Math.sin(theta), 0, (float) Math.cos(theta));
        MatricVec3 mv3 = new MatricVec3(i, null, k);
        return mv3.Multiply(v);
    }

    static Vec3 rotationVec3X(Vec3 v, double theta) {
        theta = (theta * Math.PI / 180);
        Vec3 j = new Vec3(0,(float) Math.cos(theta), -(float) Math.sin(theta));
        Vec3 k = new Vec3( 0,(float) Math.sin(theta), (float) Math.cos(theta));
        MatricVec3 mv3 = new MatricVec3(null, j, k);
        return mv3.Multiply(v);
    }

    public Vec3 Multiply(Vec3 v) {
        return this.i.Scale(v.e[0]).Add(this.j.Scale(v.e[1])).Add(this.k.Scale(v.e[2]));
    }

    @Override
    public String toString() {
        return "MatricVec3 i" + i + "\n" + "MatricVec3 j" + j + "\n" + "MatricVec3 k" + k;
    }
}

// class Vec2 {
// public float[] e = new float[2];

// Vec2() {
// }

// Vec2(float x, float y) {
// this.e[0] = x;
// this.e[1] = y;
// }

// Vec2 scale(float n) {
// return new Vec2(n * e[0], n * e[1]);
// }

// Vec2 add(Vec2 y) {
// return new Vec2(this.e[0] + y.e[0], this.e[1] + y.e[1]);
// }

// @Override
// public String toString() {
// return "Vec2 x:" + e[0] + " y:" + e[1];
// }
// }

// class MatricVec2 {
// Vec2 i = new Vec2(1, 0);
// Vec2 j = new Vec2(0, 1);

// MatricVec2() {
// }

// MatricVec2(Vec2 i, Vec2 j) {
// this.i = i;
// this.j = j;
// }

// Vec2 Multiply(Vec2 x) {
// return this.i.scale(x.e[0]).add(this.j.scale(x.e[1]));
// }

// static Vec2 rotaionVec2(Vec2 x, double theta) {
// theta = (theta * Math.PI / 180);
// Vec2 i = new Vec2((float) Math.cos(theta), (float) Math.sin(theta));
// Vec2 j = new Vec2(-(float) Math.sin(theta), (float) Math.cos(theta));
// MatricVec2 mv2 = new MatricVec2(i, j);

// return mv2.Multiply(x);
// }
// }