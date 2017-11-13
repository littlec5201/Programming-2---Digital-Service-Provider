
/**
 * @author Callum
 *
 */
public class XeroUsage extends ServiceUsage{
	private Integer noOfMonthsOwing;
	private Double priceOfMonthlySubscription = 25.00;
	
	/**
	 * @param usage modifies this.noOfMonthsOwing
	 * The constructor modifies the serviceProvider in the super class to Xero, modifies this.noOfMonthsOwing and 
	 * this.usage 
	 */
	public XeroUsage(Integer noOfMonthsOwing){
		super("Xero");
		setNoOfMonthsOwing(noOfMonthsOwing);
		setUsage();
	}
	
	/**
	 * @return accesses and returns this.noOfMonthsOwing
	 */
	public Integer getNoOfMonthsOwing() {
		return noOfMonthsOwing;
	}
	
	/**
	 * @param noOfMonthsOwing modifies this.noOfMonthsOwing
	 */
	public void setNoOfMonthsOwing(Integer noOfMonthsOwing) {
		this.noOfMonthsOwing = noOfMonthsOwing;
	}
	
	/**
	 * @return accesses and returns this.getPriceOfMonthlySubscription
	 */
	public Double getPriceOfMonthlySubscription() {
		return priceOfMonthlySubscription;
	}
	
	/* (non-Javadoc)
	 * @see ServiceUsage#getUsage()
	 * Accesses and returns this.usage
	 */
	public Double getUsage() {
		return usage;
	}
	
	/* (non-Javadoc)
	 * @see ServiceUsage#setUsage(java.lang.Double)
	 * Modifies this.usage
	 */
	public void setUsage() {
		this.usage = getTotalOwing();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * Compares objects in the customerMap to other objects based on usage values  
	 */
	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	/**
	 * @return returns the total amount owing. This value will be used to set this.usage
	 */
	public Double getTotalOwing(){
		return getNoOfMonthsOwing() * getPriceOfMonthlySubscription();
	}
	
}
