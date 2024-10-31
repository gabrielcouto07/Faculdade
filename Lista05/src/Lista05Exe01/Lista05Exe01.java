package Lista05Exe01;

import Lista05Exe01.movimentos.MovimentoEmL;
import Lista05Exe01.pecas.Bispo;
import Lista05Exe01.pecas.Cavalo;
import Lista05Exe01.pecas.Peao;
import Lista05Exe01.pecas.Peca;

public class Lista05Exe01 {
    public static void main(String[] args) {
        // Criando peças com seus movimentos padrões
        Peca knight = new Cavalo(); // Movimento em L
        Peca pawn = new Peao(); // Movimento para frente
        Peca bishop = new Bispo(); // Movimento diagonal

        // Movimentando cada peça usando seu movimento padrão
        System.out.println("Cavalo move:");
        knight.mover(); // Saída: Movendo em L

        System.out.println("\nPeao move:");
        pawn.mover(); // Saída: Movendo para frente

        System.out.println("\nBispo move:");
        bishop.mover(); // Saída: Movendo na diagonal

        // Alterando a estratégia de movimento do peão para movimento em L
        System.out.println("\nMudando a estratégia de movimento do peão para formato L:");
        pawn.setMovimento(new MovimentoEmL());
        pawn.mover(); // Saída: Movendo em L
    }
}
