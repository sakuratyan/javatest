package com.test_groupId.frequentlyusedclasses;

import java.util.HashSet;
import java.util.Iterator;

/**
 * TestUtils
 */
public class TestUtils {

    public TestUtils(){



        HashSet h = new HashSet<>();
        h.add("2112");
        h.add("213dasdsadsad12");

        h.add("2131sadsadasas2");

        h.add("213sadd12");

        h.add("213sdadd12");
        h.add("21d3ssad12");
        //h.remove("2112");
        Iterator i = h.iterator();

        while(i.hasNext()){
            String s =   (String)i.next();
            if (s.length() > 10) {
                //h.remove(i); 无效
                i.remove();
            }
            
        }
        for (Object var : h) {
            System.out.println(var);
        }

        //System.out.println(h);
    }
}


