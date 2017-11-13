
public interface PaymentSystem {
	/**
	 * @param customerAccount identifies the CustomerAccount that the bill will be produced for
	 * @param serviceUsage identifies the type of ServiceUsage that the bill will be produced for
	 * @return returns a Bill representation of payBill
	 */
	public Bill payBill(CustomerAccount customerAccount, ServiceUsage serviceUsage);
}
