package P1n.validations;

public final class ValidaSobrenome {

    public static String validaSobrenome(String sobrenome) throws ValidationException {
        String pattern = "[0-9]+";
        if (sobrenome.replaceAll(pattern, "").length() != sobrenome.length()) {
            throw new ValidationException("Sobrenome inválido. O sobrenome não pode conter números.");
        }
        return sobrenome.strip();
    }

    public static String imprimeSobrenome(String sobrenome) {
        return sobrenome;
    }
}
