
/**
 * @author Callum
 *
 */
public class GetServiceUsageException extends ServiceException{
	/**
	 * Calls the default constructor in ServiceException
	 */
	public GetServiceUsageException(){
		super();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 * Returns an error message as a string representation that includes the time and reason that the error occurred
	 */
	public String toString(){
		return " usage could not be retrieved!\n"
				+ "Error occurred at: " + this.getErrorDate() + "\n"
				+ "The usage value you tried to retrieve is null.\n";
	}
}
