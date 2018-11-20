package com.test_groupId.frequentlyusedclasses;

import java.io.*;

/**
 * TestFileWriter
 */
public class TestFileWriter {

    public TestFileWriter() {
        String path = "./mark.txt";
        String pathRead = "test_artifactId/src/main/java\\com\\test_groupId\\frequentlyusedclasses\\TestFileWriter.java";
        // writerUnicode(path);
        markTest(path);
    }

    int writerUnicode(String path) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            for (int i = 0; i <= Character.MAX_VALUE; i++) {
                fw.write(i);
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("写入错误:" + path);
        }

        return 0;
    }

    int readerTest(String path) {

        try {
            FileReader fr = new FileReader(path);
            int c = 0;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //fr.close();
        
        return 0;
    }

    int markTest(String path) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
            int c = bis.read();
            System.out.println((char) c);
            bis.mark(1);
            c = bis.read();
            
            System.out.println((char) c);
            c = bis.read();
            System.out.println((char) c);
            c = bis.read();
            System.out.println((char) c);
            c = bis.read();
            System.out.println((char) c);
            bis.reset();
            c = bis.read();
            System.out.println((char) c);
            System.out.println((char) c);
            System.out.println((char) c);
            System.out.println((char) c);

            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    int writerByte(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            for (int i = 0; i < 20; i++) {
                fos.write('0' + i);
            }
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}