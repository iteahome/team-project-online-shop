package com.shop.ui.handlers;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class InputPopUps extends JFrame {

    public static final String CANCELLED = "Cancelled";

    public static String input(String message) {
        JTextArea textArea = new JTextArea(message);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension( 800 , 500));
        Optional<String> result = Optional.ofNullable(JOptionPane.showInputDialog(null, scrollPane, null));
        return result.map(InputPopUps::emptyDefaultValue).orElse(CANCELLED);
    }

    private static String emptyDefaultValue(String s) {
        if (s.isEmpty()) {
            return ".";
        }

        return s;
    }
}