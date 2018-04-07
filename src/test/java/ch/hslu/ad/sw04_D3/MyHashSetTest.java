package ch.hslu.ad.sw04_D3;

import ch.hslu.ad.sw03_D2.DuplicateElementException;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashSetTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(MyHashSetTest.class);
    MyHashSet myHashSet;
    Allocation allocation1;
    Allocation allocation1duplicate;
    Allocation allocation2;
    Allocation allocation3;
    Allocation allocation4;
    Allocation allocation5;


    @Before
    public void before(){
        myHashSet = new MyHashSet(10);
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


    @Test(expected = IndexOutOfBoundsException.class)
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
    }


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
        LOG.info(myHashSet.toString());
    }


}