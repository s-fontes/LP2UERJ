package lp2g47.biblioteca.io;

import lp2g47.biblioteca.io.excp.ExitApplication;
import lp2g47.biblioteca.io.excp.Return;

import java.util.Scanner;

public final class Input {
    public static String get(String message) throws ExitApplication, Return {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String input = scanner.nextLine();
        if (input.equals("exit")) {
            throw new ExitApplication("Saindo da aplicação");
        } else if (input.equals("return")) {
            throw new Return("Retornando ao menu anterior");
        } else if (input.isBlank()) {
            System.out.println("Entrada vazia");
            System.out.println("Para sair da aplicação digite 'exit'");
            System.out.println("Para retornar ao menu anterior digite 'return'");
            return get(message);
        }
        return input;
    }

    public static int getInt(String message) throws ExitApplication, Return {
        try {
            return Integer.parseInt(get(message));
        } catch (NumberFormatException e) {
            System.out.println("O valor informado não é um número");
            return getInt(message);
        }
    }

    public static String getOption(String message) throws ExitApplication, Return {
        String input = get(message);
        input = input.toLowerCase();
        if (input.equals("s") || input.equals("n")) {
            return input;
        } else {
            System.out.println("Opção inválida");
            System.out.println("Digite 's' para sim ou 'n' para não");
            return getOption(message);
        }
    }
}