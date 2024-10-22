public class Lista03Exe02 {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro(new Livro("Java para Iniciantes", "Autor A", 2));
        biblioteca.adicionarLivro(new Livro("Estruturas de Dados", "Autor B", 1));
        biblioteca.adicionarLivro(new Livro("Algoritmos Avançados", "Autor C", 0));

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o título do livro que deseja emprestar: ");
            String tituloEmprestimo = scanner.nextLine();
            biblioteca.emprestarLivro(tituloEmprestimo);

            System.out.print("Digite o título do livro que deseja devolver: ");
            String tituloDevolucao = scanner.nextLine();
            biblioteca.devolverLivro(tituloDevolucao);

        } catch (LivroNaoEncontradoException | LivroNaoDisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
