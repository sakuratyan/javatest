package com.test_groupId.frequentlyusedclasses;

import java.util.*;

/**
 * generic type
 */
public class TestCountArgsWord {

    public  TestCountArgsWord(String[] args) {
        Map<String,Integer> m = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            Integer c = m.get(args[i]);
            //System.out.println(c);
            m.put(args[i], (c == null ? 1 : c+1));
        }
        System.out.println(m);
    }
}