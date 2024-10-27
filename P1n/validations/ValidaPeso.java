package validations;

public abstract class ValidaPeso {
    public static String PATTERN = "^[0-9]{1,3}(\\.[0-9])?$";

    public static float validaPeso(String peso) throws ValidationException {
        if (peso.matches(PATTERN)) {
            return Float.parseFloat(peso);
        }
        throw new ValidationException("Peso inválido. Insira um peso possível.");
    }

    public static String imprimePeso(float peso) {
        return String.format("%.1f", peso);
    }
}