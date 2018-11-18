package com.test_groupId.testinterface;

/**
 * TestInterface
 */
public class TestInterface {

    int st ;
    static int st2 ;

    public TestInterface() {
        InnerTestInterface w = new Tets();
        w.fun();
        // int ab = w.a;

        String a = new String("hgjgjhkghjkghjkghghghjgkjlhkjhkljhjkhkjhkjhjklhjkikhgkhj");
        String b = a;
        System.out.println(a.hashCode());

    }

     void test2(){
    }

    static void test(){
        //st =2;
        //test2();
    }
}

/**
 * InnerTestInterface
 */

class Tets implements InnerTestInterface {
    @Override
    public void fun() {
        System.out.println("fun");
    }
}

interface InnerTestInterface {
   final int a = 0;

    void fun();
}