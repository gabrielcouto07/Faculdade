package lista.lista01;

public class Contribuinte {
    private int idade;
    private char sexo;
    private int tempoContribuicao;

    public Contribuinte(int idade, char sexo, int tempoContribuicao) {
        if (idade <= 0 || tempoContribuicao <= 0) {
            throw new IllegalArgumentException("Idade e tempo de contribuição devem ser positivos.");
        }
        if (tempoContribuicao >= idade) {
            throw new IllegalArgumentException("Tempo de contribuição não pode ser maior ou igual à idade.");
        }
        if (sexo != 'M' && sexo != 'F') {
            throw new IllegalArgumentException("Sexo deve ser 'M' ou 'F'.");
        }
        this.idade = idade;
        this.sexo = sexo;
        this.tempoContribuicao = tempoContribuicao;
    }

    public boolean podeAposentar() {
        if (sexo == 'F') {
            return idade >= 62 && tempoContribuicao >= 15;
        } else if (sexo == 'M') {
            return idade >= 65 && tempoContribuicao >= 20;
        }
        return false;
    }
}
