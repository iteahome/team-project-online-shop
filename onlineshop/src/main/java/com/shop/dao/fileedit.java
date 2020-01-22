package com.shop.dao;

import com.shop.exception.ShopFileException;
import com.shop.exception.ShopTechnicalException;

import java.io.*;
import java.util.regex.*;

class FileEdit {
    static void write(String filename, String continut) throws ShopTechnicalException {
        try {

            String file = "./src/main/resources/"+filename;
            FileWriter writer = new FileWriter(String.valueOf(file), true);
            BufferedWriter bufferedwriter = new BufferedWriter(writer);
            bufferedwriter.write(String.valueOf(continut));
            bufferedwriter.newLine();
            bufferedwriter.close();

        } catch (IOException e) {
            throw new ShopFileException("file not found", e);
        }
    }

    static String read(String filename, String regex) throws ShopTechnicalException {
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
                    return line;
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new ShopFileException("Error reading file", e);
        }
        return line;
    }
}
