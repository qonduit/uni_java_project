import javax.swing.*;
//initiate class SytemTestGUI to create a test class for a GUI version of SystemTest.java
public class SystemTestGUI {
	public static void main(final String[] args) {
		//initiate new System variable and specify make, model and speed by parameter
		System sys = new System("Intel", "i7", 4);
		//set Hard Disk size to 1GB
		sys.setHardDisk(1);
		//set Memory to 20MB
		sys.setMemory(20);
		//set Purchase Cost to £1000
		sys.setPurchaseCost(1000);
		//initialise new JFrame
		JFrame frame = new JFrame();
		//while (true) loop is used to repeat the loop until the return statement (line 76) is used to exit the loop when the user selects they want to quit
		while (true) {
			//request input from the user in the GUI, with appropriate prompting text, assigning it to a newly initialised variable userInput
			String userInput = JOptionPane.showInputDialog(frame, "Welcome to the System User Interface!"
					+ "\nPlease choose from the following five options and press 'Enter':"
					+ "\n1) Print System Details"
					+ "\n2) Display System Properties"
					+ "\n3) Diagnose System"
					+ "\n4) Set Details"
					+ "\n5) Quit the program"
					+ "\n\nPlease enter your choice");
			//a switch to handle inputs by the user, after they have been validated by the try/catch above
			switch (userInput) {
				case "1":
					//display a message in the GUI that contains the output from the sys.displayDetails() method as they have requested
					JOptionPane.showMessageDialog(frame, "The details of the system are:\n\n"
							+ sys.displayDetails() + "\n");
					break;
				case "2":
					//display a message in the GUI that contains the output from the sys.displaySystemProperties() method as they have requested
					JOptionPane.showMessageDialog(frame, "The properties of the system are:\n\n"
							+ sys.displaySystemProperties() + "\n");
					break;
				case "3":
					//display a message in the GUI that contains the output from the sys.diagnoseSystem() method as they have requested
					JOptionPane.showMessageDialog(frame, "System diagnosis:\n\n"
							+ sys.diagnoseSystem() + "\n");
					break;
				case "4":
					//the use of try/catch in order to handle erroneous inputs by the user. If the user enters a valid input, the loop will continue
					try {
						Double HDD = Double.parseDouble(JOptionPane.showInputDialog(frame, "Please enter the amount of system hard disk space in GB:\n\n"));
						if (HDD > 0) {
							sys.setHardDisk(HDD);
						} else {
							JOptionPane.showMessageDialog(frame, "Sorry, that is not a valid input. Please try again.");
							break;
						}
					//if the user enters an invalid input causing an exception, the catch method below will provide them with a message and allow them to re-enter their input by
					//re-starting the loop
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, "Sorry, that is not a valid input. Please try again.");
						break;
					}
					//same use of try/catch as above (lines 60-72)
					try {
						int memory = Integer.parseInt(JOptionPane.showInputDialog(frame, "Please enter the amount of system memory in MB:\n\n"));
						if (memory > 0) {
							sys.setMemory(memory);
							break;
						} else {
							JOptionPane.showMessageDialog(frame, "Sorry, that is not a valid input. Please try again.");
							break;
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, "Sorry, that is not a valid input. Please try again.");
						break;
					}
				case "5":
					//when the user inputs that they want to quit the loop, this will give them a 'thank you' message and end the loop with the use of the return statement
					JOptionPane.showMessageDialog(frame, "\n\nThank you for using the System User Interface!");
					return;
				default:
					//if the user enters any String other than numbers 1-5, it will provide them with an error message and prompt them to re-enter
					JOptionPane.showMessageDialog(frame, "Sorry, that is not a valid input. Please try again.");
					break;
			}		
		}
	}
}
