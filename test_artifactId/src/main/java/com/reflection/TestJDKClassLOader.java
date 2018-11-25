package com.reflection;

/**
 * TestJDKClassLOader
 */
public class TestJDKClassLOader implements Interface{
    String ss = "TestJDKClassLOader.String";
    public TestJDKClassLOader(){
        System.out.println(String.class.getClassLoader());
        //Object a;
        //TestJDKClassLOader.class.getClassLoader();
    }
}