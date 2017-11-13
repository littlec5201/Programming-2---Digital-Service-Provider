import java.text.*;

/**
 * @author Callum
 *
 */
public class Bill {
	ServiceUsage serviceUsage;
	CustomerAccount customerAccount;
	CloudUsage cloudUsage;
	XeroUsage xeroUsage;
	SpotifyUsage spotifyUsage;
	SparkUsage sparkUsage;
	
	/**
	 * @param customerAccount identifies the CustomerAccount that the bill will be produced for
	 * @param cloudUsage identifies how much usage the customer will be charged for
	 */
	public Bill(CustomerAccount customerAccount, CloudUsage cloudUsage){
		this.customerAccount = customerAccount;
		this.cloudUsage = cloudUsage;
		this.serviceUsage = new CloudUsage(cloudUsage.getNoOfVirtualMachines(), cloudUsage.getNoOfDiskStorageDevices());
	}
	
	/**
	 * @param customerAccount identifies the CustomerAccount that the bill will be produced for
	 * @param xeroUsage identifies how much usage the customer will be charged for
	 */
	public Bill(CustomerAccount customerAccount, XeroUsage xeroUsage){
		this.customerAccount = customerAccount;
		this.xeroUsage = xeroUsage;
		this.serviceUsage = new XeroUsage(xeroUsage.getNoOfMonthsOwing());
	}
	
	/**
	 * @param customerAccount identifies the CustomerAccount that the bill will be produced for
	 * @param spotifyUsage identifies how much usage the customer will be charged for
	 */
	public Bill(CustomerAccount customerAccount, SpotifyUsage spotifyUsage){
		this.customerAccount = customerAccount;
		this.spotifyUsage = spotifyUsage;
		this.serviceUsage = new SpotifyUsage(spotifyUsage.getNoOfMonthsOwing());
	}
	
	/**
	 * @param customerAccount identifies the CustomerAccount that the bill will be produced for
	 * @param sparkUsage identifies how much usage the customer will be charged for
	 */
	public Bill(CustomerAccount customerAccount, sparkUsage sparkUsage){
		this.customerAccount = customerAccount;
		this.sparkUsage = sparkUsage;
		this.serviceUsage = new sparkUsage(sparkUsage.getNoOfMonthsOwing());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Returns a string representation of the queried ServiceUsage type. The serviceProvider that is modified in the 
	 * ServiceUsage subclasses is used as the criteria to print a bill. If the serviceUsage provider matches a string,
	 * then that particular bill is printed. The string is an in depth representation of the CustomerAccount and the ServiceUsage 
	 */
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.00"); 
		if (serviceUsage.getServiceProvider() == "CloudUsage"){	
			return "Customer Name: "+customerAccount.getCustomerName() + ". Account Number: "+customerAccount.getCustomerNumber() + "\n"
				 + "Contact Details: " + customerAccount.getCustomerDetails() + "\n"
				 + "CLOUD USAGE:\n"
				 + "1) $"+ df.format(cloudUsage.getTotalOwingVirtualMachines()) + " (" + cloudUsage.getNoOfVirtualMachines() + " Virtual Machines @ $" + cloudUsage.getPriceOfVirtualMachines() + " per month)\n"
				 + "2) $"+ df.format(cloudUsage.getTotalOwingDiskStorageDevices()) + " (" + cloudUsage.getNoOfDiskStorageDevices() + " Disk Storage Devices @ $" + cloudUsage.getPriceOfDiskStorageDevices() + " per month)\n"
				 + "TOTAL Amount: $" + (df.format(cloudUsage.getUsage()) + "\n");
		} 
		else if(serviceUsage.getServiceProvider() == "Xero"){
			return "Customer Name: "+customerAccount.getCustomerName() + ". Account Number: "+customerAccount.getCustomerNumber() + "\n"
					 + "Contact Details: " + customerAccount.getCustomerDetails() + "\n"
					 + "XERO USAGE:\n"
					 + "1) $"+ df.format(xeroUsage.getTotalOwing()) + " (" + xeroUsage.getNoOfMonthsOwing() + " months @ $" + xeroUsage.getPriceOfMonthlySubscription() + " per month)\n"
					 + "TOTAL Amount: $" + (df.format(xeroUsage.getUsage()) + "\n");
		} 
		else if(serviceUsage.getServiceProvider() == "Spotify"){
		 	return "Customer Name: "+customerAccount.getCustomerName() + ". Account Number: "+customerAccount.getCustomerNumber() + "\n"
					 + "Contact Details: " + customerAccount.getCustomerDetails() + "\n"
					 + "SPOTIFY USAGE:\n"
					 + "1) $"+ df.format(spotifyUsage.getTotalOwing()) + " (" + spotifyUsage.getNoOfMonthsOwing() + " months @ $" + spotifyUsage.getPriceOfMonthlySubscription() + " per month)\n"
					 + "TOTAL Amount: $" + (df.format(spotifyUsage.getUsage()) + "\n");
		} 
		else if(serviceUsage.getServiceProvider() == "Spark"){
		 	return "Customer Name: "+customerAccount.getCustomerName() + ". Account Number: "+customerAccount.getCustomerNumber() + "\n"
					 + "Contact Details: " + customerAccount.getCustomerDetails() + "\n"
					 + "Spark USAGE:\n"
					 + "1) $"+ df.format(sparkUsage.getTotalOwing()) + " (" + sparkUsage.getNoOfMonthsOwing() + " months @ $" + sparkUsage.getPriceOfMonthlySubscription() + " per month)\n"
					 + "TOTAL Amount: $" + (df.format(sparkUsage.getUsage()) + "\n");
		} else {
			return "The usage you requested does not exist!";
		}
		
	}
}
