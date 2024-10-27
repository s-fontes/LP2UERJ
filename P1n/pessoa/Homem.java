package pessoa;

public class Homem extends Pessoa {

    public Homem(String nome, String sobreNome, String dia, String mes, String ano) {
        super(nome, sobreNome, dia, mes, ano);
    }

    public Homem(String nome, String sobreNome, String dia, String mes, String ano, String numCPF, String peso, String altura) {
        super(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
    }

    @Override
    public String toString() {
        return "Homem " + super.toString();
    }
}
