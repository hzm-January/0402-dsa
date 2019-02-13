package houzm.accumulation.dsa.doubly.sentinelhead;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * DoublyLinkedList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>02/13/2019</pre>
 */
public class DoublyLinkedListTest {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    DoublyLinkedList<Integer> listPalindrome = new DoublyLinkedList<>();

    @Before
    public void before() throws Exception {
        list.addToLast(1);
        list.addToLast(2);
        list.addToLast(3);
        list.addToLast(4);
        list.addToLast(5);
        list.addToLast(6);
        listPalindrome.addToLast(1);
        listPalindrome.addToLast(2);
        listPalindrome.addToLast(3);
        listPalindrome.addToLast(3);
        listPalindrome.addToLast(2);
        listPalindrome.addToLast(1);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addToLast(T t)
     */
    @Test
    public void testAddToLast() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addToHead(T t)
     */
    @Test
    public void testAddToHead() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addAfter(Node node, T t)
     */
    @Test
    public void testAddAfter() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addBefore(Node node, T t)
     */
    @Test
    public void testAddBefore() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: removeLast()
     */
    @Test
    public void testRemoveLast() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: removeHead()
     */
    @Test
    public void testRemoveHead() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delNode(Node node)
     */
    @Test
    public void testDelNodeNode() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delNode(T t)
     */
    @Test
    public void testDelNodeT() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: isPalindrome()
     */
    @Test
    public void testIsPalindrome() throws Exception {
        Assert.assertEquals(true, listPalindrome.isPalindrome());
    }

    /**
     * Method: getData()
     */
    @Test
    public void testGetData() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setData(T data)
     */
    @Test
    public void testSetData() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getPrev()
     */
    @Test
    public void testGetPrev() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setPrev(Node prev)
     */
    @Test
    public void testSetPrev() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getNext()
     */
    @Test
    public void testGetNext() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setNext(Node next)
     */
    @Test
    public void testSetNext() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: compareLF(Node left, Node right)
     */
    @Test
    public void testCompareLF() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = DoublyLinkedList.getClass().getMethod("compareLF", Node.class, Node.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: inverse(Node node)
     */
    @Test
    public void testInverse() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = DoublyLinkedList.getClass().getMethod("inverse", Node.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
