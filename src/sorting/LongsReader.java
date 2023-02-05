package sorting;

import java.util.*;

public class LongsReader extends Reader{
    Scanner scanner = new Scanner(System.in);
    private int totalNumber;
    private final String sortingType;
    private final Collection<Long> numbers = new ArrayList<>();
    private final Map<Long, Integer> counter = new HashMap<>();

    public LongsReader(String sortingType) {
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
            int count = (int) numbers.stream().filter(x -> Objects.equals(x, number)).count();
            counter.put(number, count);
        }
    }

    @Override
    public void printData() {
        if ("natural".equals(sortingType)) {
            System.out.printf("Total numbers: %d.%n", totalNumber);
            System.out.print("Sorted data: ");
            numbers.stream().sorted().forEach(x-> System.out.print(x + " "));
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
