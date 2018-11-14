package com.test_groupId.frequentlyusedclasses;

/**
 * TestString
 */
public class TestString {
    String atoZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String aTOz = atoZ.toLowerCase();

    TestString() {
        String s = "asdas12312ASDasdDsadSAD ! (*&*9（*）";
    }

    public static String[] countChar(String s) {
        if (s == null) {
            return null;
        }
        String[] r = new String[3];
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        for (int i = 0; i < s.length(); i++) {
            s.charAt(i);
        }
        r[0] = new String("upperCaseCount:"+upperCaseCount);
        r[1] = new String("lowerCaseCount:"+lowerCaseCount);
        r[2] = new String("otherCharacterCount:"+(s.length()-upperCaseCount-lowerCaseCount));
        return r;
    }
}