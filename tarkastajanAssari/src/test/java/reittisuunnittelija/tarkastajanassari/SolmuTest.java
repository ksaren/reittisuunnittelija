/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reittisuunnittelija.tarkastajanassari;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kaisa
 */
public class SolmuTest {

    Solmu testiSolmu;

    /**
     * Testaa konstruktorin kun vääriä koordinaatteja.
     *
     */
    @Test
    public void testKonstruktoriOlettaaXn() {
    testiSolmu = new Solmu("A",1,-500,600);
    assertEquals(testiSolmu.getX(),200,2);
    }
    
    @Test
    public void testKonstruktoriOlettaaYn() {
    testiSolmu = new Solmu("B",2,-500,600);
    assertEquals(testiSolmu.getY(),100,2);
    }
    
    @Before
    public void setUp() {
        testiSolmu = new Solmu("C",3,60.00, 23.50);
    }

    @After
    public void tearDown() {
    }

    /**
     * Testaa setX-metodia arvolla 0.
     */
    @Test
    public void testSetX_0() {
        assertTrue(testiSolmu.setX(0));
    }

    /**
     * Testaa setX-metodia liian isolla arvolla.
     */
    @Test
    public void testSetX_max() {
        assertFalse(testiSolmu.setX(Double.MAX_VALUE));
    }

    /**
     * Testaa setX-metodia liian isolla arvolla.
     */
    @Test
    public void testSetX_pieni() {
        assertFalse(testiSolmu.setX(-200.00));
    }

    /**
     * Testaa setX-metodia arvolla 100.
     */
    @Test
    public void testSetX_sata() {
        assertTrue(testiSolmu.setX(100));
    }

    /**
     * Testaa setY-metodia arvolla 0.
     */
    @Test
    public void testSetY_0() {
        assertTrue(testiSolmu.setY(0));
    }

    /**
     * Testaa setY-metodia liian isolla arvolla.
     */
    @Test
    public void testSetY_max() {
        assertFalse(testiSolmu.setY(Double.MAX_VALUE));
    }

    /**
     * Testaa setY-metodia liian isolla arvolla.
     */
    @Test
    public void testSetY_pieni() {
        assertFalse(testiSolmu.setY(-10000.00));
    }

    /**
     * Testaa setY-metodia arvolla 100.
     */
    @Test
    public void testSetY_sata() {
        assertFalse(testiSolmu.setY(100));
    }

}
