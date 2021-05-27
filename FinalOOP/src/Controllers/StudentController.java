package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uni.*;

public class StudentController {
	
	static Student student = null;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	static String choice;
	static String studentConsole  = 
			"---------------------------------------\n"
			+ "[1] View my courses\n"
			+ "[2] View files\n"
			+ "[3] Registration for courses\n"
			+ "[4] View schedule\n"
			+ "[5] View transcript\n"
			+ "[6] Get transcript\n"
			+ "[7] Change password\n"
			+ "[0] Logout\n"
			+ "---------------------------------------\n";
	
	public static void showMenu(Student currentStudent) throws IOException {
		student = currentStudent;
		while(student.isLoginned()) {
			System.out.println(studentConsole);
			choice = reader.readLine();
			
			if(choice.equals("1")) {
				int cnt = 1;
				for(Course c : student.getCourses()) {
					System.out.println("[" + cnt + "]" + " " + c.getName() + "\n");
				}
			} else if(choice.equals("2")) {
				for(Course c : student.getCourses()) {
					System.out.println(
							"---------------------------------------\n" 
							+ "Course - " + c.getName() 
							+ "---------------------------------------\n");
					for(File f : c.getCourseFiles()) {
						System.out.println(f + "\n");
					}
				}
			} else if(choice.equals("3")) {
				System.out.println("Enter 0 to exit\n");
				System.out.println("Enter the number of course to register\n");
				for(int i = 0; i < Database.courses.size(); i++) {
					System.out.println(i+1 + " " + Database.courses.get(i).getName());
				}
				
				while(true) {
					choice = reader.readLine();
					if(choice.equals("0")) {
						continue;
					} else {
						if(Integer.parseInt(choice) > Database.courses.size()) {
							System.out.println("Sorry, course with this number doesn't exist.\n"
									+ "Please enter number of course again.\n"
									+ "Or enter 0 to exit");
						} else {
							if(student.registerForCourse(Database.courses.get(Integer.parseInt(choice))))
								System.out.println("You successfully registered.");
							else 
								System.out.println("Sorry, you have not registered.");
							break;
						}
					}
				}
			} else if(choice.equals("4")) {
				System.out.println(student.getSchedule());
			} else if(choice.equals("5")) {
				System.out.println(student.getTranscript());
			} else if(choice.equals("6")) {
				
			} else if(choice.equals("7")) {
				while(true) {
					System.out.println("Enter your current password: ");
					choice = reader.readLine();
					if(choice.hashCode() == student.getPassword()) {
						while(true) {
							System.out.println("Enter your new password: ");
							String newPassword = reader.readLine();
							System.out.println("Confirm your new password: ");
							String temp = reader.readLine();
							if(newPassword.equals(temp)) {
								student.changePassword(newPassword);
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
				student.logout();
			}
		}
	}
}
