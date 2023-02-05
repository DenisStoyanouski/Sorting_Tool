package sorting;

public class Main {

    static String typeOfData;

    static String sortingType;




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
            if (args[i].matches("-.*") && !args[i].equals("-dataType") && !args[i].equals("-sortingType")) {
                System.out.printf("\"%s\" is not a valid parameter. It will be skipped.%n", args[i]);
            }
        }
        chooseReader();

    }

    private static void chooseReader() {
        switch(typeOfData) {
            case "long" : new LongsReader(sortingType).doTask();
            break;
            case "line" : new LinesReader(sortingType).doTask();
            break;
            case "word" : new WordsReader(sortingType).doTask();
            break;
            default:  break;
        }
    }

}
