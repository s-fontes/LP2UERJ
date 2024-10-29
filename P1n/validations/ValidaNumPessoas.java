package validations;

public final class ValidaNumPessoas {

    public static int validaNumPessoas(String numPessoas) throws ValidationException {
        String pattern = "^[0-9]*$";
        if (numPessoas.matches(pattern)) {
            return Integer.parseInt(numPessoas);
        } else {
            throw new ValidationException("Número de pessoas inválido");
        }
    }
}
