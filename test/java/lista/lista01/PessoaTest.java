package lista.lista01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class PessoaTest {

    @Test
    public void calcularImcValido() {
        Pessoa pessoa = new Pessoa(80, 1.72);
        assertEquals(27.04, pessoa.calcularIMC(), 0.01);
    }

    @Test
    public void deveLancarExcecaoQuandoPesoForInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa(0, 1.72); // Peso inválido
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa(-80, 1.72); // Peso negativo
        });
    }

    @Test
    public void deveLancarExcecaoQuandoAlturaForInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa(80, 0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa(80, -1.72);
        });
    }
}
