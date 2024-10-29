package utils;

import java.util.Scanner;

public final class Input {
    public static String get(String message) throws InputInterruptException {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message + ": ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new InputInterruptException("Entrada vazia");
        }
        return input;
    }
}
