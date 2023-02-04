package sorting;

import java.util.Scanner;

public abstract class Reader {

    public void doTask() {
        readData();
        processData();
        printData();
    }

    public abstract void readData();
    public abstract void processData();
    public abstract void printData();
}
