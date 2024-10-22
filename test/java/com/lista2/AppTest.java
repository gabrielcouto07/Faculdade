package com.lista2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.com.lista2.Contribuinte;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testMulherPodeAposentarSemCondicoesPrecarias() {
        Contribuinte contribuinte = new Contribuinte(62, 'F', 15, 0);
        assertTrue(contribuinte.podeAposentar());
    }

    @Test
    public void testHomemPodeAposentarSemCondicoesPrecarias() {
        Contribuinte contribuinte = new Contribuinte(65, 'M', 20, 0);
        assertTrue(contribuinte.podeAposentar());
    }

    @Test
    public void testMulherPodeAposentarComCondicoesPrecarias() {
        Contribuinte contribuinte = new Contribuinte(62, 'F', 14, 1);
        assertTrue(contribuinte.podeAposentar()); // 14 + 1.1 = 15.1
    }

    @Test
    public void testHomemNaoPodeAposentar() {
        Contribuinte contribuinte = new Contribuinte(64, 'M', 19, 0);
        assertFalse(contribuinte.podeAposentar());
    }

    @Test
    public void testHomemPodeAposentarComCondicoesPrecarias() {
        Contribuinte contribuinte = new Contribuinte(65, 'M', 18, 2);
        assertTrue(contribuinte.podeAposentar()); // 18 + (2 * 1.1) = 20.2
    }
}
