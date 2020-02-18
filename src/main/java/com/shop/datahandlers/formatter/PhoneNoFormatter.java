package com.shop.datahandlers.formatter;

@Component
public class PhoneNoFormatter {
    public static String format (String inputToFormat) {
        String numberOnly = inputToFormat.replaceAll("[^0-9+]", "");
        numberOnly = numberOnly.replaceAll("\\+40", "0040");
        if (!numberOnly.matches("0040.+")) {
            numberOnly = "0040" + numberOnly;
            System.out.println(numberOnly);
        } else {
            System.out.println(numberOnly);
        }
        return numberOnly;
    }

}
