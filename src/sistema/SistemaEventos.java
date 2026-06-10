package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Atividade;
import modelo.Palestrante;
import modelo.Participante;

public class SistemaEventos {
    private Map<String, Participante> participantesPorMatricula = new HashMap<>();
    private Map<String, Palestrante> palestrantesPorCpf = new HashMap<>();
    private List<Atividade> atividades = new ArrayList<>();
    private String[] diasFuncionamento;

    public SistemaEventos() {
        diasFuncionamento = new String[] {
            "Segunda",
            "Terça",
            "Quarta",
            "Quinta",
            "Sexta"
        };
    }
}
