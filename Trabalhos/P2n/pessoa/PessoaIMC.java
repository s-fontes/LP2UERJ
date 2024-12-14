package P2n.pessoa;

import P2n.format.Formatter;

public abstract class PessoaIMC extends Pessoa {
    private float peso = 0;
    private float altura = 0;

    protected PessoaIMC(String nome, String sobreNome, int dia, int mes, int ano) {
        super(nome, sobreNome, dia, mes, ano);
    }

    protected PessoaIMC(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        super(nome, sobreNome, dia, mes, ano, numCPF);
        this.setPeso(peso);
        this.setAltura(altura);
    }

    public float getPeso() {
        return peso;
    }

    protected void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    protected void setAltura(float altura) {
        this.altura = altura;
    }

    public float calculaIMC() {
        if (this.getAltura() != 0 && this.getPeso() != 0) {
            return this.getPeso() / (this.getAltura() * this.getAltura());
        }
        return 0;
    }

    abstract String resultIMC();

    @Override
    public String toString() {
        return super.toString() +
                "Peso: " + Formatter.formatPeso(this.peso) + "\n" +
                "Altura: " + Formatter.formatAltura(this.altura) + "\n";
    }
}
