package ch.hslu.ad.sw10_A2;

import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Sort2Test {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(Sort2Test.class);
    private char[] chars;
    private Sort2 sort2;


    @Before
    public void before() {
        sort2 = new Sort2();
        chars = sort2.randomChars(100000);
    }

    @Test
    public void testQuickSort() {
        long startTime = System.currentTimeMillis();
        sort2.quickSort(chars);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        LOG.info(elapsedTime);
        LOG.info(Arrays.toString(chars));
    }

    @Test
    public void testQuickInsertionSort() {
        long startTime = System.currentTimeMillis();
        sort2.quickInsertionSort(chars);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        LOG.info(elapsedTime);
        LOG.info(Arrays.toString(chars));
    }

}