package exceptions;

public class IllegalFigureStateException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1958606303083919830L;
	
	public IllegalFigureStateException(String message)
	{
		super(message);
	}
}