import java.util.*;
import java.lang.*;
import java.text.*;
import java.util.Map.Entry;

/**
 * @author Callum
 *
 */
public abstract class DigitalServiceProvider implements PaymentSystem{
	
	HashMap<CustomerAccount, ServiceUsage> customerMap = new HashMap<CustomerAccount, ServiceUsage>();
	
	/**
	 * @param customerAccount identifies the CustomerAccount that will be subscribed
	 * @param serviceUsage identifies the type of ServiceUsage that will be used by the customer
	 * @throws CustomerAlreadyExistsException throws an exception if the customer name is empty or the account is already subscribed
	 * This method will be used in the main method to add new customers to the customerMap
	 */
	public void subscribe(CustomerAccount customerAccount, ServiceUsage serviceUsage) throws CustomerAlreadyExistsException{
		if (customerAccount.getCustomerName() == ""){
			System.err.print("\"EMPTY NAME\"");
			throw new CustomerAlreadyExistsException();
		}
		else if (customerMap.containsKey(customerAccount)){
			System.err.print(customerAccount.getCustomerName());
			throw new CustomerAlreadyExistsException();
		} else {
			customerMap.put(customerAccount, serviceUsage);
		}	
	}
	
	/**
	 * @param customerAccount identifies the CustomerAccount that will be unsubscribed
	 * @throws CustomerDoesNotExistException throws an exception if the CustomerAccount doesn't exist in the queried customerMap or 
	 * has already been unsubscribed
	 * This method will be used in the main method to remove customers from the customerMap
	 */
	public void unsubscribe(CustomerAccount customerAccount) throws CustomerDoesNotExistException{
		if (customerMap.containsKey(customerAccount)){
			customerMap.remove(customerAccount);
			System.out.println("The customer was successfully unsubscribed.");
		} else {
			if (customerAccount == null){
				System.err.print("CUSTOMER");
				throw new CustomerDoesNotExistException();
			} else {
				System.err.print(customerAccount.getCustomerName());
				throw new CustomerDoesNotExistException();
			}
		} 		
	}
	
	/**
	 * @param customerAccount identifies the CustomerAccount that will be have its usage retrieved
	 * @return returns the usage amount for the CustomerAccount queried
	 * @throws GetServiceUsageException throws an exception if the usage has been set to null
	 * This method will be used in the customerTranscript method to return the usage for the CustomerAccount
	 */
	ServiceUsage getUsage(CustomerAccount customerAccount) throws GetServiceUsageException{
		if (customerMap.get(customerAccount).getUsage() == null){
			System.err.print(customerAccount.getCustomerName());
			throw new GetServiceUsageException();
		}
		else if (customerMap.get(customerAccount).getUsage() < 0){
			System.err.print(customerAccount.getCustomerName());
			throw new GetServiceUsageException();
		} else {
			return customerMap.get(customerAccount);
		}
	}
	
	/**
	 * @param customerAccount identifies the CustomerAccount that will be have its usage updated
	 * @param serviceUsage identifies the type of ServiceUsage that will be updated by the user
	 * @throws UpdateServiceUsageException throws an exception if the ServiceUsage value is less than or the same as before 
	 */
	public void updateUsage(CustomerAccount customerAccount, ServiceUsage serviceUsage) throws UpdateServiceUsageException{
		if (Double.compare(serviceUsage.getUsage(), customerMap.get(customerAccount).getUsage()) == 1){
			customerMap.replace(customerAccount, serviceUsage);
			System.out.println("The usage was successfully updated.");
			
		} else {
			System.err.print("CUSTOMER");
			throw new UpdateServiceUsageException();
		}
	}
	
	/**
	 * @param byName will determine if the customerTranscript will be sorted by name or by usage values
	 * @return returns a String representation of the total number of customers in the customerMap for the queried ServiceProvider
	 * This method will be used a lot in the main method for printing a simple representation of the customerMap contents.
	 */
	public String customerTranscript(boolean byName){
		int i = 0;
		DecimalFormat df = new DecimalFormat("0.00"); 
		if (byName){
			List<CustomerAccount> sortByCustomerName = new ArrayList<CustomerAccount>(customerMap.keySet());
			Collections.sort(sortByCustomerName, new Comparator<CustomerAccount>(){
				public int compare(CustomerAccount arg0, CustomerAccount arg1){
					return arg0.getCustomerName().compareTo(arg1.getCustomerName());
				}
			});
			if (sortByCustomerName.isEmpty()){
				System.out.println("There doesn't appear to be any customers subscribed to this service");
			} else {
				System.out.println("-----------------------------------");
		        for(CustomerAccount customerAccount : sortByCustomerName){
		        	System.out.println("Account Number: " + customerAccount.getCustomerNumber());
		        	System.out.println("Customer Name: " + customerAccount.getCustomerName());
		        	System.out.println("Service Usage: $" + (df.format(customerMap.get(customerAccount).getUsage())));
		        	System.out.println("-----------------------------------");
		        	i++;
		        }
			}
		} else {
			Set<Entry<CustomerAccount, ServiceUsage>> set = customerMap.entrySet();
			List<Entry<CustomerAccount, ServiceUsage>> sortByCustomerUsage = new ArrayList<Entry<CustomerAccount, ServiceUsage>>(set);
			Collections.sort(sortByCustomerUsage, new Comparator<HashMap.Entry<CustomerAccount, ServiceUsage>>(){
				@Override
				public int compare(Entry<CustomerAccount, ServiceUsage> o1, Entry<CustomerAccount, ServiceUsage> o2) {
					return o1.getValue().getUsage().compareTo(o2.getValue().getUsage());
				}
			}.reversed());
			if (sortByCustomerUsage.isEmpty()){
				System.out.println("There doesn't appear to be any customers subscribed to this service");
			} else {
				System.out.println("-----------------------------------");
				for(Map.Entry<CustomerAccount, ServiceUsage> customerAccount : sortByCustomerUsage){
					System.out.println("Account Number: " + customerAccount.getKey().getCustomerNumber());
					System.out.println("Customer Name: " + customerAccount.getKey().getCustomerName());
					System.out.println("Service Usage: $" + (df.format(customerAccount.getValue().getUsage())));
					System.out.println("-----------------------------------");
					i++;
				}
			}
		}
		return "Total number of customers: " + i + "\n";
	}
}
