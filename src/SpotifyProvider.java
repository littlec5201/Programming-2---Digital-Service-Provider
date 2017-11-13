
public class SpotifyProvider extends DigitalServiceProvider{
	
	/**
	 * Calls the default constructor in ServiceProvider
	 */
	public SpotifyProvider(){
		super();
	}

	/* (non-Javadoc)
	 * @see PaymentSystem#payBill(CustomerAccount, ServiceUsage)
	 * returns a Bill representation of spotifyBill based on CustomerAccount and ServiceUsage
	 */
	public Bill payBill(CustomerAccount customerAccount, ServiceUsage serviceUsage) {
		Bill cloudBill = new Bill(customerAccount, (SpotifyUsage) serviceUsage);
		return cloudBill;
	}

}