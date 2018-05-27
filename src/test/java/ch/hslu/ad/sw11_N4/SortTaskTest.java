package ch.hslu.ad.sw11_N4;

import ch.hslu.ad.sw11_N4.Aufgabe1.SortTask;
import ch.hslu.ad.sw11_N4.Aufgabe2.ParallelQuickSort;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class SortTaskTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(SortTaskTest.class);
    private int max = 10000;
    private int[] arrayRandom = new int[max];

    @Before
    public void before(){
        for (int i = 0; i < max; i++){
            arrayRandom[i] = (int) (Math.random() * max);
        }
    }

    @Test
    public void testMergeSort() {
        final ForkJoinPool pool = new ForkJoinPool();
        SortTask sort = new SortTask(arrayRandom);
        pool.invoke(sort);
        LOG.info(Arrays.toString(arrayRandom));

    }


    @Test
    public void testQuickSort() {
        final ForkJoinPool pool = new ForkJoinPool();
        ParallelQuickSort sort = new ParallelQuickSort(arrayRandom);
        pool.invoke(sort);
        LOG.info(Arrays.toString(arrayRandom));

    }

}