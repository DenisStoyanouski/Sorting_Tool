package sorting;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class LinesReader extends Reader{

    Scanner scanner = new Scanner(System.in);
    private int totalLines;

    static Collection<String> lines = new ArrayList<>();

    private final Map<String, Integer> counter = new HashMap<>();

    public LinesReader(String sortingType, String inputFile, String outputFile) {
        this.sortingType = sortingType;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }


    @Override
    public void readDataFromFile(String inputFile) {
        File file = new File(String.format(".\\%s", inputFile));
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    @Override
    public void readDataFromConsole() {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }
    }

    @Override
    public void processData() {
        totalLines = lines.size();
        for (String line : lines) {
            int count = (int) lines.stream().filter(x -> x.equals(line)).count();
            counter.put(line, count);
        }
    }

    @Override
    public void printDataToConsole() {
        if ("natural".equals(sortingType)) {
            System.out.printf("Total numbers: %d%n", totalLines);
            System.out.println("Sorted data: ");
            lines.stream().sorted().forEach(x-> System.out.println(x + " "));
        }
        if ("byCount".equals(sortingType)) {
            System.out.printf("Total numbers: %d%n", totalLines);
            counter.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Comparator.comparingInt(Map.Entry::getValue))
                    .forEach(x -> System.out.printf("%s: %d time(s), %d%% %n", x.getKey(), x.getValue(), x.getValue() * 100 / totalLines));
        }
    }

    @Override
    public void printDataToFile(String outputFile) {
        File file = new File(String.format(".\\%s", outputFile));
        try (var writer = new PrintWriter(file)) {
            if ("natural".equals(sortingType)) {
                writer.printf("Total words: %d%n", totalLines);
                writer.print("Sorted data: ");
                lines.stream().sorted().forEach(x-> writer.printf("%s ", x));
            }
            if ("byCount".equals(sortingType)) {
                writer.printf("Total numbers: %d%n", totalLines);
                counter.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .sorted(Comparator.comparingInt(Map.Entry::getValue))
                        .forEach(x -> writer.printf("%s: %d time(s), %d%% %n", x.getKey(), x.getValue(), x.getValue() * 100 / totalLines));
            }
        } catch (IOException e) {
            System.out.println("something wrong");
        }
    }
}
