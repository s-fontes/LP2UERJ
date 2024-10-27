package validations;

public abstract class ValidaNumPessoas {
    static final String regex = "^[0-9]*$";

    public static int validaNumPessoas(String numPessoas) throws ValidationException {
        if (numPessoas.matches(regex)) {
            return Integer.parseInt(numPessoas);
        } else {
            throw new ValidationException("Número de pessoas inválido");
        }
    }

    public static String imprimeNumPessoas(int numPessoas) {
        return String.valueOf(numPessoas);
    }
}
