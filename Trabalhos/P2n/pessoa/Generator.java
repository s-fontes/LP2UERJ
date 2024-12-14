package P2n.pessoa;

public abstract class Generator {
    public static PessoaIMC[] generate() {
        return new PessoaIMC[]{
                new Homem(
                        "João",
                        "Silva",
                        1,
                        1,
                        1990,
                        12345678901L,
                        Float.parseFloat("70"),
                        Float.parseFloat("1.92")
                ),
                new Mulher(
                        "Maria",
                        "Santos",
                        2,
                        2,
                        1991,
                        10987654321L,
                        Float.parseFloat("80"),
                        Float.parseFloat("1.65")
                ),
                new Homem(
                        "José",
                        "Oliveira",
                        3,
                        3,
                        1992,
                        12345678901L,
                        Float.parseFloat("80"),
                        Float.parseFloat("1.75")
                ),
                new Mulher(
                        "Ana",
                        "Silveira",
                        4,
                        4,
                        1993,
                        10987654321L,
                        Float.parseFloat("40"),
                        Float.parseFloat("1.60")
                ),
                new Homem(
                        "Carlos",
                        "Santana",
                        5,
                        5,
                        1994,
                        12345678901L,
                        Float.parseFloat("90"),
                        Float.parseFloat("1.80")
                ),
                new Mulher(
                        "Beatriz",
                        "Oliveira",
                        6,
                        6,
                        1995,
                        10987654321L,
                        Float.parseFloat("70"),
                        Float.parseFloat("1.70")
                ),
                new Homem(
                        "Pedro",
                        "Silva",
                        7,
                        7,
                        1996,
                        12345678901L,
                        Float.parseFloat("100"),
                        Float.parseFloat("1.85")
                ),
                new Mulher(
                        "Carla",
                        "Santos",
                        8,
                        8,
                        1997,
                        10987654321L,
                        Float.parseFloat("55"),
                        Float.parseFloat("1.62")
                ),
                new Homem(
                        "Paulo",
                        "Oliveira",
                        9,
                        9,
                        1998,
                        12345678901L,
                        Float.parseFloat("75"),
                        Float.parseFloat("1.70")
                ),
                new Mulher(
                        "Mariana",
                        "Silveira",
                        10,
                        10,
                        1999,
                        10987654321L,
                        Float.parseFloat("65"),
                        Float.parseFloat("1.65")
                ),
        };
    }
}
