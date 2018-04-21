package ch.hslu.ad.sw08_N3.Aufgabe3;

import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class CounterTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(CounterTest.class);
    private ExecutorService executor;

    @Before
    public void before(){
        executor = Executors.newFixedThreadPool(10);
    }

    @Test
    public void testSynchronizedCounter() throws InterruptedException {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        List<CounterTask> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new CounterTask(synchronizedCounter));
        }

        long startTime = System.currentTimeMillis();
        executor.invokeAll(tasks);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        LOG.info(elapsedTime);

        assertEquals(0,synchronizedCounter.get());
    }

    @Test
    public void testAtomicCounter() throws InterruptedException {
        AtomicCounter atomicCounter = new AtomicCounter();
        List<CounterTask> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new CounterTask(atomicCounter));
        }

        long startTime = System.currentTimeMillis();
        //List<Future<Integer>> futures =
        executor.invokeAll(tasks);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        LOG.info(elapsedTime);
        assertEquals(0, atomicCounter.get());
    }
}