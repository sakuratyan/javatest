package com.test_groupId.frequentlyusedclasses;

import java.io.*;

/**
 * TestTransForm
 */
public class TestTransForm {

    public TestTransForm() {
        sysin();
    }

    void sysin(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        try {
            while ((s = br.readLine()) != null) {
                if (s.equals("exit") || s.equals("EXIT")) {
                    // s.equalsIgnoreCase("exit");
                    break;
                }
                System.out.println(s.toUpperCase());
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}