package lista.lista01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class RetanguloTest {

    @Test
    public void calculaArea() {
        Retangulo retangulo = new Retangulo(5, 10);
        assertEquals(50, retangulo.calculaArea(), 0.01);
    }

    @Test
    public void calculaPerimetro() {
        Retangulo retangulo = new Retangulo(5, 10);
        assertEquals(30, retangulo.calculaPerimetro(), 0.01);
    }

    @Test
    public void deveLancarExcecaoQuandoBaseInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Retangulo(0, 10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Retangulo(-5, 10);
        });
    }

    @Test
    public void deveLancarExcecaoQuandoAlturaInvalida() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Retangulo(5, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Retangulo(5, -10);
        });
    }
}
