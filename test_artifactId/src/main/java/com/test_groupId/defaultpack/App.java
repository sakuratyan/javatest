package com.test_groupId.defaultpack;

import com.test_groupId.thread.*;

/**
 * Hello world!
 *
 */

 
public class App {

    //enum Aenumclass  {red,s,st};


    public static void main(String[] args)  {
        System.out.println("Hello World!");

        new TestThread();
        
        //TestFile f = new TestFile("C:\\Users\\11054\\WOrkSpace");

        //String[] s = { "123", "12", "2", "4", "12321" };

        // TestChain t= new TestChain();
        // TestCount c= new TestCount(500);
        // Chainsz sz = new Chainsz(500);
        // TestBinarySearch b = new TestBinarySearch();
        // System.out.println("\u00df \u0053 \u0053 \u0069 \u0130 \u0131 \u0049");
        //TestString t = new TestString(1);
    }

    public static String byteToHex(byte b) {
        return "0x" + byteToHexString(b);
    }

    public static String byteToHexString(byte b) {
        char[] c = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        char[] result = { c[(b >>> 4)], c[b & 0x0f] };
        return new String(result);
    }

    public static String charToHex(char c) {
        System.out.println("0x" + byteToHexString((byte) (c >>> 8)) + byteToHexString((byte) (c & 0x00ff)));
        return "0x" + byteToHexString((byte) (c >>> 8)) + byteToHexString((byte) (c & 0x00ff));
    }

}
