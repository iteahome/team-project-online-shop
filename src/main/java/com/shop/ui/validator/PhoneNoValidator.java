package com.shop.ui.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNoValidator {

    public String formatPhoneNo(String phoneNo) {
        String formattedPhoneNo = phoneNo.replaceAll("[^0-9+]", "");
        System.out.println("Formatted phone number is now: " + formattedPhoneNo);
        formattedPhoneNo = formattedPhoneNo.replaceAll("\\+40", "0040");
        System.out.println("Formatted phone number is now: " + formattedPhoneNo);
        if (!formattedPhoneNo.matches("0040.+")) {
            formattedPhoneNo = "004" + formattedPhoneNo;
            System.out.println("Formatted phone number is now: " + formattedPhoneNo);
        }
        return formattedPhoneNo;
    }

    public boolean isPhoneNoValid(String phoneNo) {
        String formattedPhoneNo = formatPhoneNo(phoneNo);
        String patternString = "^0040\\d{9}$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(formattedPhoneNo);
        System.out.println("Does formatted phone number match: " + matcher.matches());
        return matcher.matches();
    }
}