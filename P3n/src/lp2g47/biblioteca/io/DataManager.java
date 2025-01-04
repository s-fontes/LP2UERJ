package lp2g47.biblioteca.io;

import lp2g47.biblioteca.io.excp.ExitApplication;
import lp2g47.biblioteca.io.excp.Return;
import lp2g47.biblioteca.livro.Livro;
import lp2g47.biblioteca.selector.Selector;
import lp2g47.biblioteca.usuario.Usuario;

import java.io.*;
import java.util.HashMap;

public final class DataManager {

    private static String DATABASE_PATH;

    public static void setDatabasePath(String DATABASE_PATH) {
        DataManager.DATABASE_PATH = DATABASE_PATH;
    }

    public static void saveLivros(HashMap<Integer, Livro> livros) throws Return {
        verifyProperties();
        System.out.println("Salvando livros...");
        String folderPath = DATABASE_PATH + "/" + PropertiesManager.getPropertiesName();
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String filePath = folderPath + "/l.dat";
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(livros);
        } catch (IOException e) {
            System.out.println("Erro ao salvar livros: " + e);
        }
    }

    public static void saveUsuarios(HashMap<Integer, Usuario> usuarios) throws Return {
        verifyProperties();
        System.out.println("Salvando usuários...");
        String folderPath = DATABASE_PATH + "/" + PropertiesManager.getPropertiesName();
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String filePath = folderPath + "/u.dat";
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(usuarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e);
        }
    }

    public static HashMap<Integer, Livro> loadLivros() throws Return {
        verifyProperties();
        System.out.println("Carregando livros...");
        String folderPath = DATABASE_PATH + "/" + PropertiesManager.getPropertiesName();
        String filePath = folderPath + "/l.dat";
        try (FileInputStream file = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(file)) {
            return (HashMap<Integer, Livro>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new Return("Erro ao carregar livros: " + e);
        }
    }

    public static HashMap<Integer, Usuario> loadUsuarios() throws Return {
        verifyProperties();
        String folderPath = DATABASE_PATH + "/" + PropertiesManager.getPropertiesName();
        String filePath = folderPath + "/u.dat";
        try (FileInputStream file = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(file)) {
            return (HashMap<Integer, Usuario>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new Return("Erro ao carregar usuários: " + e);
        }
    }

    public static void deleteData() throws Return {
        verifyProperties();
        System.out.println("Deletando dados...");
        File folder = new File(DATABASE_PATH + "/" + PropertiesManager.getPropertiesName());
        if (folder.exists()) {
            for (File file : folder.listFiles()) {
                file.delete();
            }
            folder.delete();
        }
        System.out.println("Dados deletados com sucesso");
    }

    public static void createData() throws Return {
        verifyProperties();
        System.out.println("Criando dados...");
        File folder = new File(DATABASE_PATH + "/" + PropertiesManager.getPropertiesName());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        HashMap<Integer, Livro> livros = new HashMap<>();
        HashMap<Integer, Usuario> usuarios = new HashMap<>();
        saveLivros(livros);
        saveUsuarios(usuarios);
        System.out.println("Dados criados com sucesso");
    }

    public static void verifyData() throws Return, ExitApplication {
        verifyProperties();
        File folder = new File(DATABASE_PATH + "/" + PropertiesManager.getPropertiesName());
        if (folder.exists()) {
            try {
                loadLivros();
                loadUsuarios();
            } catch (Return e) {
                System.out.println("Erro ao carregar dados: " + e.getMessage());
                Selector<Integer> selector = new Selector<>(
                        new Integer[]{1, 2},
                        new String[]{"Sim", "Não"},
                        "Talvez os dados estejam corrompidos. Deseja deletá-los e criar novos?",
                        "Digite o número da opção desejada: "
                );
                Integer option = selector.select();
                if (option.equals(1)) {
                    deleteData();
                    createData();
                }
            }
        } else {
            System.out.println("Pasta de dados não encontrada.");
            createData();
        }
    }

    private static void verifyProperties() throws Return {
        if (PropertiesManager.getPropertiesName() == null) {
            throw new Return("Propriedades não carregadas.");
        }
    }
}