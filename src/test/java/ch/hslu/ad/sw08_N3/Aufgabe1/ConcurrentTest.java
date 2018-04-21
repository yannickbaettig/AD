package ch.hslu.ad.sw08_N3.Aufgabe1;

import ch.hslu.ad.sw06_N2.Aufgabe3.*;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ConcurrentTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(ConcurrentTest.class);
    private LinkedBlockingDeque<Integer> buffer;
    private ExecutorService executor;

    @Before
    public void before(){
        buffer = new LinkedBlockingDeque();
        executor = Executors.newCachedThreadPool();
    }

    @Test
    public void testPut() throws InterruptedException {
        buffer.put(1);
        LOG.info(buffer.size());
    }

    @Test
    public void testGet() throws InterruptedException {
        buffer.put(4);
        Integer integer = buffer.poll();
        LOG.info(integer);
        LOG.info(buffer.size());
    }

    @Test
    public void testPushAndPop() throws InterruptedException {
        final Random random = new Random();
        final int nPros = 3;
        final Producer2[] producers = new Producer2[nPros];
        final int mCons = 2;
        final Consumer2[] consumers = new Consumer2[mCons];

        for (int i = 0; i < nPros; i++) {
            producers[i] = new Producer2(buffer, random.nextInt(10000));
            executor.execute(producers[i]);
        }
        for (int i = 0; i < mCons; i++) {
            consumers[i] = new Consumer2(buffer);
            executor.execute(consumers[i]);
        }
        /*executor.awaitTermination(3000, TimeUnit.MILLISECONDS);
        while (!executor.isShutdown()) {
            Thread.yield();
        }*/

        TimeUnit.MILLISECONDS.sleep(100);
        executor.shutdown();
        int sumPros = 0;
        for (int i = 0; i < nPros; i++) {
            LOG.info("Prod " + (char) (i + 65) + " = " + producers[i].getSum());
            sumPros += producers[i].getSum();
        }
        int sumCons = 0;
        for (int i = 0; i < mCons; i++) {
            LOG.info("Cons " + (char) (i + 65) + " = " + consumers[i].getSum());
            sumCons += consumers[i].getSum();
        }
        LOG.info(sumPros + " = " + sumCons);

        assertEquals(sumPros, sumCons);
    }

    @Test
    public void testPutAndGet() throws InterruptedException {
        final Random random = new Random();
        final int nPros = 3;
        final Producer[] producers = new Producer[nPros];
        final int mCons = 2;
        final Consumer[] consumers = new Consumer[mCons];

        for (int i = 0; i < nPros; i++) {
            producers[i] = new Producer(buffer, random.nextInt(10000));
            executor.execute(producers[i]);
        }
        for (int i = 0; i < mCons; i++) {
            consumers[i] = new Consumer(buffer);
            executor.execute(consumers[i]);
        }
        /*executor.awaitTermination(3000, TimeUnit.MILLISECONDS);
        while (!executor.isShutdown()) {
            Thread.yield();
        }*/

        TimeUnit.MILLISECONDS.sleep(100);
        executor.shutdown();
        int sumPros = 0;
        for (int i = 0; i < nPros; i++) {
            LOG.info("Prod " + (char) (i + 65) + " = " + producers[i].getSum());
            sumPros += producers[i].getSum();
        }
        int sumCons = 0;
        for (int i = 0; i < mCons; i++) {
            LOG.info("Cons " + (char) (i + 65) + " = " + consumers[i].getSum());
            sumCons += consumers[i].getSum();
        }
        LOG.info(sumPros + " = " + sumCons);

        assertEquals(sumPros, sumCons);
    }

}