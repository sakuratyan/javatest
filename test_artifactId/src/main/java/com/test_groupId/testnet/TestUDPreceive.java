package com.test_groupId.testnet;

import java.io.*;
import java.net.*;

/**
 * TestUDPreceived
 */
public class TestUDPreceive {

    public TestUDPreceive() {
        byte[] buf = new byte[1024];

        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        try {
            DatagramSocket ds = new DatagramSocket(9999);
            while (true) {
                ds.receive(dp);
                //1:System.out.println(new String(buf, 0, dp.getLength()));
                System.out.println(getByteLong(buf));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static long getByteLong(byte[] b) {
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        DataInputStream dis = new DataInputStream(bais);
        long l = 0L;
        try {
            l = dis.readLong();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return l;
    }

}