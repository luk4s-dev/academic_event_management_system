package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Participante extends Pessoa {
    private String matricula;
    private TipoParticipante tipo; // ENUM que vai forçar o atributo/variavel apenas a 3 valores fixos
    private List<Atividade> atividadesFrequentadas = new ArrayList<>(); // Lista que vai armazenar as atividades do Participante

    public Participante(
        String cpf, 
        String nome, 
        String email, 
        LocalDate dataNasc,
        String matricula,
        TipoParticipante tipo) {
            super(cpf, nome, email, dataNasc);
            setMatricula(matricula);
            this.tipo = tipo;
        }
        
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        if(matricula == null || matricula.trim().isEmpty()) {
            throw new IllegalArgumentException("Matrícula não pode ser vazia.");
        }

        if(!matricula.matches(
            "MAT\\d{3}"
        )) {
            throw new IllegalArgumentException(
                "Matrícula deve seguir o formato MAT001"
            );
        }

        this.matricula = matricula.trim();
    }
    
    public TipoParticipante getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoParticipante tipo) {
        this.tipo = tipo;
    }
    
    // Criado uma cópia da lista para proteger o historico original da lista
    public List<Atividade> getAtividadesFrequentadas() {
        return new ArrayList<>(atividadesFrequentadas);
    }

    @Override
    public String obterTipoPessoa() {
        return "Participante (" + tipo + ")";
    }

    public boolean adicionarAtividadeFrequentada(Atividade atividade) {
        if(atividade == null) {
            throw new IllegalArgumentException(
                "Atividade não pode ser nula."
            );
        }

        if(!atividadesFrequentadas.contains(atividade)) {
            atividadesFrequentadas.add(atividade);
            return true;
        }

        return false;
    }

    public void calcularTotalHoras() {}

    public void calcularCustoTotal() {}

}