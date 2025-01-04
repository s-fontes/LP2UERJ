package lp2g47.biblioteca.usuario;

import lp2g47.biblioteca.utils.Formatter;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public abstract class Pessoa {
    private static int numPessoas = 0;
    private String nome;
    private String sobreNome;
    private GregorianCalendar dataNasc;
    private long numCPF;

    protected Pessoa(String nome, String sobreNome, int dia, int mes, int ano, long numCPF) {
        this.setNome(nome);
        this.setSobreNome(sobreNome);
        this.setDataNasc(dia, mes, ano);
        this.setNumCPF(numCPF);
        numPessoas++;
    }

    public static int getNumPessoas() {
        return numPessoas;
    }

    public String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    protected void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public GregorianCalendar getDataNasc() {
        return dataNasc;
    }

    protected void setDataNasc(int dia, int mes, int ano) {
        GregorianCalendar dataNasc = new GregorianCalendar(ano, mes, dia);
        dataNasc.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        this.dataNasc = dataNasc;
    }

    public int getIdade() {
        GregorianCalendar hoje = new GregorianCalendar();
        hoje.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        GregorianCalendar dataNasc = getDataNasc();
        int idade = hoje.get(GregorianCalendar.YEAR) - dataNasc.get(GregorianCalendar.YEAR);
        if (hoje.get(GregorianCalendar.MONTH) < dataNasc.get(GregorianCalendar.MONTH) ||
                (hoje.get(GregorianCalendar.MONTH) == dataNasc.get(GregorianCalendar.MONTH) &&
                        hoje.get(GregorianCalendar.DAY_OF_MONTH) < dataNasc.get(GregorianCalendar.DAY_OF_MONTH))) {
            idade--;
        }
        return idade;
    }

    public long getNumCPF() {
        return numCPF;
    }

    protected void setNumCPF(long numCPF) {
        this.numCPF = numCPF;
    }

    @Override
    public String toString() {
        return "Nome: " + Formatter.formatNome(getNome()) + "\n" +
                "Sobrenome: " + Formatter.formatSobrenome(getSobreNome()) + "\n" +
                "Data de Nascimento: " + Formatter.formatData(getDataNasc()) + "\n" +
                "Idade: " + Formatter.formatIdade(getIdade()) + "\n" +
                "CPF: " + Formatter.formatCPF(getNumCPF()) + "\n";
    }
}
