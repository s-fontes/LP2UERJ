package validations;

public final class ValidaPeso {

    public static float validaPeso(String peso) throws ValidationException {
        try {
            float p = Float.parseFloat(peso);
            if (p < 0.3 || p > 800.0) {
                throw new ValidationException("Peso inválido. Insira um peso possível.");
            }
            return p;
        } catch (NumberFormatException e) {
            throw new ValidationException("Peso inválido. Insira um peso possível.");
        }
    }

    public static String imprimePeso(float peso) {
        return String.format("%.1f", peso);
    }
}