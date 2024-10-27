package validations;

public abstract class ValidaAltura {
    public static String PATTERN = "^[0-9](\\.[0-9]{1,2})?$";

    public static float validaAltura(String altura) throws ValidationException {
        if (altura.matches(PATTERN)) {
            return Float.parseFloat(altura);
        }
        throw new ValidationException("Altura inválida. Insira uma altura possível.");
    }

    public static String imprimeAltura(float altura) {
        return String.format("%.2f", altura);
    }
}
