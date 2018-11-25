package com.testraytrace;

/**
 * PrintPPM
 */
public class PrintPPM {
    int w = 500, h = 400, mcv = 255;

    public PrintPPM(String path) {
        TestIO.redsysout(path);
        writeHead();
        write1();
        TestIO.redsysout();
    }

    public void writeHead(int _w, int _h) {
        System.out.println("P3");
        System.out.println(w + " " + h);
        System.out.println(mcv);
    }

    public void writeHead() {
        writeHead(w, h);
    }

    public void write1() {
        int r, g, b;
        for (int i = 0; i < h; i++) {
            for (int y = 0; y < w; y++) {
                r = (int)((mcv+0.99)*y/w);
                g = (int)((mcv+0.99)*i/w);
                b = (int)((mcv+0.99)*y/w);
                System.out.print(r + " " + g + " " + b+" ");
            }
            System.out.println();
        }
        TestIO.redsysout();
        System.out.println("end");
    }
}