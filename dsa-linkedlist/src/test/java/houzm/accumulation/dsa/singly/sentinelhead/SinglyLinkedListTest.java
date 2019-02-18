package houzm.accumulation.dsa.singly.sentinelhead;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * SinglyLinkedList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>02/14/2019</pre>
 */
public class SinglyLinkedListTest {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    SinglyLinkedList<Integer> listPalindrome = new SinglyLinkedList<>();

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
        System.out.println(list);
        System.out.println(listPalindrome);
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
     * Method: addBefore(Node node, T t)
     */
    @Test
    public void testAddBefore() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteLast()
     */
    @Test
    public void testDeleteLast() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteFirst()
     */
    @Test
    public void testDeleteFirst() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteByNode(Node node)
     */
    @Test
    public void testDeleteByNode() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteByValue(T t)
     */
    @Test
    public void testDeleteByValue() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: palindrome()
     */
    @Test
    public void testPalindrome() throws Exception {
        Assert.assertEquals(true, listPalindrome.palindrome());
    }

    /**
     * Method: inverse(Node p)
     */
    @Test
    public void testInverseP() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: inverse()
     */
    @Test
    public void testInverse() throws Exception {
//TODO: Test goes here... 
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
     * Method: deleteOnlyHead()
     */
    @Test
    public void testDeleteOnlyHead() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = SinglyLinkedList.getClass().getMethod("deleteOnlyHead"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: addAfter(Node node, Node newNode)
     */
    @Test
    public void testAddAfter() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = SinglyLinkedList.getClass().getMethod("addAfter", Node.class, Node.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: linkLast(T t)
     */
    @Test
    public void testLinkLast() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = SinglyLinkedList.getClass().getMethod("linkLast", T.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: compareLF(Node left, Node right)
     */
    @Test
    public void testCompareLF() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = SinglyLinkedList.getClass().getMethod("compareLF", Node.class, Node.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
