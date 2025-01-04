package P3n.lp2g47.biblioteca.emprestimo;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Emprestimo {
    final GregorianCalendar dataEmprestimo;
    final int codLivro;
    GregorianCalendar dataDevolucao = null;

    public Emprestimo(GregorianCalendar dataEmprestimo, int codLivro) {
        dataEmprestimo.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        this.dataEmprestimo = dataEmprestimo;
        this.codLivro = codLivro;
    }

    public void devolver(GregorianCalendar dataDevolucao) {
        dataDevolucao.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isDevolvido() {
        return dataDevolucao != null;
    }
}
