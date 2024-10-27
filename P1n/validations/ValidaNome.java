package validations;

public abstract class ValidaNome {

    static final String PATTERN = "[0-9]+";

    public static String validaNome(String nome) throws ValidationException {
        if (nome.replaceAll(PATTERN, "").length() != nome.length()) {
            throw new ValidationException("Nome inválido. O nome não pode conter números.");
        }
        return nome;
    }

    public static String imprimeNome(String nome) {
        return nome;
    }
}
