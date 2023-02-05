package sorting;

import java.util.*;

public class LinesReader extends Reader{

    Scanner scanner = new Scanner(System.in);
    private int number;
    private Optional<String> maxValue;
    private int count;

    boolean sort;


    static Collection<String> lines = new ArrayList<>();

    public LinesReader(boolean sort) {
        this.sort = sort;
    }


    @Override
    public void readData() {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }
    }

    @Override
    public void processData() {
        number = lines.size();
        maxValue = lines.stream().max(Comparator.comparing(String::length));
        count = (int) lines.stream().filter(x -> x.equals(maxValue.get())).count();
    }

    @Override
    public void printData() {
        System.out.printf("Total lines: %d%n", number);
        System.out.printf("Total longest line: %n%s%n", maxValue.get());
        System.out.printf("(%d time(s), %d%%).%n", count, count * 100 / number);


    }
}
