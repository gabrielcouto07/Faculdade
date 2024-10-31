import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.print("Qual exercício você deseja rodar? (1 ou 2) ou digite 0 para sair:");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> Lista05Exe01.Lista05Exe01.main(args);
                case 2 -> Lista05Exe02.Lista05Exe02.main(args);
                case 0 -> {
                    System.out.println("Encerrando o programa...");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida. Escolha 1, 2 ou 0 para sair.");
            }
        }

        scanner.close();
    }
}
