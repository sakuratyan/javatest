package com.algorithm;

/**
 * Round
 */
public class Round {
    private final int BASE = 4;
    private final int RATIO = 3;

    public Round(int x) {
        // System.out.println(round1(x));
        System.out.println(round2(x));
    }

    //BMP取整 不会用
    // int round1(int x) {
    //     return ((RATIO * x + 31) >> 5) << 2;
    // }

    int round2(int x) {
        return (RATIO * x + BASE - 1) >> 2 << 2;
    }
}