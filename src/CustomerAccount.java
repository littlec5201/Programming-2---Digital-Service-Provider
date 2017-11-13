
public class CustomerAccount implements Comparable<CustomerAccount>{
	private String customerName;
	private String customerDetails;
	private  int customerNumber;
	private static int number = 1;
	
	/**
	 * Default constructor which sets each variable to its default state
	 */
	public CustomerAccount(){
		setCustomerName(null);
		setCustomerDetails(null);
	}
	
	/**
	 * @param customerName modifies this.customerName
	 * @param customerDetails modifies this.customerDetails
	 * This constructor will be used to create a new CustomerAccount
	 */
	public CustomerAccount(String customerName, String customerDetails){
		setCustomerName(customerName);
		setCustomerDetails(customerDetails);
		setCustomerNumber(number++);
	}
	
	
	/**
	 * @return accesses and returns this.customerName 
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName modifies this.customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName.toUpperCase();
	}

	/**
	 * @return accesses and returns this.customerDetails
	 */
	public String getCustomerDetails() {
		return customerDetails;
	}

	/**
	 * @param customerDetails modifies this.customerDetails
	 */
	public void setCustomerDetails(String customerDetails) {
		this.customerDetails = customerDetails.toUpperCase();
	}

	/**
	 * @return accesses and returns this.customerNumber
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber modifies this.customerNumber
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * Allows customer names to be compared to one another. This will be used in DigitalServiceProvider for sorting 
	 * names in alphabetical order
	 */
	@Override
	public int compareTo(CustomerAccount o) {
		return this.getCustomerName().compareTo(o.getCustomerName());
	}
}
