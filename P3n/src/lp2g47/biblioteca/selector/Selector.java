package lp2g47.biblioteca.selector;

import lp2g47.biblioteca.io.Input;
import lp2g47.biblioteca.io.excp.ExitApplication;
import lp2g47.biblioteca.io.excp.Return;

public class Selector<T> {
    private final T[] options;
    private final String title;
    private String message = "Selecione uma opção: ";
    private String[] descriptions;

    public Selector(T[] options, String title) {
        this(options, title, "Selecione uma opção: ");
        this.descriptions = new String[options.length];
        for (int i = 0; i < options.length; i++) {
            this.descriptions[i] = options[i].toString();
        }
    }

    public Selector(T[] options, String title, String message) {
        this(options, new String[options.length], title, message);
        for (int i = 0; i < options.length; i++) {
            this.descriptions[i] = options[i].toString();
        }
    }

    public Selector(T[] options, String[] descriptions, String title) {
        this(options, descriptions, title, "Selecione uma opção: ");
    }

    public Selector(T[] options, String[] descriptions, String title, String message) {
        if (options.length != descriptions.length) {
            throw new IllegalArgumentException("O número de descrições deve ser igual ao número de opções");
        }
        this.options = options;
        this.descriptions = descriptions;
        this.title = title;
        this.message = message;
    }

    public T select() throws ExitApplication, Return {
        printOptionsTable();
        return selectOption();
    }

    private void printOptionsTable() {
        String line = String.format("%0" + 40 + "d", 0).replace("0", "-");
        System.out.println(line);
        System.out.println(title);
        System.out.println(line);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + " - " + descriptions[i]);
        }
        System.out.println(line);
    }

    private T selectOption() throws ExitApplication, Return {
        try {
            int index = Input.getInt(message) - 1;
            return options[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("O valor informado não corresponde a uma opção");
            return selectOption();
        }
    }
}
