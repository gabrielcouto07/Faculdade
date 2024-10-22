package main.java.com.lista2;

public class Contribuinte {
    private int idade;
    private char sexo;
    private int tempoContribuicao;
    private int tempoContribuicaoPrecarias;

    public Contribuinte(int idade, char sexo, int tempoContribuicao, int tempoContribuicaoPrecarias) {
        this.idade = idade;
        this.sexo = sexo;
        this.tempoContribuicao = tempoContribuicao;
        this.tempoContribuicaoPrecarias = tempoContribuicaoPrecarias;
    }

    public boolean podeAposentar() {
        double tempoTotalContribuicao = tempoContribuicao + (tempoContribuicaoPrecarias * 1.1);

        if (sexo == 'F') {
            return idade >= 62 && tempoTotalContribuicao >= 15;
        } else if (sexo == 'M') {
            return idade >= 65 && tempoTotalContribuicao >= 20;
        }
        return false;
    }
}
