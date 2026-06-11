package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Atividade;
import modelo.Palestrante;
import modelo.Participante;

public class SistemaEventos {
    private Map<String, Participante> participantesPorMatricula;
    private Map<String, Palestrante> palestrantesPorCpf;
    private List<Atividade> atividades;
    private String[] diasFuncionamento;

    public SistemaEventos() {

        // Inicializando os atributos
        participantesPorMatricula = new HashMap<>();
        palestrantesPorCpf = new HashMap<>();
        atividades = new ArrayList<>();

        diasFuncionamento = new String[5];

        // Preenchendo o array de dias
        inicializarDias();
    }

    public void inicializarDias() {
        diasFuncionamento[0] = "Segunda-feira";
        diasFuncionamento[1] = "Terça-feira";
        diasFuncionamento[2] = "Quarta-feira";
        diasFuncionamento[3] = "Quinta-feira";
        diasFuncionamento[4] = "Sexta-feira";
    }

    public boolean cadastrarParticipante(Participante participante) {
        if (participante == null) {
            throw new IllegalArgumentException("Participante não pode ser nulo");
        }

        if (participantesPorMatricula.containsKey(participante.getMatricula())) {
            return false;
        }

        participantesPorMatricula.put(participante.getMatricula(), participante);
        
        return true;
    }

    public boolean cadastrarPalestrante(Palestrante palestrante) {

        if (palestrante == null) {
            throw new IllegalArgumentException(
                    "Palestrante não pode ser nulo.");
        }

        if (palestrantesPorCpf.containsKey(
                palestrante.getCpf())) {

            return false;
        }

        palestrantesPorCpf.put(palestrante.getCpf(), palestrante);

        return true;
    }

        public boolean cadastrarAtividade(Atividade atividade) {

        if (atividade == null) {
            throw new IllegalArgumentException(
                    "Atividade não pode ser nula.");
        }

        for (Atividade a : atividades) {

            if (a.getCodigo().equalsIgnoreCase(
                    atividade.getCodigo())) {

                return false;
            }
        }

        atividades.add(atividade);

        return true;
    }

    public Participante buscarParticipantePorMatricula(String matricula) {

        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException(
                    "Matrícula inválida.");
        }

        return participantesPorMatricula.get(matricula);
    }

    public Palestrante buscarPalestrantePorCpf(String cpf) {

        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException(
                    "CPF inválido.");
        }

        return palestrantesPorCpf.get(cpf);
    }

    public Atividade buscarAtividadePorCodigo(String codigo) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException(
                    "Código inválido.");
        }

        for (Atividade atividade : atividades) {

            if (atividade.getCodigo()
                    .equalsIgnoreCase(codigo)) {

                return atividade;
            }
        }

        return null;
    }

    public boolean inscreverParticipanteEmAtividade(String matricula, String codigoAtividade) {

        Participante participante = buscarParticipantePorMatricula(matricula);

        Atividade atividade = buscarAtividadePorCodigo(codigoAtividade);

        if (participante == null || atividade == null) {
            return false;
        }

        boolean inscrito = atividade.inscreverParticipante(participante);

        if (inscrito) {
            participante.adicionarAtividadeFrequentada(atividade);
        }

        return inscrito;
    }

    // Relatorios
    public void relatorioParticipantes() {

        System.out.println("\n=== PARTICIPANTES ===");

        for (Participante participante : participantesPorMatricula.values()) {

            System.out.println(participante);
        }
    }

    public void relatorioPalestrantes() {

        System.out.println("\n=== PALESTRANTES ===");

        for (Palestrante palestrante :
                palestrantesPorCpf.values()) {

            System.out.println(palestrante);
        }
    }

    public void relatorioAtividades() {

        System.out.println("\n=== ATIVIDADES ===");

        for (Atividade atividade : atividades) {

            System.out.println("Código: " + atividade.getCodigo());

            System.out.println("Título: " + atividade.getTitulo());

            System.out.println("Tipo: " + atividade.obterTipoAtividade());

            System.out.println("Vagas Disponíveis: " + atividade.obterVagasDisponiveis());

            System.out.println("Taxa de Ocupação: " + String.format(
                                    "%.2f%%",
                                    atividade.obterTaxaOcupacao()));
            System.out.println("------------------");
        }
    }

    public void relatorioParticipante(String matricula) {

        Participante participante =
                buscarParticipantePorMatricula(matricula);

        if (participante == null) {

            System.out.println(
                    "Participante não encontrado.");

            return;
        }

        System.out.println(participante);

        System.out.println(
                "\nHoras Totais: " +
                participante.calcularTotalHoras());

        System.out.println(
                "Gasto Total: R$ " +
                participante.calcularCustoTotal());

        System.out.println("\nAtividades:");

        for (Atividade atividade :
                participante.getAtividadesFrequentadas()) {

            System.out.println(
                    atividade.getTitulo());
        }
    }

    public double calcularFaturamentoTotal() {

        double faturamentoTotal = 0;

        for (Atividade atividade : atividades) {
            faturamentoTotal += atividade.calcularCusto()* atividade.getParticipantesInscritos().size();
        }

        return faturamentoTotal;
    }

    public double calcularTaxaMediaOcupacao() {

        if (atividades.isEmpty()) {
            return 0;
        }

        double soma = 0;

        for (Atividade atividade : atividades) {
            soma += atividade.obterTaxaOcupacao();
        }

        return soma / atividades.size();
    }

    public Atividade atividadeMaiorOcupacao() {

        if (atividades.isEmpty()) {
            return null;
        }

        Atividade maior = atividades.get(0);

        for (Atividade atividade : atividades) {

            if (atividade.obterTaxaOcupacao()
                    > maior.obterTaxaOcupacao()) {

                maior = atividade;
            }
        }

        return maior;
    }

    public Atividade atividadeMenorOcupacao() {

        if (atividades.isEmpty()) {
            return null;
        }

        Atividade menor = atividades.get(0);

        for (Atividade atividade : atividades) {

            if (atividade.obterTaxaOcupacao() < menor.obterTaxaOcupacao()) {
                menor = atividade;
            }
        }

        return menor;
    }

    public void relatorioEstatistico() {

        System.out.println("\n=== ESTATÍSTICAS ===");

        System.out.printf(
                "Faturamento Total: R$ %.2f%n",
                calcularFaturamentoTotal());

        System.out.printf(
                "Taxa Média de Ocupação: %.2f%%%n",
                calcularTaxaMediaOcupacao());

        Atividade maior = atividadeMaiorOcupacao();
        Atividade menor = atividadeMenorOcupacao();

        if (maior != null) {
            System.out.println("Maior Ocupação: " + maior.getTitulo());
        }

        if (menor != null) { 
            System.out.println("Menor Ocupação: " + menor.getTitulo());
        }
    }
}
