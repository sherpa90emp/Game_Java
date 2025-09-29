package controller;

import java.util.Scanner;

public class consoleInput implements inputPort {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
