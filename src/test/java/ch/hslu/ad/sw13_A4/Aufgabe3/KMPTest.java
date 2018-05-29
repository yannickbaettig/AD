package ch.hslu.ad.sw13_A4.Aufgabe3;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class KMPTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(KMPTest.class);


    @Test
    public void testSearchTrue(){
        int actual = KMP.kmpSearch("NNNAANNSSANANASSSNN", "ANANAS");
        LOG.info(actual);
        assertNotEquals(-1,actual);
    }

    @Test
    public void testSearchTrue2(){
        int actual = KMP.kmpSearch("EISEIEISSSBBBBEIEISBEINSII", "EISBEIN");
        LOG.info(actual);
        assertNotEquals(-1,actual);
    }


    @Test
    public void testSearchFalse(){
        int actual = KMP.kmpSearch("EISEIEISSSBBBBEIEISEINSII", "EISBEIN");
        LOG.info(actual);
        assertEquals(-1,actual);
    }
}