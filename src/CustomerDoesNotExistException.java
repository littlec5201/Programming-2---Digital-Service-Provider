
public class CustomerDoesNotExistException extends ServiceException{
	/**
	 * Calls the default constructor in ServiceException
	 */
	public CustomerDoesNotExistException(){
		super();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 * Returns an error message as a string representation that includes the time and reason that the error occurred
	 */
	public String toString(){
		return " could not be unsubscribed!\n"
				+ "Error occurred at: " + this.getErrorDate() + "\n"
				+ "The customer does not have an account with this service or is already unsubscribed.\n";
	}
}
