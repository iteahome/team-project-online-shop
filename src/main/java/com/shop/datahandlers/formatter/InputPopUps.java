package com.shop.datahandlers.formatter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InputPopUps {

    public static String main(String message) {
        JFrame frame = new JFrame();
        String result = JOptionPane.showInputDialog(frame, message);
        return result;
    }
}