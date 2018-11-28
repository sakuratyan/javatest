package com.test_groupId.innerclass;

/**
 * TestFunc
 */
public class TestFunc {
    String name ="Pub TestFunc";
    
    //编译时方法确定字符串地址。
    void hi(){
        System.out.println(this.name);
    }
    
}