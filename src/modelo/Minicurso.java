package modelo;

public class Minicurso extends Atividade {
    private double custoMaterial;
    private double[] avaliacoes = new double[5];
    private int numAvaliacoes = 0;

    public Minicurso(String codigo, String titulo, int cargaHoraria, int capacidadeMaxima, Palestrante palestrante, double custoMaterial) {
        super(codigo, titulo, cargaHoraria, capacidadeMaxima, palestrante);

        this.custoMaterial = custoMaterial;
    }

    public void adicionarAvaliacao(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10");
        }

        if (numAvaliacoes >= 5) {
            throw new IllegalArgumentException("Limite de avaliações excedido");
        }

        avaliacoes[numAvaliacoes] = nota;
        numAvaliacoes++;
    }

    public double calcularMediaAvaliacoes() {
        if(numAvaliacoes == 0) {
            return 0;
        } 

        double soma = 0;

        for(int i = 0; i < numAvaliacoes; i++) {
            soma += avaliacoes[i];
        } 

        return soma / numAvaliacoes;
    }

    public double obterMaiorNota() {
        if (numAvaliacoes == 0) {
            return 0;
        } 

        double maior = avaliacoes[0];

        for(int i = 1; i < numAvaliacoes; i++) {
            if (avaliacoes[i] > maior) {
                maior = avaliacoes[i];
            }
        }

        return maior;
    }

    public double obterMenorNota() {
        if (numAvaliacoes == 0) {
            return 0;
        }

        double menor = avaliacoes[0];

        for(int i = 1; i < numAvaliacoes; i++) {
            if (avaliacoes[i] < menor) {
                menor = avaliacoes[i];
            }
        }

        return menor;
    }

    @Override
    public String obterTipoAtividade() {
        return "Minicurso";
    }

    @Override
    public double calcularCusto() {
        return custoMaterial;
    }
}

