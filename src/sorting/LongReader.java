package sorting;

import java.util.*;
import java.util.stream.Collectors;

public class LongReader extends Reader{
    Scanner scanner = new Scanner(System.in);
    private int totalNumber;
    private int count;
    private String sortingType;
    private Collection<Long> numbers = new ArrayList<>();
    private Map<Long, Integer> counter = new HashMap<>();

    public LongReader(String sortingType) {
        this.sortingType = sortingType;
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
        totalNumber = numbers.size();
        for (Long number : numbers) {
            count = (int) numbers.stream().filter(x -> x == number).count();
            counter.put(number, count);
        }
    }

    @Override
    public void printData() {
        if ("natural".equals(sortingType)) {
            System.out.printf("Total numbers: %d%n", totalNumber);
            System.out.printf("Sorted data: %s%n", numbers.stream().sorted().collect(Collectors.toList())
                    .toString().replaceAll("[,\\[\\]]",""));;
        }
        if ("byCount".equals(sortingType)) {
            System.out.printf("Total numbers: %d%n", totalNumber);
            counter.entrySet()
                    .stream()
                    .sorted(Comparator.comparingLong(Map.Entry::getKey))
                    .sorted(Comparator.comparingInt(Map.Entry::getValue))
                    .forEach(x -> System.out.printf("%d: %d time(s), %d%% %n", x.getKey(), x.getValue(), x.getValue() * 100 / totalNumber));

        }
    }
}
