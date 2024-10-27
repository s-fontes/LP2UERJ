package pessoa;

import utils.Input;
import utils.InputInterruptException;
import validations.*;

import java.util.GregorianCalendar;

public class Generator {
    public static Pessoa generate(String sexo, String nome, String sobreNome, String dia, String mes, String ano, String numCPF, String peso, String altura) throws ValidationException {
        if (sexo.equals("m")) {
            return new Homem(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
        } else if (sexo.equals("f")) {
            return new Mulher(nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
        } else {
            throw new ValidationException("Sexo invalido");
        }
    }

    public static Pessoa generate(String sexo, String nome, String sobreNome, String dia, String mes, String ano) throws ValidationException {
        if (sexo.equals("m")) {
            return new Homem(nome, sobreNome, dia, mes, ano);
        } else if (sexo.equals("f")) {
            return new Mulher(nome, sobreNome, dia, mes, ano);
        } else {
            throw new ValidationException("Sexo invalido");
        }
    }

    public static Pessoa generate(String[] args) throws ValidationException {
        if (args.length == 9) {
            return generate(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
        } else if (args.length == 6) {
            return generate(args[0], args[1], args[2], args[3], args[4], args[5]);
        } else {
            throw new ValidationException("Número de argumentos inválido");
        }
    }

    public static Pessoa generate() throws InputInterruptException {
        System.out.println("Insira os dados da pessoa.");
        String nome = requestName();
        String sobreNome = requestSobreNome();
        String[] dataNasc = requestDataNasc();
        String numCPF = requestNumCPF();
        String peso = requestPeso();
        String altura = requestAltura();
        String sexo = requestSexo();
        try {
            return generate(sexo, nome, sobreNome, dataNasc[0], dataNasc[1], dataNasc[2], numCPF, peso, altura);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return generate();
        }
    }

    public static int requestNumPessoas() {
        try {
            return ValidaNumPessoas.validaNumPessoas(Input.get("Quantas pessoas a mais deseja inserir?"));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestNumPessoas();
        }
    }

    public static void printNumPessoas() {
        System.out.println("Foram criadas " + ValidaNumPessoas.imprimeNumPessoas(Pessoa.getNumPessoas()) + " pessoas.");
    }

    public static String requestSexo() {
        try {
            return ValidaSexo.validaSexo(Input.get("Esta pessoa é do gênero feminino ou masculino (f ou m)?"));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestSexo();
        }
    }

    public static String requestName() {
        try {
            return ValidaNome.validaNome(Input.get("Insira o nome"));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestName();
        }
    }

    public static String requestSobreNome() {
        try {
            return ValidaSobrenome.validaSobrenome(Input.get("Insira o sobrenome"));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestSobreNome();
        }
    }

    public static String requestDia() {
        try {
            return String.valueOf(ValidaData.validaDia(Input.get("Dia de nascimento")));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestDia();
        }
    }

    public static String requestMes() {
        try {
            return String.valueOf(ValidaData.validaMes(Input.get("Mês de nascimento")));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestMes();
        }
    }

    public static String requestAno() {
        try {
            return String.valueOf(ValidaData.validaAno(Input.get("Ano de nascimento")));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestAno();
        }
    }

    public static String[] requestDataNasc() {
        try {
            String dia = requestDia();
            String mes = requestMes();
            String ano = requestAno();
            GregorianCalendar data = ValidaData.validaData(dia, mes, ano);
            return new String[]{dia, mes, ano};
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestDataNasc();
        }
    }

    public static String requestNumCPF() {
        try {
            return String.format("%011d", ValidaCPF.validaCPF(Input.get("Insira o CPF")));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestNumCPF();
        }
    }

    public static String requestPeso() {
        try {
            return String.valueOf(ValidaPeso.validaPeso(Input.get("Insira o peso")));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestPeso();
        }
    }

    public static String requestAltura() {
        try {
            return String.valueOf(ValidaAltura.validaAltura(Input.get("Insira a altura")));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return requestAltura();
        }
    }
}
