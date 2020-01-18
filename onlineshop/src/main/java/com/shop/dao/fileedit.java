package com.shop.dao;

import java.io.*;
import java.nio.CharBuffer;

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
    static void find(String filename, String id) {
        try {
            FileReader reader = new FileReader (filename);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while ((line = bufferedReader.readLine()) !=null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
