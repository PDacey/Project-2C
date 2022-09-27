/**
 * Custom exception thrown if trying to remove an element from an empty queue
 * @author Paul Dacey
 *
 */

public class QueueUnderflowException extends Exception
{
	/**
	 * Default constructor
	 */
	QueueUnderflowException()
	{
		this("Cannot remove an item on an empty queue");
	}
	
	/**
	 * Parameterized constructor
	 * @param message String to be shown
	 */
	QueueUnderflowException(String message)
	{
		super(message);
	}
	
}
