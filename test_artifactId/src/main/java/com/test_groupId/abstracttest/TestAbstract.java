package com.test_groupId.abstracttest;

import com.test_groupId.defaultpack.TestBase;


public class TestAbstract extends Bird{

    public void printTest(){
        System.out.println("Animal.Bird.TestAbstract");
        Animal a = new TestAbstract();
        a.a = 10;
    }
}

abstract class Animal extends TestBase {
    int a;
}

abstract class Bird extends Animal{
    void hi(){
        
    }
}