package com.shop.dao;

import com.shop.exception.ShopFileException;
import com.shop.exception.ShopTechnicalException;

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

/** FileEdit class - allows manipulation of any file in the resources folder. */

class FileEdit {

/** Method for adding a new line of content to text files: */
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

/** Method for returning a specific line of text (found via regex) from a file: */
    static String read(String filename, String regex) throws ShopTechnicalException {

//      EXPERIMENT:
            File resourceFile = new File("./src/main/resources/" + filename);
            String lineData = null;
            Pattern regexPattern = Pattern.compile(regex);
            boolean matchFound = false;

        try {
            System.out.println("Regex: " + regex);
            Scanner resourceFileScanner = new Scanner(resourceFile);
            while ((lineData = resourceFileScanner.nextLine()) != null & !matchFound) {
                System.out.println("lineData: " + lineData);
                String subRegex = "(.*)" + "a@a" + "(.*)";
                System.out.println("subRegex: " + subRegex);
                if (Pattern.matches(subRegex, lineData)) {
                    System.out.println("Match found");
                    System.out.println("lineData: " + lineData);
                    matchFound = true;
                }
                System.out.println("Boolean matchFound: " + matchFound);




//                KEEP THIS INSIDE WHILE:
//                Matcher regexMatcher = regexPattern.matcher(lineData);
//                if (regexMatcher.find()) {
//                    System.out.println(lineData);
//                    matchFound = true;
//                } else {lineData = resourceFileScanner.nextLine();}

            }
            resourceFileScanner.close();
        } catch (FileNotFoundException e) {}

        return lineData;

////      Defining a String for the resource file path according to the given fileName:
//        String resourceFile = "./src/main/resources/"+filename;
////      Initializing a String where the data will be stored:
//        String lineData = null;
//
//        try {
////          Reading content from the given file:
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(resourceFile));
////          Defining regex pattern from the corresponding method parameter (can be empty):
//            Pattern pattern = Pattern.compile(regex);
//
////          Defining regex matcher (text to be searched) as the current line being read:
//            while ((lineData = bufferedReader.readLine()) != null) {
//                Matcher matcher = pattern.matcher(lineData);
////              If match is found, line is returned:
//                if (matcher.find()) {
//                    return lineData;
//                }
//            }
////          Closing the input stream:
//            bufferedReader.close();
//
////      If the file can't be read:
//        } catch (IOException e) {
//            throw new ShopFileException("Error reading file", e);
//        }
////      The method's end result - a line of data:
//        return lineData;

    }

///** Method for replacing a specific line of text (found via regex) in a file with a line of new content: */
//    static void replace(String filename, String identifier, String newData) throws ShopTechnicalException {
//
//        /** GET DATA */
//
////      Defining a String for the resource file path according to the given fileName:
//        String resourceFile = "./src/main/resources/"+filename;
//        String lineData = null;
//        try {
//            Scanner resourceFileScanner = new Scanner(resourceFile);
//            Pattern identifierPattern = Pattern.compile(identifier);
//            Matcher identifierMatcher = identifierPattern.matcher(lineData);
//            while (resourceFileScanner.hasNextLine()) {
//                if (identifierMatcher.find()) {
//                    lineData = identifierMatcher.toString();
//                }
//            }
//            resourceFileScanner.close();
//        } catch (IOException e) {
//            throw new ShopFileException("Error reading file", e);
//        }
//
//        /** REPLACE DATA */
//        /** OVERWRITE DATA */
//
//
////      Initializing a String where the data will be stored:
//        String lineData = null;
//
////      Finding the line of text corresponding to the identifier:
//        try {
////          Reading content from the given file, in order to identify the line that needs to be changed:
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(resourceFile));
////          Defining regex pattern from the corresponding method identifier parameter (should not be empty):
//            Pattern pattern = Pattern.compile(identifier);
//
////          Defining identifier matcher (text to be searched) as the current line being read:
//            while ((lineData = bufferedReader.readLine()) != null) {
//                Matcher matcher = pattern.matcher(lineData);
////              If match is found, line is returned:
////                if (matcher.find()) {
////                    return lineData;
////                }
//                lineData = bufferedReader.readLine();
//            }
////          Closing the input stream:
//            bufferedReader.close();
//
////      If the file can't be read:
//        } catch (IOException e) {
//            throw new ShopFileException("Error reading file", e);
//        }
////      The method's end result - a line of data:
////        return lineData;
//
//        String fileContent = null;
//        StringBuilder fileContentBuilder = new StringBuilder();
//
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(resourceFile));
//            while ((fileContent = bufferedReader.readLine()) != null) {
//                fileContentBuilder.append(bufferedReader.readLine());
//            }
//            bufferedReader.close();
//        } catch (IOException e) {
//            throw new ShopFileException("Error reading file", e);
//        }
//
//        fileContent = fileContentBuilder.toString();
//        fileContent.replaceAll(lineData, newData);
//
//        return fileContent;
//
//    }

}