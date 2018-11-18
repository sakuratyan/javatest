package com.test_groupId.defaultpack;

import com.test_groupId.testdefault.TestDefault;

class Hi extends TestDefault {

    int i = 3;// default
    String s_default = "String s_default in Hi.java";

    public void hi() {
        System.out.println("Hi,I'm here.package com.test_groupId.defaultpack");
        System.out.println("");

    }

    Hi() {
        testSWitch(0);
        
    }

    public int testSWitch(int a) {

        switch (a > 0 ? 1 : a < 0 ? -1 : 0) {
        // switch (-1+"dsad") {

        case 1:
            //
            System.out.println("+" + 1);
            break;
        case -1:
            //
            System.out.println(-1);
            break;
        default:
            System.out.println(0);
            break;
        }

        return 0;
    }
}