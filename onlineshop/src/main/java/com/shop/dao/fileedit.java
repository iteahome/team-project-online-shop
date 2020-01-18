package com.shop.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class fileedit {
//    public String filename;
//    public String datas;
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
}
