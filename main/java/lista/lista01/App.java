package listas.lista01;

public class App {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(70, 1.75);
        System.out.println("IMC da pessoa: " + pessoa.calcularIMC());

        Retangulo retangulo = new Retangulo(5, 10);
        System.out.println("Área do retângulo: " + retangulo.calcularArea());
        System.out.println("Perímetro do retângulo: " + retangulo.calcularPerimetro());

        Nome nome = new Nome("Dr.", "João", "Silva", "Pereira");
        System.out.println("Nome completo: " + nome.getNomeCompleto());

        Nome nomeSemTitulo = new Nome(null, "João", null, "Pereira");
        System.out.println("Nome completo sem título: " + nomeSemTitulo.getNomeCompleto());

        Numeros numeros = new Numeros(10, 5, 8);
        System.out.println("Menor número: " + numeros.minimo());
        System.out.println("Maior número: " + numeros.maximo());

        Triangulo triangulo = new Triangulo(3, 4, 5, 6, 5);
        System.out.println("Área do triângulo: " + triangulo.calcularArea());
        System.out.println("Perímetro do triângulo: " + triangulo.calcularPerimetro());
        System.out.println("Tipo de triângulo: " + triangulo.obterTipo());

        Contribuinte contribuinteHomem = new Contribuinte(65, 'M', 20);
        System.out.println("Pode aposentar (homem)? " + contribuinteHomem.podeAposentar());

        Contribuinte contribuinteMulher = new Contribuinte(62, 'F', 15);
        System.out.println("Pode aposentar (mulher)? " + contribuinteMulher.podeAposentar());

        Aluno aluno = new Aluno(21, 19, 20);
        System.out.println("Pontuação final (sem AI): " + aluno.calcularPontuacaoFinal());
        System.out.println("Aprovação: " + aluno.verificarAprovacao());

        aluno.setAI(30);
        System.out.println("Pontuação final (com AI): " + aluno.calcularPontuacaoFinal());
        System.out.println("Aprovação após AI: " + aluno.verificarAprovacao());
    }
}
