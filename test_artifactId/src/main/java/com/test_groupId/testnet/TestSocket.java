package com.test_groupId.testnet;

import java.io.*;
import java.net.*;

/**
 * TestSocket
 */
public class TestSocket implements Runnable {
    Socket soc;

    TestSocket(String s) {

    }

    public TestSocket() {
        try {
            ServerSocket ss = new ServerSocket(2000);
            while (true) {
                TestSocket ts = new TestSocket("null");
                ts.soc = ss.accept();
                new Thread(ts).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("a client come in");
        DataInputStream dis;
        DataOutputStream dos;
        try {
            dis = new DataInputStream(soc.getInputStream());
            dos = new DataOutputStream(soc.getOutputStream());

            String s;
            while ((s = dis.readUTF()) != null) {
                if (s.equals("exit") || s.equals("EXIT")) {
                    // s.equalsIgnoreCase("exit");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + ":" + s);
                dos.writeUTF(soc.getInetAddress() + ":" + soc.getPort() + "-" + s);

            }
            soc.close();
        } catch (IOException e) {
            System.out.println("Error:强退！");
            // e.printStackTrace();
        }
        System.out.println("a client leave!");

    }
}