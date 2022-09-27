/**
 * Exception class to indicate an invalid notation format
 * @author Paul Dacey
 *
 */


public class InvalidNotationFormatException extends Exception
{
	/**
	 * Default constructor
	 */
	InvalidNotationFormatException()
	{
		this("Notation format is invalid");
	}
	
	/**
	 * Parameterized constructor
	 * @param message
	 */
	InvalidNotationFormatException(String message)
	{
		super(message);
	}
}
