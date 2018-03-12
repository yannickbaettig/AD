package ch.hslu.ad.sw03_D1.Hashcode;

import ch.hslu.ad.sw03_D1.DuplicateElementException;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashTreeTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(MyHashTreeTest.class);
    private MyHashTree<Integer, String> myTree;
    @Before
    public void before(){
        myTree = new MyHashTree<>();
        myTree.add(5,"G");
        myTree.add(6,"H");
        myTree.add(8,"B");
        myTree.add(3,"F");
        myTree.add(1,"E");
        myTree.add(4,"A");
        myTree.add(2,"D");
        myTree.add(7,"C");
        LOG.info(myTree.getSize());
    }

    @Test
    public void testSearch() {
        String actual =  myTree.search(3);
        String expected = "F";
        assertEquals(expected, actual);
    }

    @Test(expected = DuplicateElementException.class)
    public void testAddDuplicate() {
        myTree.add(3, "F");
        LOG.info(myTree.getSize());
    }


    @Test
    public void testInOrderTraversal() {
        myTree.inOrderTraversal(myTree.getRoot());
    }

    @Test
    public void testPreOrderTraversal() {
        myTree.preOrderTraversal(myTree.getRoot());
    }

    @Test
    public void testPostOrderTraversal() {
        myTree.postOrderTraversal(myTree.getRoot());
    }

    @Test
    public void testRemoveNoChild() {
        myTree.remove(4);
        myTree.inOrderTraversal(myTree.getRoot());
        LOG.info(myTree.getSize());
    }

    @Test
    public void testRemoveOneChild() {
        myTree.remove(1);
        myTree.inOrderTraversal(myTree.getRoot());
        LOG.info(myTree.getSize());
    }

    @Test
    public void testRemoveTwoChilds() {
        myTree.remove(2);
        myTree.inOrderTraversal(myTree.getRoot());
        LOG.info(myTree.getSize());
    }


}