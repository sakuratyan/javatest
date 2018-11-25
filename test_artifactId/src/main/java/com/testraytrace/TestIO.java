package com.testraytrace;

import java.io.*;

/**
 * TestIO
 */
public class TestIO {
    static PrintStream standardOut = System.out;

    static void redsysout(String path) {
        // OutputStreamWriter osw = new OutputStreamWriter(System.out);
        try {
            PrintStream ps = new PrintStream(new File(path));
            if (ps != null) {
                System.setOut(ps);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println("#hello in " + path);
    }
    /**
     * 切换到standardOut
     */
    static void redsysout() {
        //System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.setOut(standardOut);
    }
}