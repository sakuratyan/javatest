package com.test_groupId.testdefault;

class name{
    name(){
        System.out.println("class name,name()");
    }
}
/**
 * TestDefault
 */
public class TestDefault {

    public int i = 1;
    protected int j =2; 
    int k =3; //defualt
    protected String s_default_T = "String s_default in TestDefault.java";
    private int a = 4;

    public void fun(){
        this.i= a;
        name n = new name();
    }

}