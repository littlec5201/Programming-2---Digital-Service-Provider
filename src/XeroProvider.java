
public class XeroProvider extends DigitalServiceProvider{
	
	/**
	 * Calls the default constructor in ServiceProvider
	 */
	public XeroProvider(){
		super();
	}

	/* (non-Javadoc)
	 * @see PaymentSystem#payBill(CustomerAccount, ServiceUsage)
	 * returns a Bill representation of cloudBill based on CustomerAccount and ServiceUsage
	 */
	public Bill payBill(CustomerAccount customerAccount, ServiceUsage serviceUsage) {
		Bill cloudBill = new Bill(customerAccount, (XeroUsage) serviceUsage);
		return cloudBill;
	}
}