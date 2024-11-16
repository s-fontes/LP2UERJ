package validations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ValidaCPF {

    private static boolean isFirstDigitValid(Integer[] digits) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += digits[i] * (i + 1);
        }
        return digits[9].equals((sum % 11) % 10);
    }

    private static boolean isSecondDigitValid(Integer[] digits) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += digits[i] * i;
        }
        return digits[10].equals((sum % 11) % 10);
    }

    private static boolean isAllDigitsEqual(Integer[] digits) {
        Set<Integer> digitsSet = new HashSet<>(Arrays.asList(digits));
        return digitsSet.size() == 1;
    }

    public static boolean isCPFValid(String cpf) {
        String cpfDigits = cpf.replaceAll("[^0-9]", "");
        Integer[] digits = new Integer[11];
        if (cpfDigits.length() != 11) {
            return false;
        }
        for (int i = 0; i < 11; i++) {
            digits[i] = Integer.parseInt(cpfDigits.substring(i, i + 1));
        }
        String pattern = "^[0-9]{11}$|^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$|^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}/[0-9]{2}$";
        return cpf.matches(pattern) && isFirstDigitValid(digits) && isSecondDigitValid(digits) && !isAllDigitsEqual(digits);
    }

    public static Long toLong(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        return Long.parseLong(cpf);
    }

    public static long validaCPF(String cpf) throws ValidationException {
        if (isCPFValid(cpf)) {
            return toLong(cpf);
        }
        throw new ValidationException("CPF incorreto. Este CPF não existe.");
    }

    public static String imprimeCPF(long cpf) {
        return String.format("%011d", cpf).replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1.$2.$3-$4");
    }
}
