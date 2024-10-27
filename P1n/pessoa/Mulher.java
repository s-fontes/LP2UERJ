package pessoa;

public class Mulher extends Pessoa {

    public Mulher(String nome, String sobreNome, String dia, String mes, String ano) {
        super(nome, sobreNome, dia, mes, ano);
    }

    public Mulher(String nome, String sobreNome, String dia, String mes, String ano, String numCPF, String peso, String altura) {
        super(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
    }

    @Override
    public String toString() {
        return "Mulher " + super.toString();
    }
}
