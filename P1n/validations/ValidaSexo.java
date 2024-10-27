package validations;

public abstract class ValidaSexo {
    final static String PATTERN = "^m$|^f$";

    public static String validaSexo(String sexo) throws ValidationException {
        if (sexo.matches(PATTERN)) {
            return sexo;
        } else {
            throw new ValidationException("Sexo invalido. Insira 'm' para masculino ou 'f' para feminino.");
        }
    }

    public static String imprimeSexo(String sexo) {
        if (sexo.equals("m")) {
            return "Masculino";
        } else if (sexo.equals("f")) {
            return "Feminino";
        } else {
            return "Sexo inválido";
        }
    }
}
