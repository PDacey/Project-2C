/**
 * Tests the methods of MyStack
 * @author Paul Dacey
 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {
	/*
	 * Initialize strinQ of MyQueue with the type String
	 */
	public MyStack<String> stringS;
	/*
	 * String variables to test with 
	 */
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	/*
	 * ArrayList of Strings to be utilized in the fill method
	 */
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleS
	/**
	 * Initialize doubleQ of MyStack with the type Double
	 */
	public MyStack<Double> doubleS;
	// STUDENT: add variables as needed for your student tests
	/**
	 * Variables num1,num2,num3,num4,num5 used to test the methods of MyStack
	 */
	public Double num1 = 1.0, num2 = 2.0, num3 = 3.0, num4 = 4.0, num5 = 5.0;
	
	/**
	 * Sets up the stack to be used in testing
	 * @throws Exception Exception thrown if error occurs during setUp
	 */
	@Before
	public void setUp() throws Exception {
		stringS = new MyStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);
		doubleS = new MyStack<Double>(5);
		doubleS.push(num1);
		doubleS.push(num2);
		doubleS.push(num3);
		
		//STUDENT: add setup for doubleS for student tests
	}

	/**
	 * Resets stringS & doubleS to be used for next test
	 * @throws Exception Exception thrown if error occurs during setUp
	 */
	@After
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	/**
	 * Tests if isEmpty returns the correct value
	 */
	@Test
	public void testIsEmpty() {
		assertEquals(false,stringS.isEmpty());
		
		try 
		{
			stringS.pop();
			stringS.pop();
			stringS.pop();
			
			
		}
		catch(StackUnderflowException e)
		{
			assertTrue("Caused an underflow exception",false);
		}
		
		assertEquals(true, stringS.isEmpty());
	}

	/**
	 * Tests the isFull method to check if it returns the appropriate value
	 */
	@Test
	public void testIsFull() {
		assertEquals(false, stringS.isFull());
		try {
			stringS.push(d);
			stringS.push(e);
		} catch (StackOverflowException e1) {
			assertTrue("Caused a stack overflow exception",false);
		}
		
		assertEquals(true, stringS.isFull());
	}

	/**
	 * Tests the pop method to check if the element is removed and returns the correct element that was popped
	 */
	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}

	/*
	 * Tests the pop method utilizing doubleS to check that the correct popped element was returned and deleted
	 */
	@Test
	public void testPopStudent() 
	{
		try 
		{
		assertEquals(num3, doubleS.pop());
		assertEquals(num2, doubleS.pop());
		assertEquals(num1, doubleS.pop());
		assertTrue(doubleS.isEmpty());
		doubleS.pop();
		}
		catch(StackUnderflowException e)
		{
			assertTrue("Successfully threw a StackUnderflowException", true);
		}
		
		
		
		
	}
	
	/**
	 * Tests the top method to check that the most recently added element is at the top of the stack
	 */
	@Test
	public void testTop() {
		try 
		{
			assertEquals(c, stringS.top());
			stringS.push(d);
			assertEquals(d, stringS.top());
			stringS.pop();
			stringS.pop();
			assertEquals(b, stringS.top());
			
			
		} 
		catch (StackUnderflowException e) 
		{
			assertTrue("This should not have caused a StackUnderflowException",false);
		} 
		catch (StackOverflowException e) 
		{
			
			assertTrue("This should not have caused a StackOverflowException",false);
		}
		
				
	}

	/**
	 * Tests the size() method to check that it returns the number of elements currently in the stack
	 */
	@Test
	public void testSize() {
		
		try {
		assertEquals(3, stringS.size());
		stringS.push(d);
		assertEquals(4, stringS.size());
		stringS.pop();
		stringS.pop();
		assertEquals(2, stringS.size());
		}
		catch(StackOverflowException e)
		{
			assertTrue("This should not have caused a StackOverflowException",false);
		}
		catch (StackUnderflowException e) 
		{
			assertTrue("This should not have caused a StackUnderflowException",false);
		} 
	}

	/**
	 * Tests the push method to check that it adds the elements to the stack successfully and throws the appropriate 
	 * exception when necessary
	 */
	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	/**
	 * Tests weather the toString method returns the correct representation of the elements in the stack
	 */
	@Test
	public void testPushStudent() 
	{
		try
		{
			assertEquals(true, doubleS.push(num4));
			assertEquals(4, doubleS.size());
			assertEquals(true, doubleS.push(num5));
			assertTrue(doubleS.isFull());
			doubleS.push(num1);
			assertTrue("Did not throw StackOverflowException", false);
	
		}
		catch(StackOverflowException e)
		{
			assertTrue("Successfully threw a StackOverflowException", true);
		}
		
	}
	
	/**
	 * Tests weather the toString method returns the correct representation of the elements in the stack
	 */
	@Test
	public void testToString() {
		
		try
		{
		assertEquals("abc", stringS.toString());
		stringS.push(d);
		assertEquals("abcd", stringS.toString());
		stringS.push(e);
		assertEquals("abcde", stringS.toString());
		}
		catch(StackOverflowException e)
		{
			assertTrue("This should not have caused a StackOverflow exception",false);
		}
	}

	/**
	 * Tests weather the toString method returns the correct representation of the elements in the stack
	 */
	@Test
	public void testToStringStudent() {
		try
		{
		assertEquals("1.02.03.0", doubleS.toString());
		doubleS.pop();
		assertEquals("1.02.0", doubleS.toString());
		doubleS.push(num4);
		assertEquals("1.02.04.0", doubleS.toString());
		}
		catch(StackOverflowException e)
		{
			assertTrue("Threw a StackOverflowException",false);
		}
		catch(StackUnderflowException e)
		{
			assertTrue("Threw a StackUnderflowException",false);
		}
	}
	
	/**
	 * Tests the output of toStringDelimiter to check for correct placement of elements and delimiters
	 */
	@Test
	public void testToStringDelimiter() {
		
		try
		{
			assertEquals("a%b%c", stringS.toString("%"));
			stringS.push(d);
			assertEquals("a&b&c&d", stringS.toString("&"));
			stringS.push(e);
			assertEquals("a/b/c/d/e", stringS.toString("/"));
		}
		catch(StackOverflowException e)
		{
			assertTrue("This should not have caused a StackOverflow exception",false);
		}
	
	}

	/**
	 * Tests the fill method to make sure the elements were added to the stack successfully and returns the correct values
	 */
	@Test
	public void testFill() {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringS = new MyStack<String>(5);
		//fill with an ArrayList
		stringS.fill(fill);
		assertEquals(3,stringS.size());
		
		try {
			assertEquals("carrot", stringS.pop());
			assertEquals("banana", stringS.pop());
			assertEquals("apple", stringS.pop());	
		}
		catch (StackUnderflowException e){
			assertTrue("This caused an StackUnderflowException", false);
		}
		catch (Exception e){
			assertTrue("This caused an exception other than StackUnderflowException", false);
		}
		
		
			
	}

}
