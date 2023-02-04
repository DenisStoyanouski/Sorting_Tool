package sorting;

import java.util.*;

public class WordReader extends Reader{

    Scanner scanner = new Scanner(System.in);
    private int number;
    private Optional<String> maxValue;
    private int count;
    static Collection<String> words = new ArrayList<>();
    @Override
    public void readData() {
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (!word.isBlank())
            words.add(word.trim());
        }
    }

    @Override
    public void processData() {
        number = words.size();
        maxValue = words.stream().max(Comparator.comparing(String::length));
        count = (int) words.stream().filter(x -> x.equals(maxValue.get())).count();
    }

    @Override
    public void printData() {
        System.out.printf("Total words: %d%n", number);
        System.out.printf("Total longest word: %s (%d time(s), %d%%).%n", maxValue.get(), count, count * 100 / number);
    }
}
