//define the System class with the desired attributes
public class System {
	private String make;
	private String model;
	private int speed;
	private int memorySize; //in MB
	private double hardDiskSize; //in GB
	private double purchaseCost;
	//define the System initiator method that allows the make, model and speed to be taken as parameters and set in
	//the code
	public System(String setMake, String setModel, int setSpeed) {
		make = setMake;
		model = setModel;
		speed = setSpeed;
	}
	//define the setMemory(int) method that takes the memory size as a parameter
	public void setMemory(int memSize) {
		memorySize = memSize;
	}
	//define the setHardDisk(double) method that takes the hard disk size as a parameter
	public void setHardDisk(double hddSize) {
		hardDiskSize = hddSize;
	}
	//define the setPurchaseCost(double) method that takes the purchase cost as a parameter
	public void setPurchaseCost(double purchCost) {
		purchaseCost = purchCost;
	}
	//define the getMake() method that returns the make as a String
	public String getMake() {
		return make;
	}
	//define the getModel() method that returns the model as a String
	public String getModel() {
		return model;
	}
	//define the getProcessorSpeed() method that returns the processor speed as an int
	public int getProcessorSpeed() {
		return speed;
	}
	//define the displayDetails() function that returns a String describing the details of the System object in question
	public String displayDetails() {
		return "\nMake = " + getMake() +
				"\nModel = " + getModel() +
				"\nProcessor speed = " + getProcessorSpeed() + "GHz" +
				"\nMemory size = " + memorySize + "MB" +
				"\nHard disk size = " + hardDiskSize + "GB" +
				"\nPurchase cost = £" + purchaseCost;
	}
	//define the checkHDStatus() method that checks the amount of available hard disk space in the System object and
	//returns a String of whether it is 'ok' or 'low'
	public String checkHDStatus() {
		if (hardDiskSize < 2 && hardDiskSize >= 0) {
			return "low";
		} else {
			return "OK";
		}
	}
	//define the goodMemorySize() method that checks the amount of memory in the System object and returns a boolean
	//that is true if it is over 128MB or false if it is below this amount
	public boolean goodMemorySize() {
		if (memorySize < 128) {
			return false;
		} else {
			return true;
		}
	}
	//define the diagnoseSystem() method that utilises the checkHDStatus() and goodMemorySize methods and returns
	//the outputs from these methods as a String that is formatted to be user friendly and display the information
	//to the user
	public String diagnoseSystem() {
		return "Hard disk size = " + checkHDStatus() +
				"\nMemory size OK = " + goodMemorySize();
	}
	//define the displaySystemProperties method that utilises the Java System class method getProperty() in order to
	//get information about the computer system and returns this information as a String that is formatted
	//in a user friendly way and easily readable. It also gives an 'opinion', that is either positive or negative,
	//on the type of operating system that the user is on
	public String displaySystemProperties() {
		String osArch = java.lang.System.getProperty("os.arch");
		String osName = java.lang.System.getProperty("os.name");
		String osVersion = java.lang.System.getProperty("os.version");
		String username = java.lang.System.getProperty("user.name");
		String javaVersion = java.lang.System.getProperty("java.version");
		String osMessage;
		if (osName.equalsIgnoreCase("windows 10")) {
			osMessage = "Great!";
		} else if (osName.equalsIgnoreCase("linux")) {
			osMessage = "Oh no!";
		} else {
			osMessage = "It's okay.";
		}
		return "Operating System Architecture = " + osArch +
				"\nOperating System Name = " + osName +
				"\nOperating System Version = " + osVersion +
				"\nUsername = " + username +
				"\nJava Version = " + javaVersion +
				"\nWhat we think of your operating system: " + osMessage;
	}
}
