
/**
 * @author Callum
 *
 */
public abstract class ServiceUsage implements Comparable{
	protected Double usage;
	protected String serviceProvider;

	/**
	 * @param serviceProvider modifies this.serviceProvider. This will be set through the subclass providers
	 */
	public ServiceUsage(String serviceProvider){
		setServiceProvider(serviceProvider);
	}
	
	/**
	 * Default constructor for ServiceUsage, which sets this.usage to null 
	 */
	public ServiceUsage(){
		setUsage(null);
	}

	/**
	 * @return accesses and returns this.usage. This will be called by the usage subclasses
	 */
	public Double getUsage() {
		return usage;
	}

	/**
	 * @param usage modifies this.usage. 
	 */
	public void setUsage(Double usage) {
		this.usage = usage;
	}
	
	/**
	 * @return accesses and returns a String representation of the Service Provider currently in use.
	 */
	public String getServiceProvider() {
		return serviceProvider;
	}

	/**
	 * @param serviceProvider modifies this.serviceProvider. This will be useful in identifying the type of ServiceProvider
	 * in the DigitalServiceProvider class
	 */
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
}
