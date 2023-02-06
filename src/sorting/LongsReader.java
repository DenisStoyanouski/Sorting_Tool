package sorting;

import java.io.*;
import java.util.*;

public class LongsReader extends Reader{
    Scanner scanner = new Scanner(System.in);
    private int totalNumber;
    private final Collection<Long> numbers = new ArrayList<>();
    private final Map<Long, Integer> counter = new HashMap<>();

    public LongsReader(String sortingType, String inputFile, String outputFile) {
        this.sortingType = sortingType;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public void readDataFromConsole() {
        String number;
        while (scanner.hasNext()) {
            number = scanner.next();
            if (number.matches("[-+]*?\\d+")) {
                numbers.add(Long.valueOf(number));
            } else {
                System.out.printf("\"%s\" is not a long. It will be skipped.%n", number);
            }
        }
    }

    @Override
    public void readDataFromFile(String inputFile) {
        File file = new File(String.format(".\\%s", inputFile));
        try (Scanner scanner = new Scanner(file)) {
            String number;
            while (scanner.hasNext()) {
                number = scanner.next();
                if (number.matches("[-+]*?\\d+")) {
                    numbers.add(Long.valueOf(number));
                } else {
                    System.out.printf("\"%s\" is not a long. It will be skipped.%n", number);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
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
    public void printDataToConsole() {
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

    @Override
    public void printDataToFile(String outputFile) {
        File file = new File(String.format(".\\%s", outputFile));
        try (var writer = new PrintWriter(file)) {
            if ("natural".equals(sortingType)) {
                writer.printf("Total numbers: %d.%n", totalNumber);
                writer.printf("Sorted data: ");
                numbers.stream().sorted().forEach(x-> {
                    writer.printf("%d ", x);
                });
            }
            if ("byCount".equals(sortingType)) {
                writer.printf("Total numbers: %d%n", totalNumber);
                counter.entrySet()
                        .stream()
                        .sorted(Comparator.comparingLong(Map.Entry::getKey))
                        .sorted(Comparator.comparingInt(Map.Entry::getValue))
                        .forEach(x -> {
                            writer.printf("%d: %d time(s), %d%% %n", x.getKey(), x.getValue(), x.getValue() * 100 / totalNumber);
                        });
            }
        } catch (IOException e) {
            System.out.println("something wrong");
        }
    }
}
