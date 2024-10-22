import java.util.ArrayList;
import java.util.List;

class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void emprestarLivro(String titulo) {
        Livro livro = buscarLivro(titulo);

        if (livro == null) {
            throw new LivroNaoEncontradoException("Livro '" + titulo + "' não foi encontrado na biblioteca.");
        }

        if (livro.getExemplaresDisponiveis() <= 0) {
            throw new LivroNaoDisponivelException(
                    "O livro '" + titulo + "' não está disponível para empréstimo no momento.");
        }

        livro.emprestar();
        System.out.println("Você emprestou o livro: " + titulo);
    }

    public void devolverLivro(String titulo) {
        Livro livro = buscarLivro(titulo);

        if (livro == null) {
            throw new LivroNaoEncontradoException("Livro '" + titulo + "' não foi encontrado na biblioteca.");
        }

        livro.devolver();
        System.out.println("Você devolveu o livro: " + titulo);
    }

    private Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
}
