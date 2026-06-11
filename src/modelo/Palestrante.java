package modelo;

import java.time.LocalDate;

public class Palestrante extends Pessoa {
    private String titulacao;
    private String areaEspecializacao;

    public Palestrante(String cpf, String nome, String email, LocalDate dataNasc, String titulacao, String areaEspecializacao) {
        super(cpf, nome, email, dataNasc);

        this.titulacao = titulacao;
        this.areaEspecializacao = areaEspecializacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        if (titulacao == null || titulacao.trim().isEmpty()) {
            throw new IllegalArgumentException("Titulação não pode ser vazio");
        }
        
        this.titulacao = titulacao;
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
