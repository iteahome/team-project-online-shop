package com.shop.ui.handlers;

import javax.swing.*;
import java.util.Optional;

public class InputPopUps extends JFrame {

    public static final String CANCELLED = "Cancelled";

    public static String input(String message) {
        Optional<String> result = Optional.ofNullable(JOptionPane.showInputDialog(message));
        return result.map(InputPopUps::emptyDefaultValue).orElse(CANCELLED);
    }

    private static String emptyDefaultValue(String s) {
        if (s.isEmpty()) {
            return ".";
        }

        return s;
    }
}