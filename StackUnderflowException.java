/**
 * Custom exception thrown if element is trying to be removed from an empty stack
 * @author Paul Dacey
 *
 */

public class StackUnderflowException extends Exception
{
	/**
	 * Default constructor
	 */
	StackUnderflowException()
	{
		this("Stack is empty, cannot remove item");
	}
	
	/**
	 * Parameterized constructor
	 * @param message String to be shown
	 */
	StackUnderflowException(String message)
	{
		super(message);
	}
}
