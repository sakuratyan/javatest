
package com.test_groupId.datastruct;

/**
 * TestBinarySearch
 */
public class TestBinarySearch {

    public TestBinarySearch() {
        int[] w = { 0, 1, 2, 3, 5, 6, 7, 8, 9 };
        System.out.println(binarySearch(w,4));
    }

    public static int binarySearch(int[] numArray, int a) {
        if (numArray.length == 0) {
            return -1;
        }
        if (a > numArray[numArray.length - 1] || a < numArray[0]) {
            return -2;
        }

        int left = 0;
        int right = numArray.length - 1;
        int midIndex = (left + right) / 2;
        while (numArray[midIndex] != a) {
            if (numArray[midIndex] > a) {
                right = midIndex;
                midIndex = (left + right) / 2;
            }
            if (numArray[midIndex] < a) {
                left = midIndex;
                midIndex = (left + right) / 2;
            }
            if (midIndex == left) {
                System.out.println("no fnid");
                return -3;
            }
        }
        return midIndex;
    }
}