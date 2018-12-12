package com.generic;

import java.util.ArrayList;

/**
 * TestGeneric
 */
public class TestGeneric extends Object {

    public static void main(String[] args) {
        ArrayList<String> ls = new ArrayList<String>();

        System.out.println(ls);

        System.out.println(ls.getClass());
        // class class java.util.ArrayList
        System.out.println(ls.getClass().getClass());
        // class java.lang.Class
        testGenericClass();
    }

    private static void testGenericClass() {
        // 泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        // 传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        GenericClass<Integer> gci = new GenericClass<>(123456);

        // 传入的实参类型需与泛型的类型参数类型相同，即为String.
        GenericClass<String> gcs = new GenericClass<String>("key_vlaue");

        //可以不传入类的实参,new 的泛型参数<>默认就是定义变量传入的参数
        GenericClass gc = new GenericClass<>(123.456);

        // showGenericClass(gci);
        // showGenericClass(gcs);
        // showGenericClass(gc);
        // showKeyName(100, gcs);

    }

    //泛型通配符，？是实参，类似String Integer。像是这俩个父类。
    private static void showGenericClass(GenericClass<?> gc){
    // private static void showGenericClass(GenericClass<? extends String> gc){
        System.out.println(gc.getKey());
    }

    //泛型方法
    private static <T> T showKeyName(T t,GenericClass<T> gc){
        System.out.println(t);
        System.out.println(gc.getKey());
        return t;
    }
}