package validations;

public final class ValidaNumPessoas {

    public static int validaNumPessoas(String numPessoas) throws ValidationException {
        try {
            int num = Integer.parseInt(numPessoas);
            if (num < 0) {
                throw new ValidationException("Número de pessoas inválido. Insira um número maior ou igual a zero.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new ValidationException("Número de pessoas inválido. Insira um número.");
        }
    }
}
