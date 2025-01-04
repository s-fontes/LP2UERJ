import lp2g47.biblioteca.Biblioteca;
import lp2g47.biblioteca.io.DataManager;
import lp2g47.biblioteca.io.PropertiesManager;
import lp2g47.biblioteca.io.excp.ExitApplication;
import lp2g47.biblioteca.io.excp.Return;
import lp2g47.biblioteca.selector.Selector;

import java.io.IOException;
import java.lang.reflect.Type;

public class P3nX {
    private static final String PROPERTIES_PATH = "src/properties";
    private static final String[] PROPERTIES_KEYS = {
            "maxLivros",
            "maxDias"
    };
    private static final Type[] PROPERTIES_TYPES = {
            Integer.class,
            Integer.class
    };
    private static final String DATABASE_PATH = "src/database";

    public static void main(String[] args) {
        PropertiesManager.setProperties(PROPERTIES_PATH, PROPERTIES_KEYS, PROPERTIES_TYPES);
        DataManager.setDatabasePath(DATABASE_PATH);
        MainMenu();
    }

    private static void MainMenu() {
        try {
            String[] options = {
                    "Gerenciar biblioteca",
                    "Gerenciar propriedades",
                    "Sair"
            };
            Integer[] optionsNumbers = new Integer[options.length];
            for (int i = 0; i < options.length; i++) {
                optionsNumbers[i] = i + 1;
            }
            Selector<Integer> selector = new Selector<>(
                    optionsNumbers,
                    options,
                    "Menu de principal\n" +
                            (PropertiesManager.getPropertiesName() != null ? "(" + PropertiesManager.getPropertiesName() + ")" : "(Nenhuma propriedade selecionada, selecione uma para continuar)"),
                    "Digite o número da opção desejada: "
            );
            Integer option = selector.select();
            switch (option) {
                case 1:
                    try {
                        Biblioteca.loadData();
                        Biblioteca.bibliotecaMenu();
                    } catch (Return e) {
                        System.out.println(e.getMessage());
                        MainMenu();
                    }
                    break;
                case 2:
                    try {
                        PropertiesManager.propertiesMenu();
                    } catch (Return e) {
                        System.out.println(e.getMessage());
                        MainMenu();
                    }
                    break;
                case 3:
                    throw new ExitApplication("Saindo da aplicação");
            }
        } catch (Return e) {
            System.out.println(e.getMessage());
            MainMenu();
        } catch (ExitApplication e) {
            exitRoutine();
        }
    }

    private static void exitRoutine() {
        try {
            PropertiesManager.saveProperties();
        } catch (IOException e) {
            System.out.println("Erro ao salvar as propriedades: " + e.getMessage());
        }
        try {
            Biblioteca.saveData();
        } catch (Exception e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }
}
