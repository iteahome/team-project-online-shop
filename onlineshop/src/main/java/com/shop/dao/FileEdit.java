package com.shop.dao;

import com.shop.exception.ShopFileException;
import com.shop.exception.ShopTechnicalException;

import java.io.*;
import java.util.regex.*;

/** FileEdit class - allows manipulation of any file in the resources folder. */

class FileEdit {

//  Method for adding a new line of content to text files:
    static void write(String fileName, String newContent) throws ShopTechnicalException {

//      Defining a String for the file path according to the given fileName:
        String resourceFile = "./src/main/resources/" + fileName;

        try {
//          Writing the given content to the given file:
            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(resourceFile, true));
            bufferedwriter.write(String.valueOf(newContent));
//          Creating a new line after writing:
            bufferedwriter.newLine();
//          Closing the output stream:
            bufferedwriter.close();

//      If file doesn't exist:
        } catch (IOException e) {
            throw new ShopFileException("File not found", e);
        }
    }

//  Method for reading lines of text from a file, with the possibility of filtering (searching) via regex:
    static String read(String filename, String regex) throws ShopTechnicalException {

//      Defining a String for the resource file path according to the given fileName:
        String resourceFile = "./src/main/resources/"+filename;
//      Initializing a String where the data will be stored:
        String lineData = null;

        try {
//          Reading content from the given file:
            BufferedReader bufferedReader = new BufferedReader(new FileReader(resourceFile));
//          Defining regex pattern from the corresponding method parameter (can be empty):
            Pattern pattern = Pattern.compile(regex);

//          Defining regex matcher (text to be searched) as the current line being read:
            while ((lineData = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(lineData);
//              If match is found, line is returned:
                if (matcher.find()) {
                    return lineData;
                }
            }
//          Closing the input stream:
            bufferedReader.close();

//      If the file can't be read:
        } catch (IOException e) {
            throw new ShopFileException("Error reading file", e);
        }
//      The method's end result - a line of data:
        return lineData;

    }
}