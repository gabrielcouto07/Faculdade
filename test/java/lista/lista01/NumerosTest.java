package lista.lista01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumerosTest {

    @Test
    public void testMinimo() {
        Numeros numeros = new Numeros(10, 5, 8);
        assertEquals(5, numeros.minimo());
    }

    @Test
    public void testMaximo() {
        Numeros numeros = new Numeros(10, 5, 8);
        assertEquals(10, numeros.maximo());
    }
}
