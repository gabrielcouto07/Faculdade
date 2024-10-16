package lista.lista01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrianguloTest {

    @Test
    public void testCalcularArea() {
        Triangulo triangulo = new Triangulo(3, 4, 5, 6, 5);
        assertEquals(15, triangulo.calcularArea(), 0.01);
    }

    @Test
    public void testCalcularPerimetro() {
        Triangulo triangulo = new Triangulo(3, 4, 5, 6, 5);
        assertEquals(12, triangulo.calcularPerimetro(), 0.01);
    }

    @Test
    public void testObterTipoEquilatero() {
        Triangulo triangulo = new Triangulo(3, 3, 3, 6, 3);
        assertEquals("Equilátero", triangulo.obterTipo());
    }

    @Test
    public void testObterTipoIsosceles() {
        Triangulo triangulo = new Triangulo(3, 3, 4, 6, 3);
        assertEquals("Isósceles", triangulo.obterTipo());
    }

    @Test
    public void testObterTipoEscaleno() {
        Triangulo triangulo = new Triangulo(3, 4, 5, 6, 5);
        assertEquals("Escaleno", triangulo.obterTipo());
    }
}
