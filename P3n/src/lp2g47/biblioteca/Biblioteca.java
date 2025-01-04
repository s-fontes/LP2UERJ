package lp2g47.biblioteca;

import lp2g47.biblioteca.io.DataManager;
import lp2g47.biblioteca.io.excp.ExitApplication;
import lp2g47.biblioteca.io.excp.Return;
import lp2g47.biblioteca.livro.Livro;
import lp2g47.biblioteca.selector.Selector;
import lp2g47.biblioteca.usuario.Usuario;

import java.util.HashMap;

public class Biblioteca {
    private static HashMap<Integer, Livro> livros;
    private static HashMap<Integer, Usuario> usuarios;

    public static void bibliotecaMenu() throws Return, ExitApplication {
        String[] options = {
                "Empréstimo",
                "Adicionar livro",
                "Remover livro",
                "Adicionar usuário",
                "Remover usuário",
                "Listar livros",
                "Historico de empréstimos livros",
                "Historico de empréstimos usuários",
                "Listar usuários",
                "Salvar dados",
                "Carregar dados",
                "Retornar"
        };
        Integer[] optionsNumbers = new Integer[options.length];
        for (int i = 0; i < options.length; i++) {
            optionsNumbers[i] = i + 1;
        }
        Selector<Integer> selector = new Selector<>(
                optionsNumbers,
                options,
                "Menu da biblioteca",
                "Digite o número da opção desejada: "
        );
        Integer option = selector.select();
        switch (option) {
            case 1:
                System.out.println("Empréstimo");
                bibliotecaMenu();
                break;
            case 2:
                System.out.println("Adicionar livro");
                bibliotecaMenu();
                break;
            case 3:
                System.out.println("Remover livro");
                bibliotecaMenu();
                break;
            case 4:
                System.out.println("Adicionar usuário");
                bibliotecaMenu();
                break;
            case 5:
                System.out.println("Remover usuário");
                bibliotecaMenu();
                break;
            case 6:
                System.out.println("Listar livros");
                bibliotecaMenu();
                break;
            case 7:
                System.out.println("Historico de empréstimos livros");
                bibliotecaMenu();
                break;
            case 8:
                System.out.println("Historico de empréstimos usuários");
                bibliotecaMenu();
                break;
            case 9:
                System.out.println("Listar usuários");
                bibliotecaMenu();
                break;
            case 10:
                saveData();
                bibliotecaMenu();
                break;
            case 11:
                loadData();
                bibliotecaMenu();
                break;
            case 12:
                throw new Return("Retornando ao menu principal");
        }
    }

    public static void saveData() throws Return {
        System.out.println("Salvando dados...");
        DataManager.saveLivros(livros);
        DataManager.saveUsuarios(usuarios);
        System.out.println("Dados salvos com sucesso");
    }

    public static void loadData() throws Return {
        System.out.println("Carregando dados...");
        livros = DataManager.loadLivros();
        usuarios = DataManager.loadUsuarios();
        System.out.println("Dados carregados com sucesso");
    }
}
