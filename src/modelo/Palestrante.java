package modelo;

import java.time.LocalDate;

public class Palestrante extends Pessoa {
    private String titutalacao;
    private String areaEspecializacao;

    public Palestrante(String cpf, String nome, String email, LocalDate dataNasc, String titulacao, String areaEspecializacao) {
        super(cpf, nome, email, dataNasc);
    }

    public String getTitutalacao() {
        return titutalacao;
    }

    public void setTitutalacao(String titutalacao) {
        if (titutalacao == null || titutalacao.trim().isEmpty()) {
            throw new IllegalArgumentException("Titulação não pode ser vazio");
        }
        
        this.titutalacao = titutalacao;
    }

    public String getAreaEspecializacao() {
        return areaEspecializacao;
    }

    public void setAreaEspecializacao(String areaEspecializacao) {
        if (areaEspecializacao == null || areaEspecializacao.trim().isEmpty()) {
            throw new IllegalArgumentException("Especialização não pode ser vazio");
        }

        this.areaEspecializacao = areaEspecializacao;
    }

    @Override
    public String obterTipoPessoa() {
        return "Palestrante";
    }

    
}
