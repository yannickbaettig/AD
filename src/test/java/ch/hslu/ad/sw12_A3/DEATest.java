package ch.hslu.ad.sw12_A3;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class DEATest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(DEATest.class);


    @Test
    public void testLanguageTrue(){
        assertEquals(true,DEA.isWordLanguage("01110"));
    }

    @Test
    public void testLanguageTrue2(){
        assertEquals(true,DEA.isWordLanguage("0111010"));
    }

    @Test
    public void testLanguageTrue3(){
        assertEquals(true,DEA.isWordLanguage("0101110"));
    }

    @Test
    public void testLanguageFalse(){
        assertEquals(false,DEA.isWordLanguage("01101"));
    }

    @Test
    public void testLanguageFalse2(){
        assertEquals(false,DEA.isWordLanguage("10001"));
    }

    @Test
    public void testLanguageFalse3(){
        assertEquals(false,DEA.isWordLanguage("0110100"));
    }
}