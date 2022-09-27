/**
 * Generic class MyStack that acts as a stack utilizing an array
 * @author Paul Dacey
 */

import java.util.ArrayList;

public class MyStack<T> implements StackInterface
{
	/**
	 * Array of generic type to hold elements
	 */
	private T[] stack;
	/**
	 * Holds size of the array
	 */
	private int size;
	/**
	 * Holds the index of the top and bottom of the stack
	 */
	private int top,bottom;
	
	/**
	 * Default constructor to initialize variables
	 */
	@SuppressWarnings("unchecked")
	MyStack()
	{
		size = 5;
		top = -1;
		bottom = -1;
		stack = (T[]) new Object[size];
	}
	
	/**
	 * Parameterized constructor to set size of the stack
	 * @param num Size of the stack
	 */
	@SuppressWarnings("unchecked")
	MyStack(int num)
	{
		size = num;
		top = -1;
		bottom = -1;
		stack = (T[]) new Object[size];
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() 
	{
		if(top == -1 || top == 0)
		{
			return true;
		}
		return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() 
	{
		if(top == size)
		{
			return true;
		}
		/*
		else if(bottom == top)
		{
			return true;
		}*/
		
		return false;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException 
	{
		T temp;
		
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		else
		{
			temp = stack[top-1];
			stack[top-1] = null;
			top--;
		}
		
		
		
		return temp;
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException 
	{
		T temp;
		
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		else
		{
			temp = stack[top-1];
		}
		return temp;
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() 
	{
		
		return top;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean push(Object e) throws StackOverflowException 
	{
		if(isFull())
		{
			throw new StackOverflowException();
		}
		else
		{
			if(top == -1)
			{
				top = 0;
			}
			else if(bottom == -1)
			{
				bottom = 0;
			}
			
			stack[top] = (T) e;
			top++;
			return true;
			
			
		}
		
	}

	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString()
	{
		String temp = "";
		
		while(bottom != top)
		{
			temp += stack[bottom];
			bottom++;
		}
		bottom = 0;
		
		return temp;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		
		String temp = "";
		int num = bottom;
		while(bottom < top)
		{
			
			if(bottom != top - 1)
			{
				temp += stack[bottom] + delimiter;
				bottom++;
			}
			else
			{
				temp += stack[bottom];
				bottom++;
			}
		}
		
		bottom = num;
		
		return temp;
	}

	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@Override
	public void fill(ArrayList list)
	{
		ArrayList copy = new ArrayList<>();
		for(int i = 0; i < list.size(); i++)
		{
			copy.add(list.get(i));
		}
		
		boolean overflow = false;
		if(isEmpty())
		{
			for(int k = 0; k < copy.size(); k++)
			{
				if(!overflow)
				{
					try
					{
						push(copy.get(k));
					}
					catch (StackOverflowException e)
					{
						overflow = true;
						break;
					}
				}
			}
			
			
			
			
			
		}
		
	}
	
	
	
	
	
	
	
}
