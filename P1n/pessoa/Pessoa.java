package pessoa;

import validations.ValidaNome;
import validations.ValidaSobrenome;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public abstract class Pessoa {
    private static int numPessoas = 0;
    private String nome;
    private String sobreNome;
    private GregorianCalendar dataNasc;
    private long numCPF;
    private float peso;
    private float altura;

    protected Pessoa(String nome, String sobreNome, int dia, int mes, int ano) {
        this.setNome(nome);
        this.setSobreNome(sobreNome);
        this.setDataNasc(dia, mes, ano);
        numPessoas++;
    }

    protected Pessoa(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        this.setNome(nome);
        this.setSobreNome(sobreNome);
        this.setDataNasc(dia, mes, ano);
        this.setNumCPF(numCPF);
        this.setPeso(peso);
        this.setAltura(altura);
        numPessoas++;
    }

    public static int getNumPessoas() {
        return numPessoas;
    }

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getSobreNome() {
        return sobreNome;
    }

    protected void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    protected GregorianCalendar getDataNasc() {
        return dataNasc;
    }

    protected void setDataNasc(int dia, int mes, int ano) {
        GregorianCalendar dataNasc = new GregorianCalendar(ano, mes, dia);
        dataNasc.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        this.dataNasc = dataNasc;
    }

    protected int getIdade() {
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

    protected long getNumCPF() {
        return numCPF;
    }

    protected void setNumCPF(long numCPF) {
        this.numCPF = numCPF;
    }

    protected float getPeso() {
        return peso;
    }

    protected void setPeso(float peso) {
        this.peso = peso;
    }

    protected float getAltura() {
        return altura;
    }

    protected void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Nome: " + ValidaNome.imprimeNome(getNome()) + "\n" +
                "Sobrenome: " + ValidaSobrenome.imprimeSobrenome(getSobreNome()) + "\n" +
                "Idade: " + getIdade() + "\n";
    }
}
