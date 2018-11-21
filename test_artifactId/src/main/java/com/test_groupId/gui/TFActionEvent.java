package com.test_groupId.gui;

import java.awt.*;
import java.awt.event.*;

/**
 * TFActionEvent
 */
public class TFActionEvent {

    public TFActionEvent(){
        new TFFrame();
    }
}

class TFFrame extends Frame{
    TFFrame(){
        TextField tf = new TextField();
        tf.addActionListener(new TFActionListener());
        //tf.setEchoChar('*');
        add(tf);
        pack();
        setVisible(true);

    }
}

class TFActionListener implements ActionListener {
    public void actionPerformed(ActionEvent a){
        TextField tf = (TextField)a.getSource();
        System.out.println(tf.getText());

        System.out.println(a.getActionCommand()); 
        System.out.println(a.paramString()); 
        System.out.println(a.toString()); 
        tf.setText("");
    }
}