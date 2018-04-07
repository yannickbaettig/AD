package ch.hslu.ad.sw03_D2;

import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyTreeTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(MyTreeTest.class);
    private MyTree<String> myTree;
    @Before
    public void before(){
        myTree = new MyTree<>();
        myTree.add("G");
        myTree.add("H");
        myTree.add("B");
        myTree.add("F");
        myTree.add("E");
        myTree.add("A");
        myTree.add("D");
        myTree.add("C");
        LOG.info(myTree.getSize());
    }

    @Test
    public void testSearch() {
       String actual =  myTree.search("F");
       String expected = "F";
       assertEquals(expected, actual);
    }

    @Test(expected = DuplicateElementException.class)
    public void testAddDuplicate() {
        myTree.add("F");
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
        myTree.remove("A");
        myTree.inOrderTraversal(myTree.getRoot());
        LOG.info(myTree.getSize());
    }

    @Test
    public void testRemoveOneChild() {
       myTree.remove("E");
       myTree.inOrderTraversal(myTree.getRoot());
       LOG.info(myTree.getSize());
    }

    @Test
    public void testRemoveTwoChilds() {
        myTree.remove("B");
        myTree.inOrderTraversal(myTree.getRoot());
        LOG.info(myTree.getSize());
    }

}