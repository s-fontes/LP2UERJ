package P2n.utils;

import P2n.pessoa.PessoaIMC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinhaListaOrdenavel {
    private ArrayList<PessoaIMC> lista = new ArrayList<>();

    public ArrayList<PessoaIMC> getLista() {
        return this.lista;
    }

    public static class Opcoes {
        public enum Opcao {
            NOME_ALFABETICA_AZ("Nome da pessoa – alfabetica (A-Z)"),
            NOME_ALFABETICA_ZA("Nome da pessoa – alfabetica (Z-A)"),
            PESO_CRESCENTE("Peso - crescente"),
            PESO_DECRESCENTE("Peso - decrescente"),
            IMC_CRESCENTE("IMC - crescente"),
            IMC_DECRESCENTE("IMC - decrescente"),
            GENERO_CRESCENTE("Genero - crescente"),
            GENERO_DECRESCENTE("Genero - decrescente"),
            IDADE_CRESCENTE("Idade - crescente"),
            IDADE_DECRESCENTE("Idade - decrescente"),
            DATA_NASC_CRESCENTE("Data de Nascimento - crescente"),
            DATA_NASC_DECRESCENTE("Data de Nascimento - decrescente"),
            CPF_CRESCENTE("CPF - crescente"),
            CPF_DECRESCENTE("CPF - decrescente"),
            ALTURA_CRESCENTE("Altura - crescente"),
            ALTURA_DECRESCENTE("Altura - decrescente");

            private final String description;

            Opcao(String description) {
                this.description = description;
            }

            public int getCode() {
                return this.ordinal();
            }

            public String getDescription() {
                return description;
            }
        }
    }

    public MinhaListaOrdenavel(PessoaIMC[] pessoas) {
        this.lista.addAll(Arrays.asList(pessoas));
    }

    public void add(PessoaIMC pessoa) {
        this.lista.add(pessoa);
    }

    public PessoaIMC get(int i) {
        return this.lista.get(i);
    }

    private Comparator<PessoaIMC> nomeC() {
        return new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                String nome1 = o1.getNome() + " " + o1.getSobreNome();
                String nome2 = o2.getNome() + " " + o2.getSobreNome();
                return nome1.compareTo(nome2);
            }
        };
    }

    private void ordenaNome() {
        this.lista.sort(nomeC());
    }

    private void ordenaNomeR() {
        this.lista.sort(nomeC().reversed());
    }

    private Comparator<PessoaIMC> pesoC() {
        return new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                return Float.compare(o1.getPeso(), o2.getPeso());
            }
        };
    }

    private void ordenaPeso() {
        this.lista.sort(pesoC());
    }

    private void ordenaPesoR() {
        this.lista.sort(pesoC().reversed());
    }

    private Comparator<PessoaIMC> imcC() {
        return new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                return Float.compare(o1.calculaIMC(), o2.calculaIMC());
            }
        };
    }

    private void ordenaIMC() {
        this.lista.sort(imcC());
    }

    private void ordenaIMCR() {
        this.lista.sort(imcC().reversed());
    }

    private Comparator<PessoaIMC> generoC() {
        return new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
            }
        };
    }

    private void ordenaGenero() {
        this.lista.sort(generoC());
    }

    private void ordenaGeneroR() {
        this.lista.sort(generoC().reversed());
    }

    private Comparator<PessoaIMC> idadeC() {
        return new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                return Integer.compare(o1.getIdade(), o2.getIdade());
            }
        };
    }

    private void ordenaIdade() {
        this.lista.sort(idadeC());
    }

    private void ordenaIdadeR() {
        this.lista.sort(idadeC().reversed());
    }

    private Comparator<PessoaIMC> dataNascC() {
        return new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                return o1.getDataNasc().compareTo(o2.getDataNasc());
            }
        };
    }

    private void ordenaDataNasc() {
        this.lista.sort(dataNascC());
    }

    private void ordenaDataNascR() {
        this.lista.sort(dataNascC().reversed());
    }

    private Comparator<PessoaIMC> cpfC() {
        return new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                return Long.compare(o1.getNumCPF(), o2.getNumCPF());
            }
        };
    }

    private void ordenaCPF() {
        this.lista.sort(cpfC());
    }

    private void ordenaCPFR() {
        this.lista.sort(cpfC().reversed());
    }

    private Comparator<PessoaIMC> alturaC() {
        return new Comparator<PessoaIMC>() {
            @Override
            public int compare(PessoaIMC o1, PessoaIMC o2) {
                return Float.compare(o1.getAltura(), o2.getAltura());
            }
        };
    }

    private void ordenaAltura() {
        this.lista.sort(alturaC());
    }

    private void ordenaAlturaR() {
        this.lista.sort(alturaC().reversed());
    }

    public void ordena(Opcoes.Opcao opcao) {
        switch (opcao) {
            case NOME_ALFABETICA_AZ:
                ordenaNome();
                break;
            case NOME_ALFABETICA_ZA:
                ordenaNomeR();
                break;
            case PESO_CRESCENTE:
                ordenaPeso();
                break;
            case PESO_DECRESCENTE:
                ordenaPesoR();
                break;
            case IMC_CRESCENTE:
                ordenaIMC();
                break;
            case IMC_DECRESCENTE:
                ordenaIMCR();
                break;
            case GENERO_CRESCENTE:
                ordenaGenero();
                break;
            case GENERO_DECRESCENTE:
                ordenaGeneroR();
                break;
            case IDADE_CRESCENTE:
                ordenaIdade();
                break;
            case IDADE_DECRESCENTE:
                ordenaIdadeR();
                break;
            case DATA_NASC_CRESCENTE:
                ordenaDataNasc();
                break;
            case DATA_NASC_DECRESCENTE:
                ordenaDataNascR();
                break;
            case CPF_CRESCENTE:
                ordenaCPF();
                break;
            case CPF_DECRESCENTE:
                ordenaCPFR();
                break;
            case ALTURA_CRESCENTE:
                ordenaAltura();
                break;
            case ALTURA_DECRESCENTE:
                ordenaAlturaR();
                break;
        }
    }
}
