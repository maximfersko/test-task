package com.testTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static List<String> readInputFiles(String[] fileNames) {
        List<String> inputData = new ArrayList<>();

        for (String fileName : fileNames) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    inputData.add(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading input file: " + fileName);
            }
        }

        return inputData;
    }

    public static void writeOutputFile(String fileName, String[] data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String item : data) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing output file: " + fileName);
        }
    }
}
