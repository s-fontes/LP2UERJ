package lp2g47.biblioteca.livro;

import lp2g47.biblioteca.emprestimo.EmprestaPara;
import lp2g47.biblioteca.livro.excp.NenhumaCopiaDisponivelEx;
import lp2g47.biblioteca.livro.excp.NenhumaCopiaEmprestadaEx;
import lp2g47.biblioteca.utils.Categoria;

import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Livro {
    private final int codLivro;
    private final String titulo;
    private final Categoria categoria;
    private int copias;
    private int emprestados;
    private ArrayList<EmprestaPara> hist = new ArrayList<EmprestaPara>();

    public Livro(int codLivro, String titulo, Categoria categoria, int copias, int emprestados) {
        this.codLivro = codLivro;
        this.titulo = titulo;
        this.categoria = categoria;
        this.copias = copias;
        this.emprestados = emprestados;
    }

    public void empesta() throws NenhumaCopiaDisponivelEx {
        if (copias > emprestados){
            emprestados++;
        } else {
            throw new NenhumaCopiaDisponivelEx("Livro indisponível");
        }
    }

    public void devolve() throws NenhumaCopiaEmprestadaEx {
        if (emprestados > 0){
            emprestados--;
        } else {
            throw new NenhumaCopiaEmprestadaEx("Nenhuma cópia emprestada");
        }
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public int getCopias() {
        return copias;
    }

    public int getEmprestados() {
        return emprestados;
    }

    public int getCodLivro() {
        return codLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria.getNome();
    }

    public void addUsuarioHist(GregorianCalendar dataEmprestimo, int CPFUsuario) {
        hist.add(new EmprestaPara(dataEmprestimo, CPFUsuario));
    }
}
