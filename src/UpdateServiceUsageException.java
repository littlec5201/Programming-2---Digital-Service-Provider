
/**
 * @author Callum
 *
 */
public class UpdateServiceUsageException extends ServiceException{
	/**
	 * Calls the default constructor in ServiceException
	 */
	public UpdateServiceUsageException(){
		super();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 * Returns an error message as a string representation that includes the time and reason that the error occurred
	 */
	public String toString(){
		return " usage could not be updated!\n"
				+ "Error occurred at: " + this.getErrorDate() + "\n"
				+ "The updated value is the same or less than before.\n";
	}
}
