package lista.lista01;

public class Aluno {
    private int A1;
    private int A2;
    private int A3;
    private int AI = -1;

    public Aluno(int A1, int A2, int A3) {
        if (A1 < 0 || A1 > 30 || A2 < 0 || A2 > 30 || A3 < 0 || A3 > 40) {
            throw new IllegalArgumentException("Notas de A1, A2 devem ser entre 0 e 30, e A3 entre 0 e 40.");
        }
        this.A1 = A1;
        this.A2 = A2;
        this.A3 = A3;
    }

    public void setAI(int AI) {
        if (AI < 0 || AI > 30) {
            throw new IllegalArgumentException("Nota da AI deve ser entre 0 e 30.");
        }
        this.AI = AI;
    }

    public int calcularPontuacaoFinal() {
        if (AI > -1) {
            if (AI > A1 && AI <= A2) {
                return AI + A2 + A3;
            } else if (AI > A2 && AI <= A1) {
                return A1 + AI + A3;
            } else if (AI > A1 && AI > A2) {
                return AI + A2 + A3;
            }
        }
        return A1 + A2 + A3;
    }

    public int verificarAprovacao() {
        int total = calcularPontuacaoFinal();
        if (total >= 70) {
            if (AI == -1) {
                return 1; // Aprovado sem AI
            } else {
                return 2; // Aprovado com AI
            }
        } else {
            return 3; // Reprovado
        }
    }
}
