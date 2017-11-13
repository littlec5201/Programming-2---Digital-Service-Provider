
public class SparkProvider extends DigitalServiceProvider{
	
	/**
	 * Calls the default constructor in ServiceProvider
	 */
	public SparkProvider(){
		super();
	}

	/* (non-Javadoc)
	 * @see PaymentSystem#payBill(CustomerAccount, ServiceUsage)
	 * returns a Bill representation of spotifyBill based on CustomerAccount and ServiceUsage
	 */
	public Bill payBill(CustomerAccount customerAccount, ServiceUsage serviceUsage) {
		Bill cloudBill = new Bill(customerAccount, (SparkUsage) serviceUsage);
		return cloudBill;
	}

}