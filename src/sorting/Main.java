package sorting;

import java.net.CookieHandler;
import java.util.*;

public class Main {

    static Collection<Long> numbers = new ArrayList<>();

    static String typeOfData;


    public static void main(final String[] args) {

        typeOfData = args.length == 2 ? args[1] : "word";


        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            numbers.add(number);
        }
        int number = numbers.size();
        long maxValue = Collections.max(numbers);
        int count = (int) numbers.stream().filter(x -> x == maxValue).count();

        System.out.printf("Total numbers: %d%n", number);
        System.out.printf("The greatest number: %d (%d time(s)).", maxValue, count);
    }

    private static void chooseReader() {
        switch(typeOfData) {
            case "long" : readLongs();
            break;
            case "line" : readLines();
            break;
            case "word" : readWords();
            break;
            default:  break;
        }
    }

}
