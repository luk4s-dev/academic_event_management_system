package modelo;

import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa {
    private String cpf;
    private String nome;
    private String email;
    private LocalDate dataNasc;
    
    
    public Pessoa() {

    }
    
    public Pessoa(String cpf, String nome, String email, LocalDate dataNasc) {
        this.cpf = cpf.trim();
        this.nome = nome.trim();
        this.email = email.trim();
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("Cpf não pode ser vazio");
        }
        this.cpf = cpf.trim();
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome.trim();
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }
        this.email = email.trim();
    }
    
    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    // Usa a biblioteca Period e LocalDate para localizar a idade entre duas datas, usando de base o ano de nascimento e a data atual
    public int calcularIdade() {
        return Period.between(dataNasc, LocalDate.now()).getYears();
    }
    
    public abstract String obterTipoPessoa();

    @Override
    public String toString() {
        return String.format(
            "%s (%s) - %s",
            nome,
            cpf,
            obterTipoPessoa()
        );
    }
}