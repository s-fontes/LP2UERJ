import pessoa.Generator;
import pessoa.Homem;
import pessoa.Mulher;
import pessoa.Pessoa;
import utils.InputInterruptException;
import validations.ValidationException;

public class P1nX {
    private static int numHomens = 0;
    private static int numMulheres = 0;
    private static int initNumPessoas = 0;

    public static void main(String[] args) {
        generatePessoaByArgs(args);
        try {
            int np = Generator.requestNumPessoas();
            Pessoa[] pessoas = new Pessoa[np];
            for (int i = 0; i < np; i++) {
                try {
                    pessoas[i] = Generator.generate();
                } catch (InputInterruptException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
            countGender(pessoas);
            printPessoas(pessoas);
        } catch (InputInterruptException e) {
            System.out.println(e.getMessage());
        }
        printStats();
        System.out.println("\nPrograma encerrado.");
        System.exit(0);
    }

    private static void generatePessoaByArgs(String[] args) {
        try {
            Pessoa p1 = Generator.generate(args);
            initNumPessoas++;
            countGender(p1);
            System.out.println(p1);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void countGender(Pessoa p) {
        if (p instanceof Homem) {
            numHomens++;
        } else if (p instanceof Mulher) {
            numMulheres++;
        }
    }

    private static void countGender(Pessoa[] pessoas) {
        for (int i = 0; i < Pessoa.getNumPessoas() - initNumPessoas; i++) {
            countGender(pessoas[i]);
        }
    }

    private static void printPessoas(Pessoa[] pessoas) {
        System.out.println("\n-----------------------------------------------------------\nInformações inseridas:");
        for (int i = 0; i < Pessoa.getNumPessoas() - initNumPessoas; i++) {
            System.out.println(pessoas[i] + "\n");
        }
    }

    private static void printStats() {
        System.out.println("Número de pessoas: " + Pessoa.getNumPessoas());
        System.out.println("Número de homens: " + numHomens);
        System.out.println("Número de mulheres: " + numMulheres);
    }
}