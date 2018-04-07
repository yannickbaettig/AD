package ch.hslu.ad.sw04_D3.Aufgabe3;

import ch.hslu.ad.sw04_D3.Allocation;
import ch.hslu.ad.sw04_D3.MyHashSetTest;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class MyHashSetWithListTest {
        private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(ch.hslu.ad.sw04_D3.MyHashSetTest.class);
        HashSet<Allocation> hashSet = new HashSet<>(10);
        MyHashSetWithList myHashSet;
        Allocation allocation1;
        Allocation allocation1duplicate;
        Allocation allocation2;
        Allocation allocation3;
        Allocation allocation4;
        Allocation allocation5;


        @Before
        public void before(){
            myHashSet = new MyHashSetWithList(10);
            allocation1 = new Allocation(10,12);
            allocation1duplicate = new Allocation(50,22);
            allocation2 = new Allocation(10,23);
            allocation3 = new Allocation(10,34);
            allocation4 = new Allocation(10,45);
            allocation5 = new Allocation(10,56);


        }

        @Test
        public void testAdd() {
            myHashSet.add(allocation1);
            myHashSet.add(allocation2);
            myHashSet.add(allocation3);
            myHashSet.add(allocation4);
            myHashSet.add(allocation5);
            LOG.info(myHashSet.toString());
        }

        @Test
        public void testAddDuplicate() {
            myHashSet.add(allocation1);
            myHashSet.add(allocation2);
            myHashSet.add(allocation3);
            myHashSet.add(allocation4);
            myHashSet.add(allocation5);
            myHashSet.add(allocation1duplicate);
            LOG.info(myHashSet.toString());
        }


/*        @Test(expected = IndexOutOfBoundsException.class)
        public void testFullArray() {
            myHashSet.add(allocation1);
            myHashSet.add(allocation2);
            myHashSet.add(allocation3);
            myHashSet.add(allocation4);
            myHashSet.add(allocation5);
            myHashSet.add(allocation1);
            myHashSet.add(allocation2);
            myHashSet.add(allocation3);
            myHashSet.add(allocation4);
            myHashSet.add(allocation5);
            myHashSet.add(allocation1duplicate);
            LOG.info(myHashSet.toString());
        }*/


        @Test
        public void testRemove() {
            myHashSet.add(allocation1);
            myHashSet.add(allocation2);
            myHashSet.add(allocation1duplicate);
            myHashSet.add(allocation3);
            myHashSet.add(allocation4);
            myHashSet.add(allocation5);
            boolean expected = true;
            boolean actual = myHashSet.remove(allocation1duplicate);
            assertEquals(expected, actual);
            LOG.info(myHashSet.toString());
        }

    @Test
    public void testRemove2() {
        myHashSet.add(allocation1);
        myHashSet.add(allocation2);
        myHashSet.add(allocation1duplicate);
        myHashSet.add(allocation3);
        myHashSet.add(allocation4);
        myHashSet.add(allocation5);
        boolean expected = true;
        boolean actual = myHashSet.remove(allocation1);
        assertEquals(expected, actual);
        LOG.info(myHashSet.toString());
    }

        @Test
        public void testRemoveElementNotThere() {
            myHashSet.add(allocation1);
            myHashSet.add(allocation2);
            myHashSet.add(allocation3);
            myHashSet.add(allocation4);
            myHashSet.add(allocation5);
            boolean expected = false;
            boolean actual = myHashSet.remove(allocation1duplicate);
            assertEquals(expected, actual);
            LOG.info(myHashSet.toString());
        }

        @Test
        public void testSearch() {
            myHashSet.add(allocation1);
            myHashSet.add(allocation2);
            myHashSet.add(allocation1duplicate);
            myHashSet.add(allocation3);
            myHashSet.add(allocation4);
            myHashSet.add(allocation5);
            boolean expected = true;
            boolean actual = myHashSet.search(allocation1duplicate);
            assertEquals(expected, actual);
            LOG.info(myHashSet.toString());
        }

        @Test
        public void testRemoveAndSearch() {
            long time = System.currentTimeMillis();
            myHashSet.add(allocation1);
            myHashSet.add(allocation2);
            myHashSet.add(allocation1duplicate);
            myHashSet.add(allocation3);
            myHashSet.add(allocation4);
            myHashSet.add(allocation5);

            myHashSet.remove(allocation2);

            boolean expected = true;
            boolean actual = myHashSet.search(allocation1duplicate);
            assertEquals(expected, actual);
            LOG.info(System.currentTimeMillis() - time);
            LOG.info(myHashSet.toString());

        }


        @Test
        public void testPerformance(){
            long time = System.currentTimeMillis();
            hashSet.add(allocation1);
            hashSet.add(allocation2);
            hashSet.add(allocation1duplicate);
            hashSet.add(allocation3);
            hashSet.add(allocation4);
            hashSet.add(allocation5);

            hashSet.remove(allocation2);

            boolean expected = true;
            boolean actual = hashSet.contains(allocation1duplicate);
            assertEquals(expected, actual);
            LOG.info(System.currentTimeMillis() - time);
            LOG.info(hashSet.toString());
        }
    }