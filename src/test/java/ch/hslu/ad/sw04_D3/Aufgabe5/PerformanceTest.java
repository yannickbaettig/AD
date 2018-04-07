package ch.hslu.ad.sw04_D3.Aufgabe5;

import ch.hslu.ad.sw02_D1.stack.MyStack;
import ch.hslu.ad.sw04_D3.Allocation;
import ch.hslu.ad.sw04_D3.Aufgabe3.MyHashSetWithList;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class PerformanceTest {
        private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(ch.hslu.ad.sw04_D3.MyHashSetTest.class);
        Stack<Allocation> stack;
        MyStack<Allocation> myStack;
        Deque<Allocation> deque;
        Allocation[] allocations;


        @Before
        public void before(){
            allocations = ArrayMaker.arrayWithSize(100000);
            stack = new Stack<>();
            myStack = new MyStack<>(100000);
            stack.setSize(100000);
            deque = new ArrayDeque<>(100000);


        }

        @Test
        public void testStack() {
            long time = System.currentTimeMillis();
            for (Allocation allocation : allocations){
                stack.push(allocation);
            }
            LOG.info(System.currentTimeMillis() - time);
        }

    @Test
    public void testMyStack() {
        long time = System.currentTimeMillis();
        for (Allocation allocation : allocations){
            myStack.push(allocation);
        }
        LOG.info(System.currentTimeMillis() - time);
    }

    @Test
    public void testDeque() {
            long time = System.currentTimeMillis();
            Collections.addAll(deque, allocations);
            LOG.info(System.currentTimeMillis() - time);
    }

}
