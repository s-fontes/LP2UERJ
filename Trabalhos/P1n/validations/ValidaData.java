package P1n.validations;

import P1n.utils.MonthEnum;

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
            return mes - 1;
        } catch (NumberFormatException e) {
            try {
                return MonthEnum.valueOf(strMes).ordinal();
            } catch (IllegalArgumentException ex) {
                throw new ValidationException("Mês inválido. Insira um mês existente.");
            }
        }
    }

    public static int validaAno(String strAno) throws ValidationException {
        try {
            int ano = Integer.parseInt(strAno);
            GregorianCalendar hoje = new GregorianCalendar();
            hoje.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
            int anoAtual = hoje.get(GregorianCalendar.YEAR);
            if (ano < anoAtual - 120 || ano > anoAtual) {
                throw new ValidationException("Ano inválido. Insira um ano entre " + (anoAtual - 120) + " e " + anoAtual + ".");
            }
            return ano;
        } catch (NumberFormatException e) {
            throw new ValidationException("Ano inválido. Insira um ano existente.");
        }
    }

    public static void validaData(int dia, int mes, int ano) throws ValidationException {
        GregorianCalendar data = new GregorianCalendar(ano, mes, dia);
        GregorianCalendar hoje = new GregorianCalendar();
        hoje.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        if (data.get(GregorianCalendar.MONTH) != mes) {
            throw new ValidationException("Data inválida. Insira uma data existente.");
        } else if (data.after(hoje)) {
            throw new ValidationException("Data inválida. Insira uma data entre 01/01/" + (ano - 120) + " e " + "hoje.");
        }
    }
}
