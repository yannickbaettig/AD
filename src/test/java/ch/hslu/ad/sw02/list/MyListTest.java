package ch.hslu.ad.sw02.list;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

public class MyListTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(MyListTest.class);

    @Test
    public void testAddFirst() {
        MyList<Allocation> myList = new MyList<>();
        Allocation allocation = new Allocation(10,1);
        Allocation allocation2 = new Allocation(20,2);
        Allocation allocation3 = new Allocation(5,3);

        myList.addFirst(allocation);
        myList.addFirst(allocation2);
        myList.addFirst(allocation3);

        LOG.info(myList.toString());
    }


    @Test
    public void testAddLast() {
        MyList<Allocation> myList = new MyList<>();
        Allocation allocation = new Allocation(10,1);
        Allocation allocation2 = new Allocation(20,2);
        Allocation allocation3 = new Allocation(5,3);

        myList.addLast(allocation);
        myList.addLast(allocation2);
        myList.addLast(allocation3);

        LOG.info(myList.toString());
    }

    @Test
    public void testAddAll() {
        MyList<Allocation> myList = new MyList<>();
        Allocation allocation = new Allocation(10,0);
        Allocation allocation2 = new Allocation(20,11);
        Allocation allocation3 = new Allocation(5,32);

        myList.addAllFirst(allocation, allocation2, allocation3);

        LOG.info(myList.toString());
    }

    @Test
    public void testRemoveFirst() {
        MyList<Allocation> myList = new MyList<>();
        Allocation allocation = new Allocation(10,0);
        Allocation allocation2 = new Allocation(20,11);
        Allocation allocation3 = new Allocation(5,32);

        myList.addAllFirst(allocation, allocation2, allocation3);

        myList.removeFirst();

        LOG.info(myList.toString());
    }

    @Test
    public void testGetElement() {
        MyList<Allocation> myList = new MyList<>();
        Allocation allocation = new Allocation(10,0);
        Allocation allocation2 = new Allocation(20,11);
        Allocation allocation3 = new Allocation(5,32);

        myList.addAllFirst(allocation, allocation2, allocation3);

        LOG.info(myList.getElement(allocation2));
    }


    @Test
    public void testRemoveElement() {
        MyList<Allocation> myList = new MyList<>();
        Allocation allocation = new Allocation(10,0);
        Allocation allocation2 = new Allocation(20,11);
        Allocation allocation3 = new Allocation(5,32);

        myList.addAllFirst(allocation, allocation2, allocation3);

        myList.removeElement(allocation2);

        LOG.info(myList.toString());
    }
}