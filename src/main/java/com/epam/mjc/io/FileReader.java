package com.epam.mjc.io;

import java.io.*;

import java.util.ArrayList;
import java.util.List;


public class FileReader {


    public Profile getDataFromFile(File file)  {
        List<String> lines = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))){
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(": ");
                lines.add(split[1]);
                line = bufferedReader.readLine();
            }
            return new Profile(lines.get(0), Integer.valueOf(lines.get(1)), lines.get(2), Long.valueOf(lines.get(3)));
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return null;
    }
}

