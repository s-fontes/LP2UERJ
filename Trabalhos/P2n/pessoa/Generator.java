package P2n.pessoa;

public abstract class Generator {
    public static PessoaIMC[] generate() {
        return new PessoaIMC[]{
                new Homem(
                        "Lucas",
                        "Almeida",
                        10,
                        5,
                        1985,
                        12345678902L,
                        Float.parseFloat("55"),
                        Float.parseFloat("1.80")
                ),
                new Homem(
                        "Rafael",
                        "Pereira",
                        12,
                        6,
                        1988,
                        34567890124L,
                        Float.parseFloat("70"),
                        Float.parseFloat("1.75")
                ),
                new Homem(
                        "Felipe",
                        "Martins",
                        18,
                        8,
                        1995,
                        56789012346L,
                        Float.parseFloat("85"),
                        Float.parseFloat("1.80")
                ),
                new Homem(
                        "Leonardo",
                        "Rodrigues",
                        15,
                        1,
                        1989,
                        78901234568L,
                        Float.parseFloat("60"),
                        Float.parseFloat("1.85")
                ),
                new Homem(
                        "Bruno",
                        "Carvalho",
                        27,
                        7,
                        1993,
                        90123456780L,
                        Float.parseFloat("80"),
                        Float.parseFloat("1.80")
                ),
                new Mulher(
                        "Fernanda",
                        "Costa",
                        23,
                        3,
                        1990,
                        23456789013L,
                        Float.parseFloat("45"),
                        Float.parseFloat("1.65")
                ),
                new Mulher(
                        "Isabela",
                        "Moreira",
                        7,
                        9,
                        1992,
                        45678901235L,
                        Float.parseFloat("55"),
                        Float.parseFloat("1.68")
                ),
                new Mulher(
                        "Gabriela",
                        "Ferreira",
                        4,
                        12,
                        1997,
                        67890123457L,
                        Float.parseFloat("80"),
                        Float.parseFloat("1.65")
                ),
                new Mulher(
                        "Juliana",
                        "Silva",
                        3,
                        2,
                        1994,
                        89012345679L,
                        Float.parseFloat("48"),
                        Float.parseFloat("1.60")
                ),
                new Mulher(
                        "Patrícia",
                        "Azevedo",
                        14,
                        11,
                        1996,
                        10234567891L,
                        Float.parseFloat("60"),
                        Float.parseFloat("1.70")
                ),
        };
    }
}
