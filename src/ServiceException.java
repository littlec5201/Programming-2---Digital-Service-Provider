import java.util.*;
/**
 * @author Callum
 *
 */
public abstract class ServiceException extends Exception{
	private long errorTimeMS;
	private String errorDate;
	
	/**
	 * Default constructor that gets the current time in milliseconds and converts the number to a String representation
	 * in an understandable format 
	 */
	public ServiceException(){
		super();
		errorTimeMS = System.currentTimeMillis();
		errorDate = new Date(errorTimeMS).toString();
	}
	
	/**
	 * @param message sets the error message in the Exception class
	 */
	public ServiceException(String message){
		super(message);
	}
	
	/**
	 * @return accesses and returns this.errorTimeMS (the current time in MS)
	 */
	public long getErrorTimeMS() {
		return errorTimeMS;
	}

	/**
	 * @param errorTimeMS modifies this .errorTimeMS
	 */
	public void setErrorTimeMS(long errorTimeMS) {
		this.errorTimeMS = errorTimeMS;
	}

	/**
	 * @return accesses and returns this.getErrorDate based on this.errorTimeMS
	 */
	public String getErrorDate() {
		return errorDate;
	}

	/**
	 * @param errorDate modifies this.errorDate
	 */
	public void setErrorDate(String errorDate) {
		this.errorDate = errorDate;
	}
}
