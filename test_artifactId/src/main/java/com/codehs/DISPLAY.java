package com.codehs;

/**
 * DISPLAY
 */
public class DISPLAY {

    public static void main(String[] args) {
        AND_GATE andgate = new AND_GATE();
        andgate.setIn0(true);
        andgate.setIn1(true);

        System.out.println(andgate.out);
    }
}