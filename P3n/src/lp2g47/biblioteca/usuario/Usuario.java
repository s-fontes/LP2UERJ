package lp2g47.biblioteca.usuario;

import lp2g47.biblioteca.emprestimo.Emprestimo;

import java.util.ArrayList;

public class Usuario extends Pessoa {
    private String endereco;
    private final ArrayList<Emprestimo> hist = new ArrayList<Emprestimo>();
    private final Integer emprestimosAtivos = 0;

    protected Usuario(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, String endereco) {
        super(nome, sobreNome, dia, mes, ano, numCPF);
        this.setEndereco(endereco);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
