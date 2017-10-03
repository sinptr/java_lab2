package com.company;

import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            String files[] = statistic.getFileList("txt");
            for (String file: files) {
                Map<String, Integer> map = statistic.countWords(file);
                System.out.println(map);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
