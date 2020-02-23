package com.shop.ui.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {

    public static boolean validatePhone(String phone) {
        String patternString = "^0040\\d{9}$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();

    }
}