package com.company;

import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (
            FileReader fileReader = new FileReader("in.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader)
        )
        {

            String s = bufferedReader.readLine();
            String[] strBuf = s.split(" ");
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
            System.out.print(map);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
