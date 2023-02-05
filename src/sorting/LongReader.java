package sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LongReader extends Reader{
    Scanner scanner = new Scanner(System.in);
    private int number;
    private long maxValue;
    private int count;
    private boolean sort;
    static Collection<Long> numbers = new ArrayList<>();

    public LongReader(boolean sort) {
        this.sort = sort;
    }


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
        if (!sort) {
            System.out.printf("Total numbers: %d%n", number);
            System.out.printf("The greatest number: %d (%d time(s) %d%%).%n", maxValue, count, count * 100 / number);
        } else {
            System.out.printf("Total numbers: %d%n", number);
            System.out.printf("Sorted data: %s%n", numbers.stream().sorted().collect(Collectors.toList())
                    .toString().replaceAll("[,\\[\\]]",""));
        }
    }
}
