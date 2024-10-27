package validations;

public abstract class ValidaSobrenome {

    static final String PATTERN = "[0-9]+";

    public static String validaSobrenome(String sobrenome) throws ValidationException {
        if (sobrenome.replaceAll(PATTERN, "").length() != sobrenome.length()) {
            throw new ValidationException("Sobrenome inválido. O sobrenome não pode conter números.");
        }
        return sobrenome;
    }

    public static String imprimeSobrenome(String sobrenome) {
        return sobrenome;
    }
}
