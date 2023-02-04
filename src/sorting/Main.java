package sorting;

import java.net.CookieHandler;
import java.util.*;

public class Main {

    static List<Long> numbers = new ArrayList<>();
    public static void main(final String[] args) {
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
}
