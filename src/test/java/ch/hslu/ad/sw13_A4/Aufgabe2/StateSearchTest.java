package ch.hslu.ad.sw13_A4.Aufgabe2;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class StateSearchTest {

    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(StateSearchTest.class);


    @Test
    public void testSearchTrue(){
        int actual = StateSearch.stateSearch("NNNAANNSSANANASSSNN");
        LOG.info(actual);
        assertNotEquals(-1,actual);
    }

    @Test
    public void testSearchFalse(){
        int actual = StateSearch.stateSearch("NSANSNANSNANSNANSNANSNSN");
        LOG.info(actual);
        assertEquals(-1,actual);
    }

}