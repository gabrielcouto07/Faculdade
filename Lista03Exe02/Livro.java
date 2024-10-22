public class Livro {
    private String titulo;
    private String autor;
    private int exemplaresDisponiveis;

    public Livro(String titulo, String autor, int exemplaresDisponiveis) {
        this.titulo = titulo;
        this.autor = autor;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void emprestar() {
        if (exemplaresDisponiveis > 0) {
            exemplaresDisponiveis--;
        }
    }

    public void devolver() {
        exemplaresDisponiveis++;
    }
}

class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

class LivroNaoDisponivelException extends RuntimeException {
    public LivroNaoDisponivelException(String mensagem) {
        super(mensagem);
    }
}
