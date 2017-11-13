
public class CustomerAlreadyExistsException extends ServiceException{
	/**
	 * Calls the default constructor in ServiceException
	 */
	public CustomerAlreadyExistsException(){
		super();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 * Returns an error message as a string representation that includes the time and reason that the error occurred
	 */
	public String toString(){
		return " could not be subscribed!\n"
				+ "Error occurred at: " + this.getErrorDate() + "\n"
				+ "The customer is already subscribed or the customer name is empty.\n";
	}
}
