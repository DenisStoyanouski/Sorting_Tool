package sorting;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class WordsReader extends Reader{

    Scanner scanner = new Scanner(System.in);
    private int totalWords;
    static Collection<String> words = new ArrayList<>();

    private final Map<String, Integer> counter = new HashMap<>();

    public WordsReader(String sortingType, String inputFile, String outputFile) {
        this.sortingType = sortingType;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public void readDataFromFile(String inputFile) {
        File file = new File(String.format(".\\%s", inputFile));
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    @Override
    public void readDataFromConsole() {
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (!word.isBlank()) {
                words.add(word.trim());
            }
        }
    }

    @Override
    public void processData() {
        totalWords = words.size();
        for (String line : words) {
            int count = (int) words.stream().filter(x -> x.equals(line)).count();
            counter.put(line, count);
        }
    }

    @Override
    public void printDataToConsole() {
        if ("natural".equals(sortingType)) {
            System.out.printf("Total words: %d%n", totalWords);
            System.out.print("Sorted data: ");
            words.stream().sorted().forEach(x-> System.out.print(x + " "));
        }
        if ("byCount".equals(sortingType)) {
            System.out.printf("Total numbers: %d%n", totalWords);
            counter.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Comparator.comparingInt(Map.Entry::getValue))
                    .forEach(x -> System.out.printf("%s: %d time(s), %d%% %n", x.getKey(), x.getValue(), x.getValue() * 100 / totalWords));
        }
    }

    @Override
    public void printDataToFile(String outputFile) {
        File file = new File(String.format(".\\%s", outputFile));
        try (var writer = new PrintWriter(file)) {
            if ("natural".equals(sortingType)) {
                writer.printf("Total words: %d%n", totalWords);
                writer.print("Sorted data: ");
                words.stream().sorted().forEach(x-> writer.printf("%s ", x));
            }
            if ("byCount".equals(sortingType)) {
                writer.printf("Total numbers: %d%n", totalWords);
                counter.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .sorted(Comparator.comparingInt(Map.Entry::getValue))
                        .forEach(x -> writer.printf("%s: %d time(s), %d%% %n", x.getKey(), x.getValue(), x.getValue() * 100 / totalWords));
            }
        } catch (IOException e) {
            System.out.println("something wrong");
        }
    }
}
