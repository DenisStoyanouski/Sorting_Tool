package sorting;

public class Main {

    static String typeOfData;


    public static void main(final String[] args) {

        typeOfData = args.length == 2 ? args[1] : "word";
        chooseReader();
    }

    private static void chooseReader() {
        switch(typeOfData) {
            case "long" : new LongReader().doTask();
            break;
            case "line" : new LinesReader().doTask();
            break;
            case "word" : new WordReader().doTask();
            break;
            default:  break;
        }
    }

}
