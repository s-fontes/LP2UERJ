package P3n.lp2g47.biblioteca;

import P3n.lp2g47.biblioteca.livro.Livro;
import P3n.lp2g47.biblioteca.usuario.Usuario;
import P3n.lp2g47.biblioteca.utils.DataPersist;
import java.util.HashMap;

public class Biblioteca {
    private HashMap<Integer, Livro> livros;
    private HashMap<Integer, Usuario> usuarios;
    private final DataPersist<HashMap<Integer, Livro>> livrosPersist;
    private final DataPersist<HashMap<Integer, Usuario>> usuariosPersist;

    public Biblioteca() {
        String folderPath = "./database/";
        livrosPersist = new DataPersist<HashMap<Integer, Livro>>(folderPath);
        usuariosPersist = new DataPersist<HashMap<Integer, Usuario>>(folderPath);
        livros = new HashMap<Integer, Livro>();
        usuarios = new HashMap<Integer, Usuario>();
        try {
            livrosPersist.save(livros, "livros.dat");
            usuariosPersist.save(usuarios, "usuarios.dat");
        } catch (Exception e) {
            System.out.println("Erro ao salvar dados: " + e);
        }
    }

    public Biblioteca(String folderPath) {
        livrosPersist = new DataPersist<HashMap<Integer, Livro>>(folderPath);
        usuariosPersist = new DataPersist<HashMap<Integer, Usuario>>(folderPath);
        try {
            livros = livrosPersist.load("livros.dat");
            usuarios = usuariosPersist.load("usuarios.dat");
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados: " + e);
            livros = new HashMap<Integer, Livro>();
            usuarios = new HashMap<Integer, Usuario>();
            try {
                livrosPersist.save(livros, "livros.dat");
                usuariosPersist.save(usuarios, "usuarios.dat");
            } catch (Exception ex) {
                System.out.println("Erro ao salvar dados: " + ex);
            }
        }
    }

    private void saveData() {
        try {
            livrosPersist.save(livros, "livros.dat");
            usuariosPersist.save(usuarios, "usuarios.dat");
        } catch (Exception e) {
            System.out.println("Erro ao salvar dados: " + e);
        }
    }
}
