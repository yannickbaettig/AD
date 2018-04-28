package ch.hslu.ad.sw09_A1;

import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SortTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(SortTest.class);
    private Sort sort;
    private int max = 1000;
    private Integer[] arrayRandom = new Integer[max];
    private Integer[] arraySorted = new Integer[max];
    private Integer[] arrayInverted = new Integer[max];


    @Before
    public void before(){
        for (int i = 0; i < max; i++){
            arrayRandom[i] = (int) (Math.random() * max);
        }
        for (int i = 0; i < max; i++){
            arraySorted[i] = i;
        }
        for (int i = 0; i < max; i++){
            arrayInverted[i] = max - (i + 1);
        }
        sort = new Sort();
    }

    @Test
    public void testInsertionSort() {
        sort.insertionSort(arrayRandom);
        sort.insertionSort(arraySorted);
        sort.insertionSort(arrayInverted);
        LOG.info(Arrays.toString(arrayRandom));
        LOG.info(Arrays.toString(arraySorted));
        LOG.info(Arrays.toString(arrayInverted));
    }

    @Test
    public void testSelectionSort() {
        sort.selectionSort(arrayRandom);
        sort.selectionSort(arraySorted);
        sort.selectionSort(arrayInverted);
        LOG.info(Arrays.toString(arrayRandom));
        LOG.info(Arrays.toString(arraySorted));
        LOG.info(Arrays.toString(arrayInverted));

    }


    @Test
    public void testBublbeSort() {
        Integer[] a = {20,5,32,4,12,18,33};
        sort.bubbleSort(a);
        sort.bubbleSort(arrayRandom);
        sort.bubbleSort(arraySorted);
        sort.bubbleSort(arrayInverted);
        LOG.info(Arrays.toString(a));
        LOG.info(Arrays.toString(arrayRandom));
        LOG.info(Arrays.toString(arraySorted));
        LOG.info(Arrays.toString(arrayInverted));

    }

}