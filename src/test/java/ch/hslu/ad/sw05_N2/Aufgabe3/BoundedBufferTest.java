package ch.hslu.ad.sw05_N2.Aufgabe3;

import ch.hslu.ad.sw02_D1.list.Allocation;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class BoundedBufferTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BoundedBuffer.class);
    BoundedBuffer<Integer> myBoundedBuffer;


    @Before
    public void before(){
        myBoundedBuffer = new BoundedBuffer(10);
    }

    @Test
    public void testPut() throws InterruptedException {
        myBoundedBuffer.put(1, 2000);
        LOG.info(myBoundedBuffer.size());
    }

    @Test
    public void testGet() throws InterruptedException {
        myBoundedBuffer.put(4, 2000);
        Integer integer = myBoundedBuffer.get();
        LOG.info(integer);
        LOG.info(myBoundedBuffer.size());
    }

    @Test
    public void testPushAndPop() throws InterruptedException {
        final Random random = new Random();
        final int nPros = 3;
        final Producer2[] producers = new Producer2[nPros];
        final ThreadGroup prosGroup = new ThreadGroup("Producer-Threads");
        final int mCons = 2;
        final Consumer2[] consumers = new Consumer2[mCons];
        final ThreadGroup consGroup = new ThreadGroup("Consumer-Threads");
        final BoundedBuffer<Integer> queue = new BoundedBuffer<>(50);
        for (int i = 0; i < nPros; i++) {
            producers[i] = new Producer2(queue, random.nextInt(10000));
            new Thread(prosGroup, producers[i], "Prod  " + (char) (i + 65)).start();
        }
        for (int i = 0; i < mCons; i++) {
            consumers[i] = new Consumer2(queue);
            new Thread(consGroup, consumers[i], "Cons " + (char) (i + 65)).start();
        }
        while (prosGroup.activeCount() > 0) {
            Thread.yield();
        }
        TimeUnit.MILLISECONDS.sleep(100);
        consGroup.interrupt();
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
        final ThreadGroup prosGroup = new ThreadGroup("Producer-Threads");
        final int mCons = 2;
        final Consumer[] consumers = new Consumer[mCons];
        final ThreadGroup consGroup = new ThreadGroup("Consumer-Threads");
        final BoundedBuffer<Integer> queue = new BoundedBuffer<>(50);
        for (int i = 0; i < nPros; i++) {
            producers[i] = new Producer(queue, random.nextInt(10000));
            new Thread(prosGroup, producers[i], "Prod  " + (char) (i + 65)).start();
        }
        for (int i = 0; i < mCons; i++) {
            consumers[i] = new Consumer(queue);
            new Thread(consGroup, consumers[i], "Cons " + (char) (i + 65)).start();
        }
        while (prosGroup.activeCount() > 0) {
            Thread.yield();
        }
        TimeUnit.MILLISECONDS.sleep(100);
        consGroup.interrupt();
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