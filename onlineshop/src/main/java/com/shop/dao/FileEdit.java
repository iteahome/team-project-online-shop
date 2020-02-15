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

/** Method for reading a file and returning a line of text matching a regex pattern: */
    static String findLine(String filename, String regex) {

//      Initializing the String we are looking for:
        String lineData = null;

        try {
//          Pointing to a file that needs to be read:
            File resourceFile = new File("./src/main/resources/" + filename);
//          Initializing a way to read the file:
            Scanner resourceScanner = new Scanner(resourceFile);
//          Reading the file line by line:
            while (resourceScanner.hasNextLine()) {
//              Checking every line for a match to the given regex pattern:
                if ((lineData = resourceScanner.nextLine()).matches(regex)) {
//                  When match is found, the line of data is returned:
                    return lineData;
                }
            }
//          Closing the input stream:
            resourceScanner.close();

//      If the file is not accessible:
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

//      End result of the method - the line of data matching the regex pattern:
        return  lineData;

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

/** Method for targeting a line of data from a text and replacing any part of its content: */
    static void replace(String filename, String identifier, String oldData, String newData) {

        try {
//          *** READING THE RESOURCE FILE: ***

//          Pointing to the file to be read:
            File resourceFile = new File("./src/main/resources/" + filename);
//          Initializing a way to read the file:
            Scanner resourceScanner = new Scanner(resourceFile);
//          Temporarily converting text content to a String:
            StringBuilder contentBuilder = new StringBuilder();
            while (resourceScanner.hasNextLine()) {
                contentBuilder.append(resourceScanner.nextLine() + System.lineSeparator());
            }
            String resourceFileContent = contentBuilder.toString();
            /** JUST CHECKING */ System.out.println("\nOld content:\n\n" + resourceFileContent);
//          The file scanner can be closed now:
            resourceScanner.close();

//          *** FINDING THE TARGET LINE OF TEXT: ***

            String targetLine = FileEdit.findLine(filename,identifier);
            /** JUST CHECKING */ System.out.println("\nTarget line:\n\n" + targetLine);

//          *** REPLACING THE OLD PIECE OF DATA WITH THE NEW DATA:

            if(targetLine.matches(oldData)) {
                System.out.println("Match found.");
                targetLine.replace(oldData, newData);
            }
            /** JUST CHECKING */ System.out.println("\nNew line:\n\n" + targetLine);

//          *** REPLACING THE TARGET TEXT IN THE TEMPORARY CONTENT STRING: ***

//            String newContentString = resourceFileContent.replaceAll(oldData, newData);
//            /** JUST CHECKING */ System.out.println("New file string content:\n" + newContentString);

//      If the resource file is not found:
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


////      Initializing the String to be manipulated:
//        String lineData = null;
//
//        try {
////          Pointing to the file to be read:
//            File resourceFile = new File("./src/main/resources/" + filename);
//
////          Initializing a way to read the file:
//            Scanner resourceScanner = new Scanner(resourceFile);
////          Reading the file line by line:
//            while (resourceScanner.hasNextLine()) {
////              Checking every line for a match to the given regex pattern:
//                if ((lineData = resourceScanner.nextLine()).matches(regex)) {
////                  Initializing a way to write to the file:
//                    FileWriter resourceWriter = new FileWriter(resourceFile);
////            fileWriter.replaceThatLineWithMyNewLinePleaseThankYou
//            // maybe use OutputStream.write(byte[] b, int off, int len)
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Cannot read from/write to file.");
//        }


    }
}