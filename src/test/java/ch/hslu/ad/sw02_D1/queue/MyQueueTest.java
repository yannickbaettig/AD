package ch.hslu.ad.sw02_D1.queue;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(MyQueueTest.class);

    @Test
    public void testEmptyQueue() {
        MyQueue<Character> myQueue = new MyQueue<>(8);
        assertEquals(true, myQueue.isEmpty() );
    }

    @Test
    public void testEnqueue() {
        MyQueue<Character> myQueue = new MyQueue<>(8);
        myQueue.enqueue('a');
        assertEquals(false, myQueue.isEmpty() );
        LOG.info(myQueue.toString());
    }

    @Test
    public void testDequeue() {
        MyQueue<Character> myQueue = new MyQueue<>(8);
        myQueue.enqueue('a');
        myQueue.dequeue();
        assertEquals(true, myQueue.isEmpty() );
        LOG.info(myQueue.toString());

    }


    @Test
    public void testQueue() {
        MyQueue<Character> myQueue = new MyQueue<>(8);
        myQueue.enqueue('a');
        myQueue.enqueue('b');
        myQueue.enqueue('c');
        myQueue.enqueue('d');
        myQueue.enqueue('e');
        myQueue.enqueue('f');
        myQueue.enqueue('g');
        myQueue.enqueue('h');
        LOG.info(myQueue.toString());
        LOG.info(myQueue.dequeue());
        LOG.info(myQueue.toString());
        myQueue.enqueue('i');
        LOG.info(myQueue.toString());
        LOG.info(myQueue.dequeue());
        LOG.info(myQueue.toString());
        LOG.info(myQueue.dequeue());
        LOG.info(myQueue.toString());
        LOG.info(myQueue.toString());
        myQueue.enqueue('j');
        LOG.info(myQueue.toString());
        myQueue.enqueue('k');
        LOG.info(myQueue.toString());
        char d = myQueue.dequeue();
        assertEquals('d', d);
    }

}