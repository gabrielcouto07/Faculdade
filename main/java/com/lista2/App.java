package com.lista2;

import java.util.Scanner;
import main.java.com.lista2.Contribuinte;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coletando dados do contribuinte
        System.out.println("Digite a idade do contribuinte:");
        int idade = scanner.nextInt();

        System.out.println("Digite o sexo do contribuinte (M/F):");
        char sexo = scanner.next().toUpperCase().charAt(0);

        System.out.println("Digite o tempo de contribuição (em anos):");
        int tempoContribuicao = scanner.nextInt();

        System.out.println("Digite o tempo de contribuição sob condições precárias (em anos):");
        int tempoContribuicaoPrecarias = scanner.nextInt();

        Contribuinte contribuinte = new Contribuinte(idade, sexo, tempoContribuicao, tempoContribuicaoPrecarias);

        if (contribuinte.podeAposentar()) {
            System.out.println("O contribuinte pode se aposentar.");
        } else {
            System.out.println("O contribuinte ainda não pode se aposentar.");
        }

        scanner.close();
    }
}
