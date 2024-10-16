package lista.lista01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NomeTest {

    @Test
    public void testGetNomeCompletoComTitulo() {
        Nome nome = new Nome("Dr.", "Pedro", "Nunes", "Oliveira");
        assertEquals("Dr. Pedro Nunes de Oliveira", nome.getNomeCompleto());
    }

    @Test
    public void testGetNomeCompletoSemTitulo() {
        Nome nome = new Nome(null, "Pedro", null, "Nunes");
        assertEquals("Pedro Nunes", nome.getNomeCompleto());
    }
}
