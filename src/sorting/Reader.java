package sorting;

import java.io.IOException;

public abstract class Reader {
    String sortingType;
    String inputFile;
    String outputFile;

    Reader() {};


    public void doTask() throws IOException {
        if (this.inputFile == null) {
            readDataFromConsole();
        } else {
            readDataFromFile(inputFile);
        }
        processData();
        if (this.outputFile == null) {
            printDataToConsole();
        } else {
            printDataToFile(outputFile);
        }
    }

    public abstract void readDataFromFile(String inputFile);
    public abstract void readDataFromConsole();
    public abstract void processData();
    public abstract void printDataToConsole();
    public abstract void printDataToFile(String outputFile);
}
