package sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class LongReader extends Reader{
    Scanner scanner = new Scanner(System.in);
    private int number;
    private long maxValue;
    private int count;

    static Collection<Long> numbers = new ArrayList<>();

    @Override
    public void readData() {
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            numbers.add(number);
        }
    }

    @Override
    public void processData() {
        number = numbers.size();
        maxValue = Collections.max(numbers);
        count = (int) numbers.stream().filter(x -> x == maxValue).count();

    }

    @Override
    public void printData() {
        System.out.printf("Total numbers: %d%n", number);
        System.out.printf("The greatest number: %d (%d time(s)).", maxValue, count);
    }
}
