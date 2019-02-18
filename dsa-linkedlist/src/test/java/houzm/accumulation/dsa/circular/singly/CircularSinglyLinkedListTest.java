package houzm.accumulation.dsa.circular.singly;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * CircularSinglyLinkedList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>02/14/2019</pre>
 */
public class CircularSinglyLinkedListTest {
    CircularSinglyLinkedList<Integer> list = new CircularSinglyLinkedList<>();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testAddToLast() throws Exception {
        list.addToLast(1);
        list.addToLast(2);
        list.addToLast(3);
        list.addToLast(4);
        list.addToLast(5);
        list.addToLast(6);
        System.out.println(list);
    }

    @Test
    public void testAddToHead() throws Exception {
        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        list.addToHead(4);
        list.addToHead(5);
        list.addToHead(6);
        System.out.println(list);
    }


} 
