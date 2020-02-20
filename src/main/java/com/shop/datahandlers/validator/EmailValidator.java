package com.shop.datahandlers.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValidator {
    private static final String EMAIL_REGEX = "(.+@.+(?:\\..+)+)";


    private static Pattern pattern;
    public Matcher matcher;

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }


    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}










