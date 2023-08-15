package com.testTask;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Usage: <sort_mode>(-a, -d) <data_type>(-s, -i) <output_file> <input_files...>");
            return;
        }

        String sortMode = args[0];
        if (!sortMode.equals("-a") && !sortMode.equals("-d")) {
            sortMode = "-a";
        }

        String dataType = args[1];
        String outFileName = args[2];
        String[] inFiles = Arrays.copyOfRange(args, 3, args.length);

        boolean ascending = sortMode.equals("-a");
        boolean isString = dataType.equals("-s");
        boolean isInt = dataType.equals("-i");

        if (!isString && !isInt) {
            System.out.println("Invalid data type. Use -s (string) or -i (integer).");
            return;
        }

        List<String> inputData = FileHandler.readInputFiles(inFiles);

        MergeSort<String> mergeSort = new MergeSort<>();
        String[] sortedData = inputData.toArray(new String[0]);

        if (isInt) {
            try {
                for (int i = 0; i < sortedData.length; i++) {
                    sortedData[i] = Integer.toString(Integer.parseInt(sortedData[i]));
                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing integer data.");
                return;
            }
        }

        mergeSort.sort(sortedData, ascending);

        FileHandler.writeOutputFile(outFileName, sortedData);
    }
}
