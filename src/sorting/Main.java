package sorting;

import java.util.List;

public class Main {

    static String typeOfData = "word";

    static String sortingType = "natural";

    static String inputFile;

    static String outputFile;

    static List<String> options = List.of("-dataType", "-sortingType", "-inputFile", "-outputFile");

    public static void main(final String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                if (args[i].matches("-dataType") && !args[i + 1].matches("-.*")) {
                    typeOfData = args[i + 1];
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("No data type defined!");
            }
            try {
                if (args[i].matches("-sortingType") && !args[i + 1].matches("-.*")) {
                    sortingType = args[i + 1];
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("No sorting type defined!");
            }
            try {
                if (args[i].matches("-inputFile") && !args[i + 1].matches("-.*")) {
                    inputFile = args[i + 1];
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("No sorting type defined!");
            }
            try {
                if (args[i].matches("-outputFile") && !args[i + 1].matches("-.*")) {
                    outputFile = args[i + 1];
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("No sorting type defined!");
            }
            if (args[i].matches("-.*") && !options.contains(args[i])) {
                System.out.printf("\"%s\" is not a valid parameter. It will be skipped.%n", args[i]);
            }
        }
        chooseReader();
    }

    private static void chooseReader() {
        switch(typeOfData) {
            case "long" : new LongsReader(sortingType, inputFile, outputFile).doTask();
            break;
            case "line" : new LinesReader(sortingType, inputFile, outputFile).doTask();
            break;
            case "word" : new WordsReader(sortingType, inputFile, outputFile).doTask();
            break;
            default :  break;
        }
    }

}
