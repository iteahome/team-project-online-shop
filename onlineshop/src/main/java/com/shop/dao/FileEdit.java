package com.shop.dao;

import com.shop.exception.ShopFileException;
import com.shop.exception.ShopTechnicalException;

import java.io.*;
import java.util.regex.*;

/** FileEdit class - allows manipulation of any file in the resources folder. */

class FileEdit {

    //  Method for adding a new line of content to text files:
    static void write(String fileName, String newContent) throws ShopTechnicalException {

        try {
//          Defining a String for the file path according to the given fileName:
            String resourceFile = "./src/main/resources/" + fileName;
//          Writing the given content to the given file:
            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(resourceFile, true));
            bufferedwriter.write(String.valueOf(newContent));
//          Creating a new line after writing:
            bufferedwriter.newLine();
//          Closing the stream:
            bufferedwriter.close();

//      If file doesn't exist:
        } catch (IOException e) {
            throw new ShopFileException("File not found", e);
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