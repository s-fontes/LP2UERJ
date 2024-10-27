package utils;

public enum MonthEnum {
    janeiro,
    fevereiro,
    marco,
    abril,
    maio,
    junho,
    julho,
    agosto,
    setembro,
    outubro,
    novembro,
    dezembro;

    public static int getMonthNumber(String month) {
        return MonthEnum.valueOf(month).ordinal();
    }
}
