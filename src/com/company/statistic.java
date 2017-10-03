package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class statistic {
    public static String[] getFileList(String type) {
        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".txt")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        String files[] = new File("." ).list(textFilter);
        return files;
    }
    public static Map<String, Integer> countWords(String file) {
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        )
        {
            String s = bufferedReader.lines().collect(Collectors.joining(" "));
            String[] strBuf = s.split("[:;()'\",.!?\\s]+");
            for(int i = 0; i < strBuf.length; ++i) {
                strBuf[i] = strBuf[i].toLowerCase();
            }
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < strBuf.length; ++i)
            {
                if(map.containsKey(strBuf[i]))
                {
                    map.put(strBuf[i], map.get(strBuf[i]) + 1);
                }
                else
                {
                    map.put(strBuf[i], 1);
                }
            }
            //System.out.print(map);
            return map;
        }
        catch (IOException e)
        {
            System.out.println(e);
            return null;
        }
    }
}
