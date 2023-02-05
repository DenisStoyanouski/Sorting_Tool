package sorting;

import java.util.*;

public class WordsReader extends Reader{

    Scanner scanner = new Scanner(System.in);
    private int totalWords;

    private final String sortingType;
    static Collection<String> words = new ArrayList<>();

    private final Map<String, Integer> counter = new HashMap<>();

    public WordsReader(String sortingType) {
        this.sortingType = sortingType;
    }


    @Override
    public void readData() {
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
    public void printData() {
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
}
