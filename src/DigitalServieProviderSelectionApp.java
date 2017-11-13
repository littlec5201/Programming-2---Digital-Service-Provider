import java.util.*;
/**
 * @author Callum
 *
 */
public class DigitalServieProviderSelectionApp {
	public static Scanner keyboard = new Scanner(System.in);
	
	/**
	 * @param args
	 * This application has 6 possible options from the "main" menu. Once  selection is made with regards to what the user wishes
	 * to do, the appropriate while loop is called and run. I have made it so that an incorrect entry in "getting" selections, such as
	 * unsubscribe customer, the while loop breaks if an incorrect value is entered. This is so that the user is not forced to do 
	 * something they did not originally plan on doing just so the while loop will terminate, and not loop forever.
	 * I considered making this application so that a single CustomerAccount could be associated to different providers. However, 
	 * this does not apply to real life situations, where different accounts must be made for different websites or providers. The in
	 * line commenting briefly describes what each important step in the code is doing. 
	 */	
	public static void main(String[] args) {
//		Declare the four service provider objects of type BrazzersProvider, CloudProvider, SpotifyProvider and XeroProvider
//		These objects are used to access methods in other classes.
		DigitalServiceProvider brazzersProvider = new BrazzersProvider();
		DigitalServiceProvider cloudProvider = new CloudProvider();
		DigitalServiceProvider spotifyProvider = new SpotifyProvider();
		DigitalServiceProvider xeroProvider = new XeroProvider();
		
		int noOfCustomers = 100;
		int noOfSubscribedCustomerAccounts = 4;
		int menuResponse = 0;
//		Creates and initialises an array of predefined CustomerAccounts for testing purposes. For every new customer that is 
//		created, a unique Customer Account Number is assigned to the customer. This is done in the CustomerAccount class
		CustomerAccount customerAccount[] = new CustomerAccount[noOfCustomers];
		customerAccount[0] = new CustomerAccount("Callum Bensemann", "8 Mount Street, Auckland");
		customerAccount[1] = new CustomerAccount("John Cena", "123 Champ Road, Los Angeles");
		customerAccount[2] = new CustomerAccount("Kenneth Johnson", "WT703C WT BUILDING, AUT CITY CAMPUS");
		customerAccount[3] = new CustomerAccount("Lou Senmearse", "1003 Queen Street, Auckland");
//		Creates an array of billServiceUsages that will store in depth information about each customer
		Bill billBrazzersUsage[] = new Bill[noOfCustomers];
		Bill billCloudUsage[] = new Bill[noOfCustomers];
		Bill billSpotifyUsage[] = new Bill[noOfCustomers];
		Bill billXeroUsage[] = new Bill[noOfCustomers];
//		Subscribes and generates a bill for each of the predefined customers. Not all services have been subscribed to.
//		This is also for error checking.
		try {
			spotifyProvider.subscribe(customerAccount[0], new SpotifyUsage(24));
			billSpotifyUsage[0] = spotifyProvider.payBill(customerAccount[0], new SpotifyUsage(24));
			cloudProvider.subscribe(customerAccount[1], new CloudUsage(10, 10));
			billCloudUsage[1] = cloudProvider.payBill(customerAccount[1], new CloudUsage(10, 10));
			spotifyProvider.subscribe(customerAccount[2], new SpotifyUsage(6));
			billSpotifyUsage[2] = spotifyProvider.payBill(customerAccount[2], new SpotifyUsage(6));	
			spotifyProvider.subscribe(customerAccount[3], new SpotifyUsage(12));
			billSpotifyUsage[3] = spotifyProvider.payBill(customerAccount[3], new SpotifyUsage(12));
		} catch (CustomerAlreadyExistsException e) {
			System.err.println(e);
		}

		System.out.println("Welcome to the Digital Service Provider Application!\n");
		int a = 0;
		mainwhile:
		while (a == 0){
			try{
			try{
				int b = 0;
				
				while (b == 0){
//					The list of possible options are presented to the user
					System.out.println("What would you like to do?");
					System.out.println("1) View subscribed customers");
					System.out.println("2) Subscribe a customer");
					System.out.println("3) Unubscribe a customer");
					System.out.println("4) Update customer usage");
					System.out.println("5) View customer bills");
					System.out.println("6) Quit");
					System.out.println("Please enter a number:");
					menuResponse = keyboard.nextInt();
					if (menuResponse > 6 || menuResponse < 0) {
						System.err.println("Im sorry, \"" + menuResponse + "\" is not one of the options!");
					} else {
						b = menuResponse;
					}
				}
//				This is the loop that displays subscribed customers
				while (b == 1){
					int customerService, orderCustomers;
//					Prompt to choose the service to be viewed
					System.out.println("Which customers do you wish to view?");
					System.out.println("1) Brazzers");
					System.out.println("2) Cloud");
					System.out.println("3) Spotify");
					System.out.println("4) Xero");
					customerService = keyboard.nextInt();
					if (customerService > 4 || customerService < 0){
						System.err.println("Im sorry, \"" + customerService + "\" is not one of the options!");
					} else {
//						Depending on the response, the customerTranscript will be set to true or false. This orders the customers
//						by name or usage. The customerTranscript for the selected provider is then displayed in the order chosen
//						by the user.
						System.out.println("How would you like to order the subscribed customers?");
						System.out.println("1) By name");
						System.out.println("2) By usage");
						orderCustomers = keyboard.nextInt();
						if (orderCustomers > 2 || orderCustomers < 0) {
							System.err.println("Im sorry, \"" + orderCustomers + "\" is not one of the options!");
						} else {
							if (orderCustomers == 1){
								if (customerService == 1){
									System.out.println(brazzersProvider.customerTranscript(true));
								}
								if (customerService == 2){
									System.out.println(cloudProvider.customerTranscript(true));
								}
								if (customerService == 3){
									System.out.println(spotifyProvider.customerTranscript(true));
								}
								if (customerService == 4){
									System.out.println(xeroProvider.customerTranscript(true));
								}
							} else {
								if (customerService == 1){
									System.out.println(brazzersProvider.customerTranscript(false));
								}
								if (customerService == 2){
									System.out.println(cloudProvider.customerTranscript(false));
								}
								if (customerService == 3){
									System.out.println(spotifyProvider.customerTranscript(false));
								}
								if (customerService == 4){
									System.out.println(xeroProvider.customerTranscript(false));
								}
							}
						}
					}
					break;
				}
//				This is the loop that subscribes new customers
				while (b == 2){
					String customerName, customerDetails;
					int customerService  = 0, months, noOfVirtualMachines, noOfDiskStorageDevices;
//					Prompt to choose the service the customer will subscribe to
					System.out.println("What service would you like to subscribe the customer to?");
					System.out.println("1) Brazzers");
					System.out.println("2) Cloud");
					System.out.println("3) Spotify");
					System.out.println("4) Xero");
					customerService = keyboard.nextInt();
					if (customerService > 4 || customerService < 0) {
						System.err.println("Im sorry, \"" + customerService + "\" is not one of the options!");
					} else {
						System.out.println("Please enter the customer name:");
						keyboard.nextLine();
						customerName = keyboard.nextLine();
						System.out.println("Please enter the customer details:");
						customerDetails = keyboard.nextLine();
//							Based on the data entered, a new CustomerAccount will be created. Depending on the service provider
//							selected, the customer will be subscribed to that service provider and a bill will be generated for the 
//							particular service provider.
						if (customerService == 1){
							System.out.println("Please enter the number of months " + customerName.toUpperCase() + " will be subscribed for:");
							months = keyboard.nextInt();
							try {
								customerAccount[noOfSubscribedCustomerAccounts] = new CustomerAccount(customerName, customerDetails);
								brazzersProvider.subscribe(customerAccount[noOfSubscribedCustomerAccounts], new BrazzersUsage(months));
								billBrazzersUsage[noOfSubscribedCustomerAccounts] = brazzersProvider.payBill(customerAccount[noOfSubscribedCustomerAccounts], new BrazzersUsage(months));
								noOfSubscribedCustomerAccounts++;
								break;
							} catch (CustomerAlreadyExistsException e) {
								System.err.println(e);
							}
						}
						if (customerService == 2){
							System.out.println("Please enter the number of Virtual Machines " + customerName.toUpperCase() + " will be using:");
							noOfVirtualMachines = keyboard.nextInt();
							System.out.println("Please enter the number of Disk Storage Devices " + customerName.toUpperCase() + " will be using:");
							noOfDiskStorageDevices = keyboard.nextInt();
							try {
								customerAccount[noOfSubscribedCustomerAccounts] = new CustomerAccount(customerName, customerDetails);
								cloudProvider.subscribe(customerAccount[noOfSubscribedCustomerAccounts], new CloudUsage(noOfVirtualMachines, noOfDiskStorageDevices));
								billCloudUsage[noOfSubscribedCustomerAccounts] = cloudProvider.payBill(customerAccount[noOfSubscribedCustomerAccounts], new CloudUsage(noOfVirtualMachines, noOfDiskStorageDevices));
								noOfSubscribedCustomerAccounts++;
								break;
							} catch (CustomerAlreadyExistsException e) {
								System.err.println(e);
							}
						}
						if (customerService == 3){
							System.out.println("Please enter the number of months " + customerName.toUpperCase() + " will be subscribed for:");
							months = keyboard.nextInt();
							try {
								customerAccount[noOfSubscribedCustomerAccounts] = new CustomerAccount(customerName, customerDetails);
								spotifyProvider.subscribe(customerAccount[noOfSubscribedCustomerAccounts], new SpotifyUsage(months));
								billSpotifyUsage[noOfSubscribedCustomerAccounts] = spotifyProvider.payBill(customerAccount[noOfSubscribedCustomerAccounts], new SpotifyUsage(months));
								noOfSubscribedCustomerAccounts++;
								break;
							} catch (CustomerAlreadyExistsException e) {
								System.err.println(e);
							}
						}
						if (customerService == 4){
							System.out.println("Please enter the number of months " + customerName.toUpperCase() + " will be subscribed for:");
							months = keyboard.nextInt();
							try {
								customerAccount[noOfSubscribedCustomerAccounts] = new CustomerAccount(customerName, customerDetails);
								xeroProvider.subscribe(customerAccount[noOfSubscribedCustomerAccounts], new XeroUsage(months));
								billXeroUsage[noOfSubscribedCustomerAccounts] = xeroProvider.payBill(customerAccount[noOfSubscribedCustomerAccounts], new XeroUsage(months));
								noOfSubscribedCustomerAccounts++;
								break;
							} catch (CustomerAlreadyExistsException e) {
								System.err.println(e);
							}
						}
					}
				}
//				This is the loop that unsubscribes existing customers
				while (b == 3){
					int customerService, unsubscribeAccountNumber;
//					Prompt to choose the service the customer will subscribe to
					System.out.println("What service would you like to unsubscribe the customer from?");
					System.out.println("1) Brazzers");
					System.out.println("2) Cloud");
					System.out.println("3) Spotify");
					System.out.println("4) Xero");
					customerService = keyboard.nextInt();
					if (customerService > 4 || customerService < 0) {
						System.err.println("Im sorry, \"" + customerService + "\" is not one of the options!");
					} else {
//						The customer transcript for the selected provider will be printed to the console. From here, the user
//						can select a customer account they would like to unsubscribe
						if (customerService == 1){
							System.out.println(brazzersProvider.customerTranscript(true));
							if (!brazzersProvider.customerMap.isEmpty()){
								System.out.println("Please enter the account number you wish to unsubscribe:");
								unsubscribeAccountNumber = keyboard.nextInt();
								try {
									brazzersProvider.unsubscribe(customerAccount[unsubscribeAccountNumber - 1]);
								} catch (ServiceException e) {
									System.err.println(e);
								}
							}
						}
						if (customerService == 2){
							System.out.println(cloudProvider.customerTranscript(true));
							if (!cloudProvider.customerMap.isEmpty()){
								System.out.println("Please enter the account number you wish to unsubscribe:");
								unsubscribeAccountNumber = keyboard.nextInt();
								try {
									cloudProvider.unsubscribe(customerAccount[unsubscribeAccountNumber - 1]);
								} catch (ServiceException e) {
									System.err.println(e);
								}
							}
						}
						if (customerService == 3){
							System.out.println(spotifyProvider.customerTranscript(true));
							if (!spotifyProvider.customerMap.isEmpty()){
								System.out.println("Please enter the account number you wish to unsubscribe:");
								unsubscribeAccountNumber = keyboard.nextInt();
								try {
									spotifyProvider.unsubscribe(customerAccount[unsubscribeAccountNumber - 1]);
								} catch (ServiceException e) {
									System.err.println(e);
								}
							}
						}
						if (customerService == 4){
							System.out.println(xeroProvider.customerTranscript(true));
							if (!xeroProvider.customerMap.isEmpty()){
								System.out.println("Please enter the account number you wish to unsubscribe:");
								unsubscribeAccountNumber = keyboard.nextInt();
								try {
									xeroProvider.unsubscribe(customerAccount[unsubscribeAccountNumber - 1]);
								} catch (ServiceException e) {
									System.err.println(e);
								}
							}
						}
					}
					break;
				}
//				This is the loop that updates usage for existing customers				
				while (b == 4){
					int customerService, updateUsageAccountNumber, usage1, usage2;
//					Prompt to choose the service the customer usage that will be updated
					System.out.println("What service would you like to update customer usage?");
					System.out.println("1) Brazzers");
					System.out.println("2) Cloud");
					System.out.println("3) Spotify");
					System.out.println("4) Xero");
					customerService = keyboard.nextInt();
					if (customerService > 4 || customerService < 0) {
						System.err.println("Im sorry, \"" + customerService + "\" is not one of the options!");
					} else {
						try{
//							Prompt to enter update usage data specific to the particular service provider. If the usage 
//							entered is greater than the already existing usage, the usage is updated. To help make it easier
//							to see the usage, a customer bill for the selected CustomerAccount is printed before and after
//							the new usage value(s) is/ are entered.
							if (customerService == 1){
								try{
									System.out.println(brazzersProvider.customerTranscript(true));
									if (!brazzersProvider.customerMap.isEmpty()){
										System.out.println("Please enter the account number you wish to update:");
										updateUsageAccountNumber = keyboard.nextInt();
										System.out.println(billBrazzersUsage[updateUsageAccountNumber - 1]);
										System.out.println("Please enter the value wish to update the months to:");
										usage1 = keyboard.nextInt();
										brazzersProvider.updateUsage(customerAccount[updateUsageAccountNumber - 1], new BrazzersUsage(usage1));
										billBrazzersUsage[updateUsageAccountNumber - 1] = brazzersProvider.payBill(customerAccount[updateUsageAccountNumber - 1], new BrazzersUsage(usage1));
										System.out.println(billBrazzersUsage[updateUsageAccountNumber - 1]);
									}
								} catch (NullPointerException npe) {
									System.err.print("CUSTOMER");
									throw new UpdateServiceUsageException();
								}
							}
							if (customerService == 2){
								try{
									System.out.println(cloudProvider.customerTranscript(true));
									if (!cloudProvider.customerMap.isEmpty()){
										System.out.println("Please enter the account number you wish to update:");
										updateUsageAccountNumber = keyboard.nextInt();
										System.out.println(billCloudUsage[updateUsageAccountNumber - 1]);
										System.out.println("Please enter the value wish to update the Virtual Machines to:");
										usage1 = keyboard.nextInt();
										System.out.println("Please enter the value wish to update the Disk Storage Devices to:");
										usage2 = keyboard.nextInt();
										cloudProvider.updateUsage(customerAccount[updateUsageAccountNumber - 1], new CloudUsage(usage1, usage2));
										billCloudUsage[updateUsageAccountNumber - 1] = cloudProvider.payBill(customerAccount[updateUsageAccountNumber - 1], new CloudUsage(usage1, usage2));
										System.out.println(billCloudUsage[updateUsageAccountNumber - 1]);
									}
								} catch (NullPointerException npe) {
									System.err.print("CUSTOMER");
									throw new UpdateServiceUsageException();
								}
							}
							if (customerService == 3){
								try{
									System.out.println(spotifyProvider.customerTranscript(true));
									if (!spotifyProvider.customerMap.isEmpty()){
										System.out.println("Please enter the account number you wish to update:");
										updateUsageAccountNumber = keyboard.nextInt();
										System.out.println(billSpotifyUsage[updateUsageAccountNumber - 1]);
										System.out.println("Please enter the value wish to update the months to:");
										usage1 = keyboard.nextInt();
										spotifyProvider.updateUsage(customerAccount[updateUsageAccountNumber - 1], new SpotifyUsage(usage1));
										billSpotifyUsage[updateUsageAccountNumber - 1] = spotifyProvider.payBill(customerAccount[updateUsageAccountNumber - 1], new SpotifyUsage(usage1));
										System.out.println(billSpotifyUsage[updateUsageAccountNumber - 1]);
									}
								} catch (NullPointerException npe) {
									System.err.print("CUSTOMER");
									throw new UpdateServiceUsageException();
								}
							}
							if (customerService == 4){
								try{
									System.out.println(xeroProvider.customerTranscript(true));
									if (!xeroProvider.customerMap.isEmpty()){
										System.out.println("Please enter the account number you wish to update:");
										updateUsageAccountNumber = keyboard.nextInt();
										System.out.println(billXeroUsage[updateUsageAccountNumber - 1]);
										System.out.println("Please enter the value wish to update the months to:");
										usage1 = keyboard.nextInt();
										xeroProvider.updateUsage(customerAccount[updateUsageAccountNumber - 1], new XeroUsage(usage1));
										billXeroUsage[updateUsageAccountNumber - 1] = xeroProvider.payBill(customerAccount[updateUsageAccountNumber - 1], new XeroUsage(usage1));
										System.out.println(billXeroUsage[updateUsageAccountNumber - 1]);
									}
								} catch (NullPointerException npe) {
									System.err.print("CUSTOMER");
									throw new UpdateServiceUsageException();
								}
							}
						} catch (ServiceException e) {
							System.err.println(e);
						}
					}
					break;
				}
//				This is the loop that prints customer bills to the console for existing customers	
				while (b == 5){
					int customerService, viewBillAccountNumber;
//					Prompt to choose the service that the customer bill that will be printed for
					System.out.println("For which service would you like to view a customer bill?");
					System.out.println("1) Brazzers");
					System.out.println("2) Cloud");
					System.out.println("3) Spotify");
					System.out.println("4) Xero");
					
					customerService = keyboard.nextInt();
					if (customerService > 4 || customerService < 0) {
						System.err.println("Im sorry, \"" + customerService + "\" is not one of the options!");
					} else {
						try{
//							If the customer map for the selected service is not empty, then a prompt will follow, asking the user 
//							to enter the account number of the bill they wish to view. If the CustomerAccount requested is not
//							in the customerMap, then an error message is printed. If the CustomerAccount is in the customerMap, then
//							the bill information will be printed to the console
							if (customerService == 1){
								System.out.println(brazzersProvider.customerTranscript(true));
								if (!brazzersProvider.customerMap.isEmpty()){
									System.out.println("Please enter the account number of the bill you wish to view:");
									viewBillAccountNumber = keyboard.nextInt();
									if (billBrazzersUsage[viewBillAccountNumber - 1] != null){
										System.out.println(billBrazzersUsage[viewBillAccountNumber - 1]);
									} else {
										System.err.println("The customer bill could not be retrieved");
									}
								}
							}
							if (customerService == 2){
								System.out.println(cloudProvider.customerTranscript(true));
								if (!cloudProvider.customerMap.isEmpty()){
									System.out.println("Please enter the account number of the bill you wish to view:");
									viewBillAccountNumber = keyboard.nextInt();
									if (billCloudUsage[viewBillAccountNumber - 1] != null){
										System.out.println(billCloudUsage[viewBillAccountNumber - 1]);
									} else {
										System.err.println("The customer bill could not be retrieved");
									}
								}
							}
							if (customerService == 3){
								System.out.println(spotifyProvider.customerTranscript(true));
								if (!spotifyProvider.customerMap.isEmpty()){
									System.out.println("Please enter the account number of the bill you wish to view:");
									viewBillAccountNumber = keyboard.nextInt();
									if (billSpotifyUsage[viewBillAccountNumber - 1] != null){
										System.out.println(billSpotifyUsage[viewBillAccountNumber - 1]);
									} else {
										System.err.println("The customer bill could not be retrieved");
									}
								}
							}
							if (customerService == 4){
								System.out.println(xeroProvider.customerTranscript(true));
								if (!xeroProvider.customerMap.isEmpty()){	
									System.out.println("Please enter the account number of the bill you wish to view:");
									viewBillAccountNumber = keyboard.nextInt();
									if (billXeroUsage[viewBillAccountNumber - 1] != null){	
										System.out.println(billXeroUsage[viewBillAccountNumber - 1]);
									} else {
										System.err.println("The customer bill could not be retrieved");
									}
								}
							}
						} catch (NullPointerException npe){
							System.err.println("The customer bill could not be retrieved");
						}
					}
					break;
				}
//				Break the main loop and ends the program
				if (b == 6){
					System.out.println("Thankyou for using the Digital Service Provider Application!");
					break mainwhile;
				}
				b = 0;
			} catch(InputMismatchException ime){
				System.err.println("Please enter an integer value");
				keyboard.next();
			}
			} catch(ArrayIndexOutOfBoundsException oob){
				System.err.println("The number you entered is greater than the number of accounts we can store!");
			}
		}
	}
}
