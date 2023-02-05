package sorting;

import java.util.Arrays;

public class Main {

    static String typeOfData;

    static boolean sort;


    public static void main(final String[] args) {
        if (Arrays.asList(args).contains("-sortIntegers")) {
            typeOfData = "long";
            sort = true;
        } else {
            typeOfData = args.length == 2 ? args[1] : "word";
            sort = false;
        }
        chooseReader();

    }

    private static void chooseReader() {
        switch(typeOfData) {
            case "long" : new LongReader(sort).doTask();
            break;
            case "line" : new LinesReader(sort).doTask();
            break;
            case "word" : new WordReader(sort).doTask();
            break;
            default:  break;
        }
    }

}
