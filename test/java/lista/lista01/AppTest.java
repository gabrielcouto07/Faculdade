package lista.lista01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {

    @Test
    public void testPessoaIMC() {
        Pessoa pessoa = new Pessoa(80, 1.72);
        assertEquals(27.04, pessoa.calcularIMC(), 0.01);
    }

    @Test
    public void testPessoaPesoAlturaInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa(0, 1.72);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa(-80, 1.72);
        });
    }

    @Test
    public void testRetanguloAreaEPerimetro() {
        Retangulo retangulo = new Retangulo(5, 10);
        assertEquals(50, retangulo.calculaArea(), 0.01);
        assertEquals(30, retangulo.calculaPerimetro(), 0.01);
    }

    @Test
    public void testRetanguloBaseAlturaInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Retangulo(0, 10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Retangulo(-5, 10);
        });
    }

    @Test
    public void testContribuintePodeAposentar() {
        Contribuinte contribuinteHomem = new Contribuinte(65, 'M', 20);
        assertTrue(contribuinteHomem.podeAposentar());

        Contribuinte contribuinteMulher = new Contribuinte(62, 'F', 15);
        assertTrue(contribuinteMulher.podeAposentar());
    }

    @Test
    public void testContribuinteIdadeOuTempoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contribuinte(0, 'M', 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contribuinte(65, 'M', -5);
        });
    }

    @Test
    public void testAlunoValidacoes() {
        Aluno aluno = new Aluno(20, 20, 30);
        assertEquals(70, aluno.calcularPontuacaoFinal());

        assertThrows(IllegalArgumentException.class, () -> {
            new Aluno(31, 20, 30); // A1 inválida
        });
        assertThrows(IllegalArgumentException.class, () -> {
            aluno.setAI(35); // AI inválida
        });
    }
}
