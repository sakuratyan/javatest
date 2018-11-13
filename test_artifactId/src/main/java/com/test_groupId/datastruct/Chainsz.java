
package com.test_groupId.datastruct;

/**
 * Chainsz
 */
public class Chainsz {
    int[] sz;
    // int length;

    public Chainsz(int num) {
        sz = new int[num];
        // length = sz.length;
        for (int i = 0; i < num; i++) {
            sz[i] = i + 1;
        }
        sz[num - 1] = 0;

        // getInfo();
        int index = 0;
        int skip = 0;
        while (index != sz[index]) {
            if (++skip == 3) {
                del(index);
                skip = 0;
            }
            index = sz[index];
        }

        // getInfo();
        System.out.println(index);
    }

    void del(int id) {

        int i = id;
        do {
            i = sz[i];

        } while (sz[i] != id);

        sz[i] = sz[id];

        // length--;
    }

    // void getInfo() {
    //     System.out.println("length:" + length);
    //     for (int i = 0; i < sz.length; i++) {
    //         System.out.println(i + ":" + sz[i]);
    //     }
    // }
}