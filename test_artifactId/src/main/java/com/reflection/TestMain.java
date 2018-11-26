package com.reflection;

/**
 * TestMain
 */
public class TestMain extends Object{

    public static void main(String[] args) {
        /**
         * class java.lang.Integer
            class jdk.internal.loader.ClassLoaders$AppClassLoader
            class jdk.internal.loader.ClassLoaders$PlatformClassLoader
         */
        System.out.println(TestMain.class);
        getParentClass(TestMain.class.getClassLoader());
    }

    static void getParentClass(ClassLoader c) {
        Number n = 0;
        System.out.println(n.getClass());
        while (c != null) {
            System.out.println(c.getClass());
            c = c.getParent();
        }
    }
}