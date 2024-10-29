package validations;

public final class ValidaSexo {

    public static String validaSexo(String sexo) throws ValidationException {
        String pattern = "^m$|^f$";
        if (sexo.toLowerCase().matches(pattern)) {
            return sexo;
        } else {
            throw new ValidationException("Sexo invalido. Insira 'm' para masculino ou 'f' para feminino.");
        }
    }
}
