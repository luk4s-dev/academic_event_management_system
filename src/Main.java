import java.time.LocalDate;
import java.util.Scanner;

import modelo.Atividade;
import modelo.MesaRedonda;
import modelo.Minicurso;
import modelo.Palestra;
import modelo.Palestrante;
import modelo.Participante;
import modelo.TipoParticipante;
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

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Ano de nascimento: ");
                    int ano = sc.nextInt();

                    System.out.print("Mês de nascimento: ");
                    int mes = sc.nextInt();

                    System.out.print("Dia de nascimento: ");
                    int dia = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();

                    System.out.println("\nTipo Participante");
                    System.out.println("1 - ESTUDANTE");
                    System.out.println("2 - PROFISSIONAL");
                    System.out.println("3 - DOCENTE");

                    int opcTipo = sc.nextInt();
                    sc.nextLine();

                    TipoParticipante tipo = null;

                    switch (opcTipo) {
                        case 1:
                            tipo = TipoParticipante.ESTUDANTE;
                            break;
                        case 2:
                            tipo = TipoParticipante.PROFISSIONAL;
                            break;
                        case 3:
                            tipo = TipoParticipante.DOCENTE;
                            break;
                    }

                    Participante participante = new Participante(
                            cpf,
                            nome,
                            email,
                            LocalDate.of(ano, mes, dia),
                            matricula,
                            tipo
                    );

                    if (sistema.cadastrarParticipante(participante)) {
                        System.out.println("Participante cadastrado com sucesso!");
                    } else {
                        System.out.println("Matrícula já cadastrada!");
                    }
                    break;

                case 2:
                    System.out.println("\n=== CADASTRAR PALESTRANTE ===");

                    System.out.print("CPF: ");
                    cpf = sc.nextLine();

                    System.out.print("Nome: ");
                    nome = sc.nextLine();

                    System.out.print("Email: ");
                    email = sc.nextLine();

                    System.out.print("Ano de nascimento: ");
                    ano = sc.nextInt();

                    System.out.print("Mês de nascimento: ");
                    mes = sc.nextInt();

                    System.out.print("Dia de nascimento: ");
                    dia = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Titulação: ");
                    String titulacao = sc.nextLine();

                    System.out.print("Área de Especialização: ");
                    String area = sc.nextLine();

                    Palestrante palestrante = new Palestrante(
                            cpf,
                            nome,
                            email,
                            LocalDate.of(ano, mes, dia),
                            titulacao,
                            area
                    );

                    if (sistema.cadastrarPalestrante(palestrante)) {
                        System.out.println("Palestrante cadastrado com sucesso!");
                    } else {
                        System.out.println("CPF já cadastrado!");
                    }

                    break;

                case 3:
                    
                    System.out.println("\n=== CADASTRAR ATIVIDADE ===");

                    System.out.println("1 - Palestra");
                    System.out.println("2 - Minicurso");
                    System.out.println("3 - Mesa Redonda");

                    int tipoAtividade = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Código: ");
                    String codigo = sc.nextLine();

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Carga Horária: ");
                    int cargaHoraria = sc.nextInt();

                    System.out.print("Capacidade Máxima: ");
                    int capacidade = sc.nextInt();
                    sc.nextLine();

                    System.out.print("CPF do palestrante: ");
                    cpf = sc.nextLine();

                    Palestrante palestranteAtividade = sistema.buscarPalestrantePorCpf(cpf);

                    if (palestranteAtividade == null) {

                        System.out.println("Palestrante não encontrado!");

                        break;
                    }

                    Atividade atividade = null;

                    switch (tipoAtividade) {
                        case 1:
                            atividade = new Palestra(
                                    codigo,
                                    titulo,
                                    cargaHoraria,
                                    capacidade,
                                    palestranteAtividade
                            );
                            break;

                        case 2:
                            System.out.print("Custo Material: ");

                            double custoMaterial = sc.nextDouble();

                            sc.nextLine();

                            atividade = new Minicurso(
                                    codigo,
                                    titulo,
                                    cargaHoraria,
                                    capacidade,
                                    palestranteAtividade,
                                    custoMaterial
                            );
                            break;

                        case 3:
                            System.out.print("Tema: ");
                            String tema = sc.nextLine();

                            System.out.print("Moderador: ");
                            String moderador = sc.nextLine();

                            atividade = new MesaRedonda(
                                    codigo,
                                    titulo,
                                    cargaHoraria,
                                    capacidade,
                                    palestranteAtividade,
                                    tema,
                                    moderador
                            );
                            break;

                        default:
                            System.out.println("Tipo inválido.");
                            break;
                    }

                    if (atividade != null) {

                        if (sistema.cadastrarAtividade(atividade)) {

                            System.out.println(
                                    "Atividade cadastrada com sucesso!");

                        } else {

                            System.out.println(
                                    "Código já cadastrado!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n=== INSCRIÇÃO ===");

                    System.out.print("Matrícula: ");
                    matricula = sc.nextLine();

                    System.out.print("Código da atividade: ");
                    codigo = sc.nextLine();

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

                    participante = sistema.buscarParticipantePorMatricula(matricula);

                    if (participante != null) {
                        System.out.println(participante);
                    } else {
                        System.out.println("Participante não encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("Informe o CPF: ");

                    cpf = sc.nextLine();

                    palestrante = sistema.buscarPalestrantePorCpf(cpf);

                    if (palestrante != null) {
                        System.out.println(palestrante);
                    } else {
                        System.out.println("Palestrante não encontrado.");
                    }
                    break;

                case 7:
                    System.out.print("Informe o código da atividade: ");

                    codigo = sc.nextLine();

                    atividade = sistema.buscarAtividadePorCodigo(codigo);

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
