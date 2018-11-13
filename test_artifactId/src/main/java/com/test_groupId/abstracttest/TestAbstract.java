package com.test_groupId.abstracttest;

import com.test_groupId.defaultpack.TestBase;


public class TestAbstract extends Bird{

    public void printTest(){
        System.out.println("Animal.Bird.TestAbstract");
    }
}

abstract class Animal extends TestBase {
    
}

abstract class Bird extends Animal{

}