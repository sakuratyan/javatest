package com.test_groupId.gui;

import java.awt.*;
import java.awt.event.*;

/**
 * TestWIndowClosing
 */
public class TestWIndowClosing {
    public TestWIndowClosing() {
        new WindowClosingFrame().launch();
    }

}

class WindowClosingFrame extends Frame {
    void launch(){
        setBounds(100, 100, 458, 500);
        setVisible(true);

        /** */

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                setVisible(false);
                System.exit(0);
            }
        });
        
        // this.addWindowListener(new MyWindowMonitor());
    }

    // class MyWindowMonitor extends WindowAdapter{
    //     public void windowClosing(WindowEvent e){
    //         setVisible(false);
    //         System.exit(0);                    
    //     }
    // }

}