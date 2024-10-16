package lista.lista01;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ContribuinteTest {

    @Test
    public void testPodeAposentarMulher() {
        Contribuinte contribuinte = new Contribuinte(62, 'F', 15);
        assertTrue(contribuinte.podeAposentar());
    }

    @Test
    public void testNaoPodeAposentarMulher() {
        Contribuinte contribuinte = new Contribuinte(60, 'F', 10);
        assertFalse(contribuinte.podeAposentar());
    }

    @Test
    public void testPodeAposentarHomem() {
        Contribuinte contribuinte = new Contribuinte(65, 'M', 20);
        assertTrue(contribuinte.podeAposentar());
    }

    @Test
    public void testNaoPodeAposentarHomem() {
        Contribuinte contribuinte = new Contribuinte(64, 'M', 18);
        assertFalse(contribuinte.podeAposentar());
    }

    @Test
    public void testSexoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contribuinte(65, 'X', 20);
        });
    }

    @Test
    public void testIdadeOuTempoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contribuinte(0, 'M', 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contribuinte(65, 'M', -5);
        });
    }

    @Test
    public void testTempoContribuicaoMaiorQueIdade() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contribuinte(30, 'M', 30);
        });
    }
}
