package com.generic;

import java.awt.List;
import java.util.ArrayList;

/**
 * TestGeneric
 */
public class TestGeneric {

    public static void main(String[] args) {
        ArrayList<String> ls = new ArrayList<String>();
        System.out.println(ls);
        
        System.out.println(ls.getClass());
        //class java.lang.Class
        System.out.println(ls.getClass().getClass());
        //class java.lang.Class


    }
}