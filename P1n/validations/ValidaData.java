package validations;

import utils.MonthEnum;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class ValidaData {

    public static int validaDia(String strDia) throws ValidationException {
        try {
            int dia = Integer.parseInt(strDia);
            if (dia < 1 || dia > 31) {
                throw new ValidationException("Dia inválido. Insira um dia existente.");
            }
            return dia;
        } catch (NumberFormatException e) {
            throw new ValidationException("Dia inválido. Insira um dia existente.");
        }
    }

    public static int validaMes(String strMes) throws ValidationException {
        try {
            int mes = Integer.parseInt(strMes);
            if (mes < 1 || mes > 12) {
                throw new ValidationException("Mês inválido. Insira um mês existente.");
            }
            return mes;
        } catch (NumberFormatException e) {
            try {
                return MonthEnum.valueOf(strMes).ordinal() + 1;
            } catch (IllegalArgumentException ex) {
                throw new ValidationException("Mês inválido. Insira um mês existente.");
            }
        }
    }

    public static int validaAno(String strAno) throws ValidationException {
        try {
            int ano = Integer.parseInt(strAno);
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
            int anoAtual = calendar.get(GregorianCalendar.YEAR);
            if (ano < anoAtual - 120 || ano > anoAtual) {
                throw new ValidationException("Ano inválido. Insira um ano entre " + (anoAtual - 120) + " e " + anoAtual + ".");
            }
            return ano;
        } catch (NumberFormatException e) {
            throw new ValidationException("Ano inválido. Insira um ano existente.");
        }
    }

    public static GregorianCalendar validaData(String dia, String mes, String ano) throws ValidationException {
        try {
            int mesInt = validaMes(mes) - 1;
            GregorianCalendar data = new GregorianCalendar(validaAno(ano), mesInt, validaDia(dia));
            if (data.get(GregorianCalendar.MONTH) != mesInt) {
                throw new ValidationException("Data inválida. Insira uma data existente.");
            }
            return data;
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Data inválida. Insira uma data existente.");
        }
    }

    public static String imprimeData(GregorianCalendar data) {
        return String.format("%02d/%02d/%04d", data.get(GregorianCalendar.DAY_OF_MONTH), data.get(GregorianCalendar.MONTH) + 1, data.get(GregorianCalendar.YEAR));
    }
}
