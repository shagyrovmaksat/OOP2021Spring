package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import uni.*;

public class ManagerController {
	
	static Manager manager = null;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	static String choice;
	static String managerConsole  = 
			"---------------------------------------\n"
			+ "[1] Open/close registration\n"
			+ "[2] View students and teachers\n"
			+ "[3] Manage courses\n"
			+ "[4] Manage registration and lessons\n"
			+ "[5] Manage news\n"
			+ "[6] Manage messages\n"
			+ "[7] Change password\n"
			+ "[0] Logout\n"
			+ "---------------------------------------\n";
	
	public static void showMenu(Manager currentManager) throws IOException {
		manager = currentManager;
		while(manager.isLoginned()) {
			System.out.println(managerConsole);
			choice = reader.readLine();
			
			if(choice.equals("1")) {
				while(true) {
					if(Database.registrationIsOpen == true) {
						System.out.println("Registration is open now\n"+
								   		   "Enter 1 to close registration/n" +
								   		   "Enter 0 to exit/n");
					}
					else {
						System.out.println("Registration is close now\n" +
										   "Enter 1 to open registration/n" +
										   "Enter 0 to exit/n");
						
					}
					choice = reader.readLine();
					if(choice.equals("1")) {
						if(Database.registrationIsOpen == true) manager.closeRegistration();
						else manager.openRegistration();
					} else break;
				}
				
			} else if(choice.equals("2")) {
				while(true) {
					System.out.println("Enter 1 to view students\n"+
					   		   		   "Enter 2 to view teachers/n" +
					   		   		   "Enter 0 to exit/n");
					choice = reader.readLine();
					if(choice.equals("0")) break;
					else if(choice.equals("1")) {
						Vector<Student> students = Database.getStudents();
						for(int i = 0; i < students.size(); i++) {
							System.out.println("[" + i+1 + "]" + " " + students.get(i));
						}
					} else if(choice.equals("2")) {
						Vector<Teacher> teachers = Database.getTeachers();
					}
				}
				
			} else if(choice.equals("3")) {
				
			} else if(choice.equals("4")) {
				
			} else if(choice.equals("5")) {
				
			} else if(choice.equals("6")) {
				while(true) {
					System.out.println("Enter 1 to view messages from you." 
									 + "Enter 2 to view messages to you." 
									 + "Enter 3 to send message." 
									 + "Enter 0 to back.");
					choice = reader.readLine();
					if(choice.equals("1")) {
						Vector<Message> messages = manager.viewMessagesFromMe(manager.getId());
						for(int i = 0; i < messages.size(); i++) {
							System.out.println(i+1 + ") " + messages.get(i));
						}
					} else if (choice.equals("2")) {
						Vector<Message> messages = manager.viewMessagesToMe(manager.getId());
						for(int i = 0; i < messages.size(); i++) {
							System.out.println(i+1 + ") " + messages.get(i));
						}
					} else if (choice.equals("3")) {
						manager.sendMessage(Controller.createMessage(manager));
					} else break;
				}
			} else if(choice.equals("7")) {
				while(true) {
					System.out.println("Enter your current password: ");
					choice = reader.readLine();
					if(choice.hashCode() == manager.getPassword()) {
						while(true) {
							System.out.println("Enter your new password: ");
							String newPassword = reader.readLine();
							System.out.println("Confirm your new password: ");
							String temp = reader.readLine();
							if(newPassword.equals(temp)) {
								manager.changePassword(newPassword);
								System.out.println("\nYour password was successfuly changed.\n");
								break;
							} else {
								System.out.println("Passwords didn't matched. Please try again.\n");
							}
						}
						break;
					} else System.out.println("Sorry passwords didn't match. Please try again.\n");
				}
			} else {
				manager.logout();
			}
		}
	}
}
