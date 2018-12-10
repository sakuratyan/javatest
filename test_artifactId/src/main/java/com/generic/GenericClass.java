package com.generic;

/**
 * GenericClass
 */

// 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
// 在实例化泛型类时，必须指定T的具体类型
public class GenericClass<T> {
    private T keyT;

    public GenericClass(T k) {
        this.keyT = k;
    }

    public T getKey() {
        return this.keyT;
    }

    public boolean isInteger() {
        if (keyT instanceof Integer)
            return true;
        return false;
    }
}