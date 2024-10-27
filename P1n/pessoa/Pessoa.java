package pessoa;

import validations.*;

import java.util.GregorianCalendar;

public abstract class Pessoa {
    private static int numPessoas = 0;
    private String nome;
    private String sobreNome;
    private GregorianCalendar dataNasc;
    private long numCPF;
    private float peso;
    private float altura;

    protected Pessoa(String nome, String sobreNome, String dia, String mes, String ano) {
        this.setNome(nome);
        this.setSobreNome(sobreNome);
        this.setDataNasc(dia, mes, ano);
        numPessoas++;
    }

    protected Pessoa(String nome, String sobreNome, String dia, String mes, String ano, String numCPF, String peso, String altura) {
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
        this.nome = ValidaNome.validaNome(nome);
    }

    protected String getSobreNome() {
        return sobreNome;
    }

    protected void setSobreNome(String sobreNome) {
        this.sobreNome = ValidaSobrenome.validaSobrenome(sobreNome);
    }

    protected GregorianCalendar getDataNasc() {
        return dataNasc;
    }

    protected void setDataNasc(String dia, String mes, String ano) {
        this.dataNasc = ValidaData.validaData(dia, mes, ano);
    }


    protected long getNumCPF() {
        return numCPF;
    }

    protected void setNumCPF(String numCPF) {
        this.numCPF = ValidaCPF.validaCPF(numCPF);
    }

    protected float getPeso() {
        return peso;
    }

    protected void setPeso(String peso) {
        this.peso = ValidaPeso.validaPeso(peso);
    }

    protected float getAltura() {
        return altura;
    }

    protected void setAltura(String altura) {
        this.altura = ValidaAltura.validaAltura(altura);
    }

    @Override
    public String toString() {
        return "{nome: '" + ValidaNome.imprimeNome(getNome()) + "'" +
                ", sobrenome: '" + ValidaSobrenome.imprimeSobrenome(getSobreNome()) + "'" +
                ", data de nascimento: '" + ValidaData.imprimeData(getDataNasc()) + "'" +
                ", CPF: '" + ValidaCPF.imprimeCPF(getNumCPF()) + "'" +
                ", peso: '" + ValidaPeso.imprimePeso(getPeso()) + " Kg'" +
                ", altura: '" + ValidaAltura.imprimeAltura(getAltura()) + " m'" + '}';
    }
}
