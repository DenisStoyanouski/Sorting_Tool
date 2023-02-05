package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    static String typeOfData = "word";

    static String sortingType = "natural";


    public static void main(final String[] args) {
        ArrayList<String> arguments = Arrays.stream(args).collect(Collectors.toCollection(ArrayList::new));
        if (arguments.contains("-dataType")) {
            typeOfData = arguments.get(arguments.indexOf("-dataType") + 1);
        }
        if (arguments.contains("-sortingType")) {
            sortingType = arguments.get(arguments.indexOf("-sortingType") + 1);
        }
        chooseReader();

    }

    private static void chooseReader() {
        switch(typeOfData) {
            case "long" : new LongReader(sortingType).doTask();
            break;
            case "line" : new LinesReader(sortingType).doTask();
            break;
            case "word" : new WordReader(sortingType).doTask();
            break;
            default:  break;
        }
    }

}
