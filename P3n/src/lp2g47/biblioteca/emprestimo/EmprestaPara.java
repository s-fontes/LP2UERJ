package lp2g47.biblioteca.emprestimo;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public class EmprestaPara {
    GregorianCalendar dataEmprestimo;
    GregorianCalendar dataDevolucao = null;
    int CPF;

    public EmprestaPara(GregorianCalendar dataEmprestimo, int CPF) {
        dataEmprestimo.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        this.dataEmprestimo = dataEmprestimo;
        this.CPF = CPF;
    }

    public void devolver(GregorianCalendar dataDevolucao) {
        dataDevolucao.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isDevolvido() {
        return dataDevolucao != null;
    }
}
