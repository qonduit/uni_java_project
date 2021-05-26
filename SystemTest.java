import java.util.Scanner;

public class SystemTest {
	public static void main(String[] args) {
		//initialise new System object, specifying the make, model and processor speed as parameters
		System sys = new System("Intel", "i7", 4);
		//set Hard Disk size to 1GB
		sys.setHardDisk(1);
		//set Memory to 20MB
		sys.setMemory(20);
		//set Purchase Cost to £1000
		sys.setPurchaseCost(1000);
		java.lang.System.out.println("Welcome to the System User Interface!");
		//while (true) loop is used to repeat the below until the user selects they want to quit, using the return statement on line 76
		while (true) {
			//try/catch used to catch erroneous input
			try {
				//initialise a new Scanner class from java.util.Scanner to be used to collect user input
				Scanner sc = new Scanner(java.lang.System.in);
				java.lang.System.out.println("\nPlease choose from the following five options and press 'Enter':"
						+ "\n1) Print System Details"
						+ "\n2) Display System Properties"
						+ "\n3) Diagnose System"
						+ "\n4) Set Details"
						+ "\n5) Quit the program"
						+ "\n\nPlease enter your choice");
				//initialise a new int variable userInput and prompt the user for their input, which is assigned to the variable
				int userInput = sc.nextInt();
				//switch to provide an appropriate response to the user's input
				switch (userInput) {
				case 1:
					//print out the output from displayDetails(), with an extra line space for formatting
					java.lang.System.out.println(sys.displayDetails() + "\n");
					break;
				case 2:
					//print out the output from displaySystemProperties(), with an extra line space for formatting
					java.lang.System.out.println(sys.displaySystemProperties() + "\n");
					break;
				case 3:
					//print out the output from diagnoseSystem(), with an extra line space for formatting
					java.lang.System.out.println(sys.diagnoseSystem() + "\n");
					break;
				case 4:
					//prompt the user for the hard disk size and memory that they want to set in the system, with appropriate prompting messages
					//try/catch and if statements are used for error catching
					try {
						java.lang.System.out.println("\nPlease enter the Hard Disk Size in GB:");
						double HDD = sc.nextDouble();
						if (HDD > 0) {
							sys.setHardDisk(HDD);
						} else {
							java.lang.System.out.println("Sorry, that is not a valid input. Please try again");
							break;
						}
					} catch (Exception e) {
						java.lang.System.out.println("Sorry, that is not a valid input. Please try again");
						break;
					}
					try {
						java.lang.System.out.println("\nPlease enter the system memory in MB:");
						int memory = sc.nextInt();
						if (memory > 0) {
							sys.setMemory(memory);
							break;
						} else {
							java.lang.System.out.println("Sorry, that is not a valid input.");
							break;
						}
					} catch (Exception e) {
						java.lang.System.out.println("Sorry, that is not a valid input.");
						break;
					}
					//a thank you message and the use of the return statement to exit the while loop, if the user selects they want to quit
				case 5:
					java.lang.System.out.println("\n\nThank you for using the System User Interface!");
					return;
				default:
					//if the user enters any input that is not an integer from 1-5, it provides them with an error message and re-starts the loop
					java.lang.System.out.println("Sorry, that is not a valid input.");
					break;
				}		
			} catch (Exception e) {
				java.lang.System.out.println("Sorry, that is not a valid input. Please try again");
			}
		}
	}
}