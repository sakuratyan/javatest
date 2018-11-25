package com.test_groupId.genrictype;

import java.util.ArrayList;

/**
 * TestGenericType
 */
public /* final*/ class TestGenericType<T extends Object,B> {

    public TestGenericType() {
        System.out.println(maxnum(1, 2)); 
        testArrlist(arrLI);
        testArrlist(arrLS);

    }

    <A extends Comparable<A>> A maxnum(A a, A b) {

        return a.compareTo(b) > 0 ? a : b;
    }

    <C extends TestGenericType> C fun(){
        C c =null;
        return c;
    }

     TestGenericType<?,?>  get(){
        return null;
    }


    ArrayList<String> arrLS = new ArrayList<>();
    ArrayList<Integer> arrLI = new ArrayList<>();
    {
        arrLS.add("icon");
        arrLI.add(100);
    }
    void testArrlist(ArrayList<?> a){

        System.out.println(a.toString());
       
    }

}