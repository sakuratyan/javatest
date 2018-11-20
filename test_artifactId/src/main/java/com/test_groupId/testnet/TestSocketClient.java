package com.test_groupId.testnet;

import java.io.*;
import java.net.*;

public class TestSocketClient {
    public static void main(String[] args) throws Exception {
        Socket soc = new Socket("127.0.0.1", 2000);
        DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
        DataInputStream dis = new DataInputStream(soc.getInputStream());
        String s = null;
        while ((s = sysinString()) != null) {
            if (s.equals("exit") || s.equals("EXIT")) {
                // s.equalsIgnoreCase("exit");
                dos.writeUTF(s);
                break;
            }
            dos.writeUTF(s);
            System.out.println(dis.readUTF()); 
        }
        dos.writeUTF("asdasd");
    }

    static String sysinString() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
       
    }

}