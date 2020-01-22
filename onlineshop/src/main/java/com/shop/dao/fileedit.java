package com.shop.dao;

import java.io.*;
import java.util.regex.*;

import static java.util.regex.Pattern.compile;

class fileedit {
    static void write(String filename, String continut) {
        try {
            FileWriter writer = new FileWriter(String.valueOf(filename), true);
            BufferedWriter bufferedwriter = new BufferedWriter(writer);
            bufferedwriter.write(String.valueOf(continut));
            bufferedwriter.newLine();
            bufferedwriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void read(String filename, String regex) {
        String line = null;
        String file = "./src/main/resources/"+filename;
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(regex);
            while ((line = bufferedReader.readLine()) != null) {
                matcher.reset(line);
                if (matcher.find()) {
                    System.out.println(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
