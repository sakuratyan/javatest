package com.reflection;

import java.lang.reflect.Method;

/**
 * TestReflection
 */
public class TestReflection {

    public TestReflection() throws Exception {
        String className = "com.reflection.T";
        Class<?> c = Class.forName(className);
        // Object o = c.newInstance();
        Object o = c.getDeclaredConstructor().newInstance();
        Method[] methods = c.getDeclaredMethods();
        for (Method var : methods) {
            printLines(60 - var.toString().length());
            System.out.println(var);
            Class<?> rv = var.getReturnType();
            System.out.println("returntype:" + rv);
            System.out.print("parametercount:" + var.getParameterCount() + " ");
            for (Class<?> paramatertype : var.getParameterTypes()) {
                System.out.print(paramatertype + " ");
            }
            System.out.println();
            if (var.getName().equals("hi")) {
                // System.out.println(var);
                // var.invoke(o);
            }
        }
    }

    void printLines(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
    }
}

class T {
    int i = 10;
    String s = "T.String";

    int hi() {
        System.out.println("void hi()");
        return 1;
    }

    int geti(String s, int b) {
        s = "T.geti in gets()";
        return i;
    }

    String gets() {
        return s;
    }

}