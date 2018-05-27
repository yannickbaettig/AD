package ch.hslu.ad.sw10_A2;

import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FixedSizeHeapTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(FixedSizeHeapTest.class);
    private FixedSizeHeap heap;


    @Before
    public void before() {
        heap = new FixedSizeHeap(16);
    }

    @Test
    public void testInsert() {
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);
        heap.insert(12);
        heap.insert(7);
        heap.insert(50);
        LOG.info(heap.toString());
    }

    @Test
    public void testGetMax() {
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);
        heap.insert(12);
        heap.insert(7);
        heap.insert(50);
        LOG.info(heap.toString());
        LOG.info(Arrays.toString(heap.getHeap()));
        LOG.info(heap.getMax());
        LOG.info(Arrays.toString(heap.getHeap()));
        LOG.info(heap.toString());
        LOG.info(heap.getMax());
        LOG.info(Arrays.toString(heap.getHeap()));
        LOG.info(heap.toString());
        LOG.info(heap.getMax());
        LOG.info(Arrays.toString(heap.getHeap()));
        LOG.info(heap.toString());
    }

}