package com.test_groupId.frequentlyusedclasses;

/**
 * TestString
 */
public class TestString {

    public TestString(int n){
        String s = "1,2;3,4,5;6,7,8";

        double[][] d = parseDoubleArray(s);
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++){
                System.out.print("d["+i+","+j+"]="+d[i][j]+" ");
            }
            System.out.println();
        }

        
        System.out.println(Math.toRadians(60)/Math.PI);
    }

    double[][] parseDoubleArray(String s){
        String[] str1 = s.split(";");
        double[][] d = new double[str1.length][];

        for (int i = 0; i < str1.length; i++) {
            String[] strtemp = str1[i].split(","); 
            d[i] = new double[strtemp.length];
            for (int j = 0; j < strtemp.length; j++) {
                d[i][j] = Double.parseDouble(strtemp[j]) ;
            }
        }


        return d;
    }






    public TestString(String s) {
        s = "hello sun java hello ha ok  ok ok ok jajaokok";
        String substr ="ok";
        int count = 0;
        int index = 0;

        while (-1 !=(index = (s.indexOf(substr, index))) ) {
            index++;
            count++;
        }
        System.out.println(count);
    }

    static String atoZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String aTOz = atoZ.toLowerCase();

    public TestString() {
        String s = "asdas12312ASDasdDsadSAD ! (*&*9（*）";

        String[] r = countChar(aTOz);

        System.out.println(r[0] + r[1] + r[2]);

        for (int i = 0; i < 26; i++) {
            char aU = 'a';
            char aL = 'A';
            System.out.print("" + (char) (aU + i) + (char) (aL + i));
        }

    }

    public static String[] countChar(String s) {
        if (s == null) {
            return null;
        }
        String[] r = new String[3];
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        for (int i = 0; i < s.length(); i++) {
            // c =s.charAt(i);if('a' <= c && c >= 'z')
            if (atoZ.indexOf(s.charAt(i)) >= 0) {
                upperCaseCount++;
            }
            // if('A' <= c && c >= 'Z')
            if (aTOz.indexOf(s.charAt(i)) >= 0) {
                lowerCaseCount++;
            }
        }
        r[0] = new String("upperCaseCount:" + upperCaseCount);
        r[1] = new String("\nlowerCaseCount:" + lowerCaseCount);
        r[2] = new String("\notherCharacterCount:" + (s.length() - upperCaseCount - lowerCaseCount));
        return r;
    }
}