package com.test_groupId.gui;

import java.awt.*;
/**
 * TenButtons
 */
public class TenButtons {
    public TenButtons() {
        Frame f= new Frame("public class TenButtons {");
        Button[] but = new Button[10];
        for (int i = 0; i < but.length; i++) {
            but[i] = new Button("BUTTON:"+ i);
        }
        Panel p1 =new Panel(new BorderLayout());
        // p1.setLayout(new GridLayout(1,3));
        p1.add(but[0],BorderLayout.WEST);//0
        Panel p2 = new Panel(new GridLayout(2,1));
        p2.add(but[1]);
        p2.add(but[2]);
        p1.add(p2,BorderLayout.CENTER);//1 2
        p1.add(but[3],BorderLayout.EAST);//3
        


        Panel p3 = new Panel(new GridLayout(1,3));
        // Panel p3 = new Panel(new BorderLayout());
        p3.add(but[4]);//4
        Panel p4 =new Panel(new GridLayout(2,2));
        p4.add(but[5]);
        p4.add(but[6]);
        p4.add(but[7]);
        p4.add(but[8]);

        p3.add(p4);//5678
        p3.add(but[9]); //9


        f.setLayout(new GridLayout(2,1));
        f.add(p1);
        f.add(p3);
        f.pack();
        f.setVisible(true);
    }

}

class MyGridLayout extends Panel {
    MyGridLayout(){

    }
}