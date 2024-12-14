package P2n.pessoa;

import P2n.format.Formatter;

public final class Mulher extends PessoaIMC {

    public Mulher(String nome, String sobreNome, int dia, int mes, int ano) {
        super(nome, sobreNome, dia, mes, ano);
    }

    public Mulher(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        super(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
    }

    protected String resultIMC() {
        float imc = calculaIMC();
        if (imc == 0) {
            return "Dados de peso e altura não informados";
        } else if (imc < 19) {
            return "Abaixo do peso ideal";
        } else if (imc <= 25.8) {
            return "Peso ideal";
        } else {
            return "Acima do peso ideal";
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Idade: " + Formatter.formatIdade(super.getIdade()) + "\n" +
                "IMC: " + Formatter.formatIMC(super.calculaIMC(), this.resultIMC());
    }
}
