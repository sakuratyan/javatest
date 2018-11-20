package com.test_groupId.frequentlyusedclasses;

import java.io.File;
import java.io.IOException;

/**
 * TestFile
 */
public class TestFile {

    public TestFile(String s) {
        if (new File(s).isDirectory()) {
            System.out.println("total:" + redir(s));
        }
    }

    public TestFile() {
        // String directory = "/";
        String fileName = "test_artifactId";

        File f = new File(fileName);

        if (f.exists()) {
            System.out.println(f.getAbsolutePath());
            System.out.println(f.length());
        } else {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // String[] dirList = new File("test_artifactId").list();
        // for (String var : dirList) {
        // System.out.println(var);
        // }
        // String separator = File.separator;
    }

    static int iredir = -1;

    static public long redir(String pn) {
        File f = new File(pn);
        iredir++;

        if (f.isFile()) {
            printDash(iredir * 2);
            System.out.println("F:" + f.getName() + " " + f.length());
            iredir--;
            return f.length();
        }
        String[] dir = f.list();
        printDash(iredir * 2);
        System.out.println("D:" + f.getName() + " " + dir.length);

        long total = 0;
        for (String var : dir) {
            total += redir(pn + "/" + var);
        }
        iredir--;
        return total;
    }

    static void printDash(int num) {
        if (num <= 0) {
            return;
        }
        System.out.print("-");
        printDash(--num);
    }

    static long redirup(File f,int n){
        if(f.isFile()){
            printDash(n * 2);
            System.out.println("F:" + f.getName() + " " + f.length());
            return f.length();
        }

        File[] dir = f.listFiles();
        printDash(n * 2);
        System.out.println("D:" + f.getName() + " " + dir.length);

        long total = 0;
        for (File var : dir) {
            total += redirup(var,1+n);
        }
        return total;
    }

    public static long redir2(String s){
        File f = new File(s);
        return redirup(f, 0);
    }
}