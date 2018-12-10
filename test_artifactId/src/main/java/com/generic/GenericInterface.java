package com.generic;

/**
 * GenericInterface
 */

//未传入类型实参，须将接口中的泛型声明加入到类的声明中。
public class GenericInterface<T> implements Generator<T> {
// public class GenericInterface implements Generator<String> {

    @Override
    public T next() {
    // public String next() {
        return null;
    }

}

interface Generator<T>{
    T next();
}