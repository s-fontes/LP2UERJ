import pessoa.Generator;
import pessoa.Homem;
import pessoa.Mulher;
import pessoa.Pessoa;
import utils.InputInterruptException;
import validations.ValidationException;

public class P1nX {
    private static int numHomens = 0;
    private static int numMulheres = 0;

    public static void main(String[] args) {
        try {
            Pessoa p1 = Generator.generate(args);
            if (p1 instanceof Homem) {
                numHomens++;
            } else if (p1 instanceof Mulher) {
                numMulheres++;
            }
            System.out.println(p1);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
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
            for (int i = 0; i < Pessoa.getNumPessoas() - 1; i++) {
                if (pessoas[i] instanceof Homem) {
                    numHomens++;
                } else if (pessoas[i] instanceof Mulher) {
                    numMulheres++;
                }
                System.out.println(pessoas[i]);
            }
        } catch (InputInterruptException e) {
            System.out.println(e.getMessage());
        }
        Generator.printNumPessoas();
        System.out.println("Número de homens: " + numHomens);
        System.out.println("Número de mulheres: " + numMulheres);
        System.out.println("Programa encerrado.");
        System.exit(0);
    }
}