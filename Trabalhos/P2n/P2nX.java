package P2n;

import P2n.pessoa.Generator;
import P2n.pessoa.PessoaIMC;
import P2n.utils.MinhaListaOrdenavel;
import P2n.utils.Input;

public class P2nX {
    public static void main(String[] args){
        MinhaListaOrdenavel lista = new MinhaListaOrdenavel(Generator.generate());
        PrintListaOrdenada(lista);
    }

    private static MinhaListaOrdenavel.Opcoes.Opcao getOpcao(){
        System.out.println("Escolha uma opção de ordenação:");
        for (MinhaListaOrdenavel.Opcoes.Opcao opcao : MinhaListaOrdenavel.Opcoes.Opcao.values()) {
            System.out.println(opcao.getCode() + " - " + opcao.getDescription());
        }
        try {
            int opcao = Integer.parseInt(Input.get("Opção: "));
            return MinhaListaOrdenavel.Opcoes.Opcao.values()[opcao];
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Opção inválida.");
            return getOpcao();
        }
    }

    private static void PrintLista(MinhaListaOrdenavel lista) {
        for (PessoaIMC pessoa : lista.getLista()) {
            System.out.println( "--------\n" + pessoa + "\n--------");
        }
    }

    private static void PrintListaOrdenada(MinhaListaOrdenavel lista) {
        System.out.println("1.Imprimir lista ordenada\n2.Sair");
        int opcao = 0;
        try {
            opcao = Integer.parseInt(Input.get("Digite sua opção: "));
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida.");
            PrintListaOrdenada(lista);
        }
        switch (opcao) {
            case 1:
                MinhaListaOrdenavel.Opcoes.Opcao ordOpcao = getOpcao();
                lista.ordena(ordOpcao);
                PrintLista(lista);
                PrintListaOrdenada(lista);
            case 2:
                System.out.println("Programa encerrado.");
                System.exit(0);
            default:
                System.out.println("Opção inválida.");
                PrintListaOrdenada(lista);
        }

    }
}