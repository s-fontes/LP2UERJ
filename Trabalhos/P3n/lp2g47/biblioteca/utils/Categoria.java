package P3n.lp2g47.biblioteca.utils;

public enum Categoria {
    AVENTURA("Aventura"),
    FICCAO("Ficção"),
    TERROR("Terror"),
    ACADEMICO("Acadêmico"),
    ROMANCE("Romance"),
    BIOGRAFIA("Biografia"),
    INFANTIL("Infantil"),
    OUTRO("Outro");

    private final String nome;

    Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}