
public class CloudProvider extends DigitalServiceProvider{
	
	/**
	 * Calls the default constructor in ServiceProvider
	 */
	public CloudProvider(){
		super();
	}

	/* (non-Javadoc)
	 * @see PaymentSystem#payBill(CustomerAccount, ServiceUsage)
	 * returns a Bill representation of spotifyBill based on CustomerAccount and ServiceUsage
	 */
	public Bill payBill(CustomerAccount customerAccount, ServiceUsage serviceUsage) {
		Bill cloudBill = new Bill(customerAccount, (CloudUsage) serviceUsage);
		return cloudBill;
	}
}
