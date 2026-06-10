package modelo;

import java.util.HashSet;
import java.util.Set;

public abstract class Atividade {
    private String codigo;
    private String titulo;
    private int cargaHoraria;
    private int capacidadeMaxima;
    private Palestrante palestrante;  
    private Set<Participante> participantesInscritos = new HashSet<>();
    
    public Atividade(String codigo, String titulo, int cargaHoraria, int capacidadeMaxima, Palestrante palestrante) {
        setCodigo(codigo);
        setTitulo(titulo);

        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("Carga horária inválida");
        }

        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("Capacidade Máxima inválida");
        }

        this.cargaHoraria = cargaHoraria;
        this.capacidadeMaxima = capacidadeMaxima;
        this.palestrante = palestrante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Codigo não pode ser vazio");
        }

        this.codigo = codigo.trim();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Titulo não pode ser vazio");
        }

        this.titulo = titulo.trim();
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public Palestrante getPalestrante() {
        return palestrante;
    }

    public Set<Participante> getParticipantesInscritos() {
        return participantesInscritos;
    }


    public abstract int calcularCusto();

    public abstract String obterTipoAtividade();

    public boolean inscreverParticipantes(Participante participante) {
        if (participante == null) {
            throw new IllegalArgumentException("Participante não pode ser nulo");
        }

        if (participantesInscritos.size() >= capacidadeMaxima) {
            return false; // atividade lotada
        }

        return participantesInscritos.add(participante);
        
    }

    public int obterVagasDisponiveis() {
       return capacidadeMaxima - participantesInscritos.size();
    }

    public double obterTaxaOcupacao() {
        return ((double) participantesInscritos.size() / capacidadeMaxima) * 100;
    }
}
