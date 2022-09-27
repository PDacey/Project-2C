/**
 * Custom exception thrown when element is being added to a full stack
 * @author Paul Dacey
 *
 */

public class StackOverflowException extends Exception
{
	/**
	 * Default constructor
	 */
	StackOverflowException()
	{
		this("Stack is full, cannot add item");
	}
	
	/**
	 * Parameterized constructor
	 * @param message String to be shown
	 */
	StackOverflowException(String message)
	{
		super(message);
	}
	
	
	
}
