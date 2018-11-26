package com.reflection;



/**
 * TestJDKClassLOader
 */
public class TestJDKClassLOader implements Interface{
    //String ss = "TestJDKClassLOader.String";
    public TestJDKClassLOader(){
        System.out.println(String.class.getClassLoader());
        //System.out.println();
        System.out.println(TestJDKClassLOader.class.getClassLoader().getClass().getName());
        System.out.println(AAAA.class.getClassLoader().getClass());
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}



class AAAA{

}