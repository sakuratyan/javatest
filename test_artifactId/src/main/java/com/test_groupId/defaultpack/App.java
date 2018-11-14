package com.test_groupId.defaultpack;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] s = { "123", "12", "2", "4", "12321" };

        // TestChain t= new TestChain();
        // TestCount c= new TestCount(500);
        // Chainsz sz = new Chainsz(500);
        // TestBinarySearch b = new TestBinarySearch();
        // System.out.println("\u00df \u0053 \u0053 \u0069 \u0130 \u0131 \u0049");
        char ss[] = { 1, 'a', 1 };
        byte a = 'a';
        System.out.println(charToHex('1'));

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

        return "0x" + byteToHexString((byte) (c >>> 8)) + byteToHexString((byte) (c & 0x00ff));
    }

}
