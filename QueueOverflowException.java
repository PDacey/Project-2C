/**
 * Custom exception when number of elements added to the queue exceed its size
 * @author Paul Dacey
 *
 */

public class QueueOverflowException extends Exception
{
	/**
	 * Default constructor
	 */
	QueueOverflowException()
	{
		this("Queue is full, cannot add item");
	}
	
	/**
	 * Parameterized constructor
	 * @param message String to be displayed
	 */
	QueueOverflowException(String message)
	{
		super(message);
	}
	
	
	
}
