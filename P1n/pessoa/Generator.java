package pessoa;

import utils.Input;
import utils.InputInterruptException;
import validations.*;

public final class Generator {
    private static Pessoa generate(char genero, String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        if (genero == 'm') {
            return new Homem(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
        } else {
            return new Mulher(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
        }
    }

    private static Pessoa generate(char genero, String nome, String sobreNome, int dia, int mes, int ano) {
        if (genero == 'm') {
            return new Homem(nome, sobreNome, dia, mes, ano);
        } else {
            return new Mulher(nome, sobreNome, dia, mes, ano);
        }
    }

public static Pessoa generate(String[] args) throws ValidationException {
    if (args.length != 9 && args.length != 6) {
        throw new ValidationException("Informações faltando. Por favor, preencha todos os dados.");
    }

    char genero = ValidaGenero.validaGenero(args[0]);
    String nome = ValidaNome.validaNome(args[1]);
    String sobreNome = ValidaSobrenome.validaSobrenome(args[2]);
    int dia = ValidaData.validaDia(args[3]);
    int mes = ValidaData.validaMes(args[4]);
    int ano = ValidaData.validaAno(args[5]);
    ValidaData.validaData(dia, mes, ano);

    if (args.length == 9) {
        long numCPF = ValidaCPF.validaCPF(args[6]);
        float peso = ValidaPeso.validaPeso(args[7]);
        float altura = ValidaAltura.validaAltura(args[8]);
        return generate(genero, nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
    } else {
        return generate(genero, nome, sobreNome, dia, mes, ano);
    }
}

    public static Pessoa generate() throws InputInterruptException {
        String nome = requestName();
        String sobreNome = requestSobreNome();
        int[] dataNasc = requestDataNasc();
        long numCPF = requestNumCPF();
        float peso = requestPeso();
        float altura = requestAltura();
        char genero = requestGenero();
        if (genero == 'm') {
            return new Homem(nome, sobreNome, dataNasc[0], dataNasc[1], dataNasc[2], numCPF, peso, altura);
        } else {
            return new Mulher(nome, sobreNome, dataNasc[0], dataNasc[1], dataNasc[2], numCPF, peso, altura);
        }
    }

    public static int requestNumPessoas() throws InputInterruptException {
        try {
            return ValidaNumPessoas.validaNumPessoas(Input.get("Quantas pessoas a mais deseja inserir? "));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestNumPessoas();
        }
    }

    public static char requestGenero() throws InputInterruptException {
        try {
            return ValidaGenero.validaGenero(Input.get("Esta pessoa é do gênero feminino ou masculino (f ou m)? "));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestGenero();
        }
    }

    public static String requestName() throws InputInterruptException {
        try {
            return ValidaNome.validaNome(Input.get("Insira o nome: "));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestName();
        }
    }

    public static String requestSobreNome() throws InputInterruptException {
        try {
            return ValidaSobrenome.validaSobrenome(Input.get("Insira o sobrenome: "));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestSobreNome();
        }
    }

    public static int requestDia() throws InputInterruptException {
        try {
            return ValidaData.validaDia(Input.get("Dia de nascimento: "));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestDia();
        }
    }

    public static int requestMes() throws InputInterruptException {
        try {
            return ValidaData.validaMes(Input.get("Mês de nascimento: "));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestMes();
        }
    }

    public static int requestAno() throws InputInterruptException {
        try {
            return ValidaData.validaAno(Input.get("Ano de nascimento: "));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestAno();
        }
    }

    public static int[] requestDataNasc() throws InputInterruptException {
        try {
            int dia = requestDia();
            int mes = requestMes();
            int ano = requestAno();
            ValidaData.validaData(dia, mes, ano);
            return new int[]{dia, mes, ano};
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestDataNasc();
        }
    }

    public static long requestNumCPF() throws InputInterruptException {
        try {
            return ValidaCPF.validaCPF(Input.get("Insira o CPF: "));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestNumCPF();
        }
    }

    public static float requestPeso() throws InputInterruptException {
        try {
            return ValidaPeso.validaPeso(Input.get("Insira o peso: "));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestPeso();
        }
    }

    public static float requestAltura() throws InputInterruptException {
        try {
            return ValidaAltura.validaAltura(Input.get("Insira a altura: "));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestAltura();
        }
    }
}
