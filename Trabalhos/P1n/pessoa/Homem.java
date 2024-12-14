package P1n.pessoa;

import P1n.validations.ValidaCPF;
import P1n.validations.ValidaPeso;
import P1n.validations.ValidaAltura;

public final class Homem extends Pessoa {

    public Homem(String nome, String sobreNome, int dia, int mes, int ano) {
        super(nome, sobreNome, dia, mes, ano);
    }

    public Homem(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        super(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Gênero: Masculino\n" +
                "CPF: " + ValidaCPF.imprimeCPF(super.getNumCPF()) + "\n" +
                "Peso: " + ValidaPeso.imprimePeso(super.getPeso()) + "\n" +
                "Altura: " + ValidaAltura.imprimeAltura(super.getAltura());
    }
}
