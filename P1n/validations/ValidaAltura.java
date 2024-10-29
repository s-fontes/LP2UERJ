package validations;

public final class ValidaAltura {

    public static float validaAltura(String altura) throws ValidationException {
        String pattern = "^[0-9](\\.[0-9]{1,2})?$";
        if (altura.matches(pattern)) {
            return Float.parseFloat(altura);
        }
        throw new ValidationException("Altura inválida. Insira uma altura possível.");
    }

    public static String imprimeAltura(float altura) {
        return String.format("%.2f", altura);
    }
}
