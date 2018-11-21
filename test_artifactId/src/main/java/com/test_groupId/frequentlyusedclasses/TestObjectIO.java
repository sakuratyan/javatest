package com.test_groupId.frequentlyusedclasses;

import java.io.*;

import javax.imageio.stream.FileImageInputStream;

/**
 * TestObjectIO
 */
public class TestObjectIO {

    public TestObjectIO() {
        T t = new T();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("t.object.dat"));
            oos.writeObject(t);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("t.object.dat"));
            T tr = (T)ois.readObject();
            System.out.println(tr.i+" "+tr.j+" "+tr.f+" "+tr.k);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}

class T implements Serializable {

    int i = 1;
    double j = 1.0D;
    transient float f = 2.0F;
    long k = 4L;
}