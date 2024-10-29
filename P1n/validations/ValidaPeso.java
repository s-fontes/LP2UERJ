package validations;

public final class ValidaPeso {

    public static float validaPeso(String peso) throws ValidationException {
        String pattern = "^[0-9]{1,3}(\\.[0-9])?$";
        if (peso.matches(pattern)) {
            return Float.parseFloat(peso);
        }
        throw new ValidationException("Peso inválido. Insira um peso possível.");
    }

    public static String imprimePeso(float peso) {
        return String.format("%.1f", peso);
    }
}