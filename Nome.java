package lista.lista01;

public class Nome {
    private String titulo;
    private String nomePrincipal;
    private String nomeDoMeio;
    private String ultimoNome;

    public Nome(String titulo, String nomePrincipal, String nomeDoMeio, String ultimoNome) {
        this.titulo = titulo;
        this.nomePrincipal = nomePrincipal;
        this.nomeDoMeio = nomeDoMeio;
        this.ultimoNome = ultimoNome;
    }

    public String getNomeCompleto() {
        return (titulo != null ? titulo + " " : "") + nomePrincipal +
                (nomeDoMeio != null ? " " + nomeDoMeio : "") +
                " " + ultimoNome;
    }
}
