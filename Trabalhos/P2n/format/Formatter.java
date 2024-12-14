package P2n.format;

import java.util.GregorianCalendar;

public final class Formatter {
    public static String formatNome(String nome) {
        return nome;
    }

    public static String formatSobreNome(String sobreNome) {
        return sobreNome;
    }

    public static String formatData(GregorianCalendar data) {
        return String.format("%02d/%02d/%04d", data.get(GregorianCalendar.DAY_OF_MONTH), data.get(GregorianCalendar.MONTH) + 1, data.get(GregorianCalendar.YEAR));
    }

    public static String formatCPF(long cpf) {
        return String.format("%011d", cpf).replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1.$2.$3-$4");
    }

    public static String formatPeso(float peso) {
        return String.format("%.2f Kg", peso);
    }

    public static String formatAltura(float altura) {
        return String.format("%.2f m", altura);
    }

    public static String formatIdade(int idade) {
        return String.format("%d anos", idade);
    }

    public static String formatIMC(float imc, String resultIMC) {
        return String.format("%.2f - %s", imc, resultIMC);
    }
}
