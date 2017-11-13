
/**
 * @author Callum
 *
 */
public class CloudUsage extends ServiceUsage{
	private Integer noOfVirtualMachines;
	private static Double priceOfVirtualMachines = 0.14;
	private Integer noOfDiskStorageDevices;
	private static Double priceOfDiskStorageDevices = 0.51;

	/**
	 * @param usage modifies this.noOfMonthsOwing
	 * The constructor modifies the serviceProvider in the super class to Spotify, modifies this.noOfMonthsOwing and 
	 * this.usage 
	 */
	public CloudUsage(Integer noOfVirtualMachines, Integer noOfDiskStorageDevices){
		super("CloudUsage");
		setNoOfVirtualMachines(noOfVirtualMachines);
		setNoOfDiskStorageDevices(noOfDiskStorageDevices);
		setUsage();
	}

	/* (non-Javadoc)
	 * @see ServiceUsage#getUsage()
	 * Accesses and returns this.usage
	 */
	public Double getUsage() {
		return usage;
	}

	/* (non-Javadoc)
	 * @see ServiceUsage#setUsage(java.lang.Double)
	 * Modifies this.usage
	 */
	public void setUsage() {
		this.usage = getTotalOwingDiskStorageDevices() + getTotalOwingVirtualMachines();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * Compares objects in the customerMap to other objects based on usage values  
	 */
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}
	
	/**
	 * @return accesses and returns this.noOfVirtualMachines
	 */
	public Integer getNoOfVirtualMachines() {
		return noOfVirtualMachines;
	}

	/**
	 * @param noOfVirtualMachines modifies this.noOfVirtualMachines
	 */
	public void setNoOfVirtualMachines(Integer noOfVirtualMachines) {
		this.noOfVirtualMachines = noOfVirtualMachines;
	}

	/**
	 * @return accesses and returns this.noOfDiskStorageDevices
	 */
	public Integer getNoOfDiskStorageDevices() {
		return noOfDiskStorageDevices;
	}

	/**
	 * @param noOfDiskStorageDevices modifies this.noOfDiskStorageDevices
	 */
	public void setNoOfDiskStorageDevices(Integer noOfDiskStorageDevices) {
		this.noOfDiskStorageDevices = noOfDiskStorageDevices;
	}

	/**
	 * @return accesses and returns this.priceOfVirtualMachines
	 */
	public Double getPriceOfVirtualMachines() {
		return priceOfVirtualMachines;
	}

	/**
	 * @return accesses and returns this.priceOfDiskStorageDevices
	 */
	public Double getPriceOfDiskStorageDevices() {
		return priceOfDiskStorageDevices;
	}
	
	/**
	 * @return returns the total amount owing. This value will be added with getTotalOwingDiskStorageDevices() to 
	 * set this.usage
	 */
	public Double getTotalOwingVirtualMachines(){
		return getNoOfVirtualMachines() * getPriceOfVirtualMachines();
	}
	
	/**
	 * @return returns the total amount owing. This value will be added with getTotalOwingVirtualMachines() to 
	 * set this.usage
	 */
	public Double getTotalOwingDiskStorageDevices(){
		return getNoOfDiskStorageDevices() * getPriceOfDiskStorageDevices();
	}
}

