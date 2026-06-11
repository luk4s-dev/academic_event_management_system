import java.util.Scanner;

import modelo.Atividade;
import modelo.Palestrante;
import modelo.Participante;
import sistema.SistemaEventos;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaEventos sistema = new SistemaEventos();

        int opcao;

        do {

            System.out.println("\n===== SGEAC =====");
            System.out.println("1 - Cadastrar Participante");
            System.out.println("2 - Cadastrar Palestrante");
            System.out.println("3 - Cadastrar Atividade");
            System.out.println("4 - Inscrever Participante");
            System.out.println("5 - Buscar Participante");
            System.out.println("6 - Buscar Palestrante");
            System.out.println("7 - Buscar Atividade");
            System.out.println("8 - Relatório de Participantes");
            System.out.println("9 - Relatório de Palestrantes");
            System.out.println("10 - Relatório de Atividades");
            System.out.println("11 - Estatísticas");
            System.out.println("0 - Sair");

            System.out.print("\nEscolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("\n=== CADASTRAR PARTICIPANTE ===");

                    // implementar cadastro

                    break;

                case 2:
                    System.out.println("\n=== CADASTRAR PALESTRANTE ===");

                    // implementar cadastro

                    break;

                case 3:
                    System.out.println("\n=== CADASTRAR ATIVIDADE ===");

                    // implementar cadastro

                    break;

                case 4:
                    System.out.println("\n=== INSCRIÇÃO ===");

                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();

                    System.out.print("Código da atividade: ");
                    String codigo = sc.nextLine();

                    boolean inscrito =
                            sistema.inscreverParticipanteEmAtividade(matricula, codigo);

                    if (inscrito) {
                        System.out.println("Inscrição realizada com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar a inscrição.");
                    }
                    break;

                case 5:
                    System.out.print("Informe a matrícula: ");

                    matricula = sc.nextLine();

                    Participante participante = sistema.buscarParticipantePorMatricula(matricula);

                    if (participante != null) {
                        System.out.println(participante);
                    } else {
                        System.out.println("Participante não encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("Informe o CPF: ");

                    String cpf = sc.nextLine();

                    Palestrante palestrante = sistema.buscarPalestrantePorCpf(cpf);

                    if (palestrante != null) {
                        System.out.println(palestrante);
                    } else {
                        System.out.println("Palestrante não encontrado.");
                    }
                    break;

                case 7:
                    System.out.print("Informe o código da atividade: ");

                    codigo = sc.nextLine();

                    Atividade atividade = sistema.buscarAtividadePorCodigo(codigo);

                    if (atividade != null) {
                        System.out.println(atividade.getTitulo());
                    } else {
                        System.out.println("Atividade não encontrada.");
                    }
                    break;

                case 8:
                    sistema.relatorioParticipantes();
                    break;

                case 9:
                    sistema.relatorioPalestrantes();
                    break;

                case 10:
                    sistema.relatorioAtividades();
                    break;

                case 11:

                    System.out.println("\n=== ESTATÍSTICAS ===");

                    System.out.printf(
                            "Faturamento Total: R$ %.2f%n",
                            sistema.calcularFaturamentoTotal());

                    System.out.printf(
                            "Taxa Média de Ocupação: %.2f%%%n",
                            sistema.calcularTaxaMediaOcupacao());

                    Atividade maior = sistema.atividadeMaiorOcupacao();

                    Atividade menor = sistema.atividadeMenorOcupacao();

                    if (maior != null) {
                        System.out.println("Maior ocupação: " + maior.getTitulo());
                    }

                    if (menor != null) {
                        System.out.println("Menor ocupação: " + menor.getTitulo());
                    }
                    break;

                case 0:
                    System.out.println("\nSistema encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
