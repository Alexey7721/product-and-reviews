package com.shatrov.demo;

import java.util.Scanner;

public class ConsoleInputOutput implements InputOutput{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void display(String text) {
        System.out.print(text);
    }
}
