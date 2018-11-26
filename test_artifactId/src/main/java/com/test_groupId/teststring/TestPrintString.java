package com.test_groupId.teststring;

/**
 * TestPrintString
 */
public class TestPrintString {

    String s = "abc123";
    String ss = '1' + '2' + '3' + "abc";

    public TestPrintString() {
        char sc[] = { '1', '2', '3' };
        System.out.println((int)sc[0]); 
        System.out.println((int)sc[1]); 
        System.out.println((int)sc[2]); 
        System.out.println(s);
        System.out.println(ss);
    }

}