package com.test_groupId.testnet;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * TestUDPSend
 */
public class TestUDPSend {

    public static void main(String[] args) throws Exception {
        byte[] buf = "Hello".getBytes();

        long lo = 124312543215L;
        // 1:buf = Long.toString(lo).getBytes();
        buf = getLongbyte(lo);
        DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("localhost", 9999));
        DatagramSocket ds = new DatagramSocket(1000);
        ds.send(dp);
        ds.close();
    }

    static byte[] getLongbyte(Long l) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeLong(l);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }
}