package ch.hslu.ad.sw13_A4.Aufgabe5;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuicksearchTest {

    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(QuicksearchTest.class);


    @Test
    public void testQuickSearchTrue(){
        int actual = Quicksearch.quickSearch("NNNAANNSSANANASSSNN", "ANANAS");
        LOG.info(actual);
        assertNotEquals(-1,actual);
    }

    @Test
    public void testQuickSearchTrue2(){
        int actual = Quicksearch.quickSearch("EISEIEISSSBBBBEIEISBEINSII", "EISBEIN");
        LOG.info(actual);
        assertNotEquals(-1,actual);
    }

    @Test
    public void testQuickSearchFalse(){
        int actual = Quicksearch.quickSearch("EISEIEISSSBBBBEIEISEINSII", "EISBEIN");
        LOG.info(actual);
        assertEquals(-1,actual);
    }


    @Test
    public void testOptimalMismatchTrue(){
        int actual = Quicksearch.optimalMismatch("NNNAANNSSANANASSSNN", "ANANAS");
        LOG.info(actual);
        assertNotEquals(-1,actual);
    }

    @Test
    public void testOptimalMismatchTrue2(){
        int actual = Quicksearch.optimalMismatch("EISEIEISSSBBBBEIEISBEINSII", "EISBEIN");
        LOG.info(actual);
        assertNotEquals(-1,actual);
    }


    @Test
    public void testOptimalMismatchTrue3(){
        int actual = Quicksearch.optimalMismatch("NNNNSSANANASN", "ANANAS");
        LOG.info(actual);
        assertNotEquals(-1,actual);
    }

    @Test
    public void testOptimalMismatchFalse(){
        int actual = Quicksearch.optimalMismatch("EISEIEISSSBBBBEIEISEINSII", "EISBEIN");
        LOG.info(actual);
        assertEquals(-1,actual);
    }

}