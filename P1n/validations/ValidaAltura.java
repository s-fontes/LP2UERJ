package validations;

public final class ValidaAltura {

    public static float validaAltura(String altura) throws ValidationException {
        try {
            float a = Float.parseFloat(altura);
            if (a < 0.2 || a > 3.0) {
                throw new ValidationException("Altura inválida. Insira uma altura possível.");
            }
            return a;
        } catch (NumberFormatException e) {
            throw new ValidationException("Altura inválida. Insira uma altura possível.");
        }
    }

    public static String imprimeAltura(float altura) {
        return String.format("%.2f", altura);
    }
}
