package P1n.validations;

public final class ValidaNome {

    public static String validaNome(String nome) throws ValidationException {
        String pattern = "[0-9]+";
        if (nome.replaceAll(pattern, "").length() != nome.length()) {
            throw new ValidationException("Nome inválido. O nome não pode conter números.");
        }
        return nome.strip();
    }

    public static String imprimeNome(String nome) {
        return nome;
    }
}
