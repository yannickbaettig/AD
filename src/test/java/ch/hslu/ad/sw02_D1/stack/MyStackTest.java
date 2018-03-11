package ch.hslu.ad.sw02_D1.stack;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(MyStackTest.class);

    @Test
    public void testEmptyStack() {
        MyStack stack = new MyStack(5);
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testElementInStack() {
        MyStack stack = new MyStack(5);
        String string = "Hallo";
        stack.push(string);
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void testFullStack() {
        MyStack stack = new MyStack(1);
        String string = "Hallo";
        stack.push(string);
        int expected = 0;
        int actual = stack.getTop();

        assertEquals(expected, actual);
    }

    @Test
    public void testStack() {
        MyStack stack = new MyStack(3);
        String string = "toll";
        String string2 = "sind";
        String string3 = "Datenstrukturen";
        stack.push(string);
        stack.push(string2);
        stack.push(string3);
        LOG.info(stack.toString());
        LOG.info(stack.pop());
        LOG.info(stack.pop());
        LOG.info(stack.pop());

    }


    @Test(expected = StackFullException.class)
    public void testFullStackError() {
        MyStack stack = new MyStack(1);
        String string = "Hallo";
        stack.push(string);
        stack.push(string);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyStackError() {
        MyStack stack = new MyStack(1);
        String string = "Hallo";
        stack.push(string);
        stack.pop();
        stack.pop();
    }
}