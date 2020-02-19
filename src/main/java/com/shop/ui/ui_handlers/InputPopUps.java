package com.shop.ui.ui_handlers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InputPopUps {

    public static String input (String message) {
        JFrame frame = new JFrame();
        return JOptionPane.showInputDialog(frame, message);
    }
}