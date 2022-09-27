/**
 * Tests the methods of MyQueue
 * @author Paul Dacey
 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {
	/**
	 * Initialize strinQ of MyQueue with the type String
	 */
	public MyQueue<String> stringQ;
	/**
	 * String variables to test with
	 */
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	/**
	 * Initialize ArrayList of Strings to be utilized in the fill method
	 */
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	/**
	 * Initialize doubleQ of MyQueue with the type Double
	 */
	public MyQueue<Double> doubleQ;
	
	// STUDENT: add variables as needed for your student tests
	/**
	 * Variables num1,num2,num3,num4,num5 used to test the methods of MyQueue
	 */
	public Double num1 = 1.0, num2 = 2.0, num3 = 3.0, num4 = 4.0, num5 = 5.0;

	/**
	 * Sets up the queue to be used in testing
	 * @throws Exception Exception thrown if error occurs during setUp
	 */
	@Before
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		doubleQ = new MyQueue<Double>(4);
		doubleQ.enqueue(num1);
		doubleQ.enqueue(num2);
		doubleQ.enqueue(num3);
		
		//STUDENT: add setup for doubleQ for student tests
	}

	/**
	 * Resets stringQ & doubleQ to be used for next test
	 * @throws Exception Exception thrown if error occurs during tearDown
	 */
	@After
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	/**
	 * Tests the isEmpty() method for the correct value
	 */
	@Test
	public void testIsEmpty() {
		
		try {
			assertEquals(false,stringQ.isEmpty());
			stringQ.dequeue();
			stringQ.dequeue();
			stringQ.dequeue();
			assertEquals(true, stringQ.isEmpty());
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		

		
	}

	/**
	 * Test the dequeue() method for the correct value returned and a successfully thrown exception
	 */
	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
	
	/**
	 * Tests the dequeue method for the correct value and a thrown exception
	 */
	@Test
	public void testDequeueStudent() {
		try 
		{
			assertEquals(true, doubleQ.enqueue(num4));
			assertEquals(num1, doubleQ.dequeue());
			assertEquals(num2, doubleQ.dequeue());
			assertEquals(num3, doubleQ.dequeue());
			assertEquals(num4, doubleQ.dequeue());
			assertEquals(0, doubleQ.size());
			doubleQ.dequeue();
			assertTrue("Should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e)
		{
			assertTrue("Successfully threw an QueueUnderflowException", true);
		}
		catch (Exception e)
		{
			assertTrue("Did not throw an QueueUnderflowException", false);
		}
	}

	/**
	 * Tests the return value of the size method
	 */
	@Test
	public void testSize() {
		
		
		try 
		{
			assertEquals(3, stringQ.size());
			stringQ.enqueue(d);
			assertEquals(4, stringQ.size());
			stringQ.dequeue();
			stringQ.dequeue();
			assertEquals(2, stringQ.size());
		} 
		catch (QueueOverflowException e) 
		{
			assertTrue("Caused an QueueOverflowException", false);
		} catch (QueueUnderflowException e) 
		{
			assertTrue("Caused an QueueUnderflowException", false);
		}
		
		
	}

	/**
	 * Tests the enqueue method for the correct value returned and a thrown exception when appropriate
	 */
	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	/**
	 * Similar to testEnqueue but utilizes doubleQ to test with 
	 */
	@Test
	public void testEnqueueStudent() 
	{
		try
		{
			assertEquals(true, doubleQ.enqueue(num4));
			assertEquals(4, doubleQ.size());
			doubleQ.enqueue(num1);
		}
		catch (QueueOverflowException e){
			assertTrue("Successfully threw QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		
		
		
		
	}

	/**
	 * Tests if the isFull method returns the correct value
	 */
	@Test
	public void testIsFull() 
	{
		
		try 
		{
			assertEquals(false, stringQ.isFull());
			stringQ.enqueue(d);
			stringQ.enqueue(e);
			assertEquals(true, stringQ.isFull());
		} 
		catch (QueueOverflowException e1) 
		{
			assertTrue("Caused an QueueOverflowException", false);
		}
		
	}

	/**
	 * Tests the toString method to check that it returns the correct string representation of the queue
	 */
	@Test
	public void testToString() {
		try 
		{
			assertEquals("abc", stringQ.toString());
			stringQ.enqueue(d);
			assertEquals("abcd", stringQ.toString());
			stringQ.enqueue(e);
			assertEquals("abcde", stringQ.toString());
		} 
		catch (QueueOverflowException e1) 
		{
			assertTrue("Caused a QueueOverflowException",false);
		
		}
		catch(Exception e)
		{
			assertTrue("Threw an exception other than QueueOverflowException",false);
		}
		

	}
	
	/**
	 * Tests the toString method using doubleQ 
	 */
	@Test
	public void testToStringStudent() {
		try 
		{
			assertEquals("1.02.03.0", doubleQ.toString());
			doubleQ.enqueue(num4);
			assertEquals("1.02.03.04.0", doubleQ.toString());
			doubleQ.dequeue();
			doubleQ.dequeue();
			assertEquals(2, doubleQ.size());
			assertEquals("3.04.0", doubleQ.toString());
		} 
		catch (QueueOverflowException e1) 
		{
			assertTrue("Caused a QueueOverflowException",false);
		
		}
		catch(Exception e)
		{
			assertTrue("Threw an exception other than QueueOverflowException",false);
		}
	}

	/**
	 * Tests the toString method to check that it returns the correct string representation of the queue with delimiters
	 */
	@Test
	public void testToStringDelimiter() {
		
		try 
		{
			assertEquals("a%b%c", stringQ.toString("%"));
			stringQ.enqueue(d);
			assertEquals("a&b&c&d", stringQ.toString("&"));
			stringQ.enqueue(e);
			assertEquals("a/b/c/d/e", stringQ.toString("/"));
		} 
		catch (QueueOverflowException e1) 
		{
			assertTrue("Caused a QueueOverflowException",false);
		
		}
		catch(Exception e)
		{
			assertTrue("Threw an exception other than QueueOverflowException",false);
		}
		
	}

	/**
	 * Tests the fill method to make sure the elements were added to the queue successfully and returns the correct values
	 */
	@Test
	public void testFill() {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new MyQueue<String>(5);
		//fill with an ArrayList
		stringQ.fill(fill);
		assertEquals(3,stringQ.size());

		
		try {
			assertEquals("apple", stringQ.dequeue());
			assertEquals("banana", stringQ.dequeue());
			assertEquals("carrot", stringQ.dequeue());
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		
		
		
		
		
				
	}

}
