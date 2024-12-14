package P1n.validations;

public final class ValidaGenero {

    public static char validaGenero(String sexo) throws ValidationException {
        String pattern = "^m$|^f$|^M$|^F$";
        if (sexo.toLowerCase().matches(pattern)) {
            return sexo.toLowerCase().charAt(0);
        } else {
            throw new ValidationException("Sexo invalido. Insira 'm' para masculino ou 'f' para feminino.");
        }
    }
}
