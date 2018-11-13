
package com.test_groupId.array;

/**
 * TestCount
 */
public class TestCount {
    int[] int500;

    public TestCount(int index) {
        int500 = new int[index];
        for (int i = 0; i < index; i++) {
            int500[i] = i + 1;
        }
        getInfo();
        winInt2(3);
        getInfo();
    }

    // 看的头晕
    int winInt(int skipNum) {
        System.out.println("winInt()");
        int length = int500.length;
        int index = 0;
        while (length != 1) {
            for (int i = 0; i < skipNum - 1; i++) {
                while (int500[index] == -1) {
                    index++;
                    if (index > int500.length - 1) {
                        index -= int500.length;
                    }
                }
                index++;
                if (index > int500.length - 1) {
                    index -= int500.length;
                }
                while (int500[index] == -1) {
                    index++;
                    if (index > int500.length - 1) {
                        index -= int500.length;
                    }
                }
            }

            int500[index] = -1;
            length--;
            index++;
            if (index > int500.length - 1) {
                index -= int500.length;
            }
            while (int500[index] == -1) {
                index++;
                if (index > int500.length - 1) {
                    index -= int500.length;
                }
            }
        }

        for (int j = 0; j < int500.length; j++) {
            if (int500[j] > 0) {
                System.out.println(j + "-" + int500[j]);
            }
        }

        return 0;
    }

    //升级版好多了
    int winInt2(int skipNum) {
        int index = 0;
        int skip = 0;
        int perNum = int500.length;

        while (perNum > 1) {
            if (int500[index] != -1) {
                if (++skip == skipNum) {
                    skip = 0;
                    int500[index] = -1;
                    perNum --;
                }
            }
            index++;
            if (index > int500.length-1) {
                index -=int500.length;
            }
        }

        return 0;
    }

    public String toString() {
        return "y:m:d -- ";// +y+ ":" +m+ ":"+d;
    }

    public void getInfo() {
        System.out.println("TestCount.getInfo()");
        for (int i : int500) {
            System.out.print(i + "-");
        }
        System.out.println();
    }
}