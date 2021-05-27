package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import uni.*;

public class AdminController {
	private static Admin admin;
	private static BufferedReader reader;
	
	public static void showMenu(User user, BufferedReader bfreader) throws IOException {
		admin = (Admin) user;
		reader = bfreader;
		
		
		while (admin.isLoginned()) {
			System.out.println("\n--- Admin: " + admin.getName() + " " + admin.getSurname() + " ---\n"
					+ "[1] Manage users\n"
					+ "[2] View log files\n"
					+ "[3] Change password\n"
					+ "[4] Logout");
			
			String input = reader.readLine();
			
			switch (input) {
				case "1":
					manageUsers();
					break;
				case "2":
					viewLogFiles();
					break;
				case "3":
					Controller.changePassword(user);
					break;
				case "4":
					admin.logout();
					break;
				default:
					break;
			}
		
		}		
	}
	
	
	public static void manageUsers() throws IOException {
		while (true) {
			System.out.println("\n--- Manage users ---\n"
					+ "[0] Go back\n"
					+ "[1] View all users\n"
					+ "[2] Create new user\n"
					+ "[3] Delete existing user\n"
					+ "[4] Increase study year\n");
			
			String input = reader.readLine();
			
			//Go back
			if (input.equals("0"))
				break;
			
			// View all users
			else if (input.equals("1")) {
				viewAllUsers();
			}
			
			//Create new user
			else if (input.equals("2")) {
				createNewUser();
			}
			else if (input.equals("3")) {
				deleteUser();
			}
			
			else if (input.equals("4")) {
				System.out.println("Do you want to increase study year? After confirmation you can not disrupt this process!!!\n"
						+ "[1] Confirm\n"
						+ "[2] Cancel");
				String confirmation = reader.readLine();
				if (confirmation.equals("1")) {
					admin.increaseStudyYear();
					System.out.print("--- Study year successfully increased ---");
				}
				else
					System.out.println("--- Canceled ---");
			}
		}
	}
	
	public static void viewLogFiles() {
		int cnt = 1;
		for (LogFile log: admin.viewLogFiles()) {
			System.out.println(cnt + ". " + log.getType() + "[id: " + log.getUserId() + ", username: " + log.getUsername() + "] [date: " + log.getDate() + "]");
		}
	}
	
	
	public static void deleteUser() throws IOException {
		System.out.println("--- Delete existing user ---");
		viewAllUsers();
		
		while (true) {
			System.out.println("\n Press 0 to cancel and go back to main menu\n"
					+ "Enter ID of user that you want to delete");
			
			String input = reader.readLine();
			
			if (input.equals("0"))
				break;
			else {
				try {
					int id = Integer.parseInt(input);
					User selectedUser = Database.getUserById(id);
					if (id != admin.getId() && selectedUser != null) {
						System.out.print("Do you want to removed the user: [id: " + id + ", fullname: " + selectedUser.getName() + " " + selectedUser.getSurname()+ "]\n"
								+ "[1] Confirm\n"
								+ "[2] Cancel");
						String confirmation = reader.readLine();
						if (confirmation.equals("1")) {
							admin.removeUser(id);
							System.out.println("--- User successfully removed ---");
						}
						else {
							System.out.println("--- Canceled ---");
						}
					}
					else {
						System.out.print("--- Error ---\n"
								+ "User with id: " + id + " does not exist or you can not able to remove this user");
					}
					
				}
				catch (NumberFormatException e) {
					System.out.println("Incorrect input");
				}
				catch (NullPointerException e) {
					System.out.println("Incorrect input");
				}
			}
		}
		 
	}
	
	
	public static void viewAllUsers() {
		int cnt = 1;
		for (User u: admin.viewAllUsers()) {
			System.out.println(cnt + ". [id: " + u.getId() + "] [role: " + u.getClass().getSimpleName() + "] [fullname: " + u.getName() + " " + u.getSurname() + "] [username: " + u.getUsername() + "]");
			cnt++;
		}
	}
	
	
	public static void createNewUser() throws IOException {
		User user = null;
		UserFactory factory = new UserFactory();
		
		System.out.println("--- Create User ---\n"
				+ "Choose user type that you want to create\n"
				+ "[0] Go back\n"
				+ "[1] Manager\n"
				+ "[2] Teacher\n"
				+ "[3] Student\n"
				+ "[4] Librarian");
		String userType = reader.readLine();
		if (userType.equals("0"))
			return;
		
		System.out.print("\nName: ");
		String name = reader.readLine();
		System.out.print("Surname: ");
		String surname = reader.readLine();
		System.out.print("Password: ");
		String password = reader.readLine();

		
		if (userType.equals("1")) {
			user = factory.getUser(UserType.MANAGER, name, surname, password);
		}
		
		else if (userType.equals("2")) {
			Teacher teacher = (Teacher) factory.getUser(UserType.TEACHER, name, surname, password);
			System.out.println("\nSelect the faculty of the teacher: \n"
					+ "[1] FIT\n"
					+ "[2] KMA\n"
					+ "[3] SMC");
			String input = reader.readLine();
			if (input.equals("1"))
				teacher.setFaculty(Faculty.FIT);
			else if (input.equals("2"))
				teacher.setFaculty(Faculty.KMA);
			else if (input.equals("3"))
				teacher.setFaculty(Faculty.SMC);
			
			System.out.println("\nSelect the rank of the teacher: \n"
					+ "[1] Senior Lector\n"
					+ "[2] Lector\n"
					+ "[3] Professor");
			input = reader.readLine();
			if (input.equals("1"))
				teacher.setRank(Rank.SENIOR_LECTOR);
			else if (input.equals("2"))
				teacher.setRank(Rank.LECTOR);
			else if (input.equals("3"))
				teacher.setRank(Rank.PROFESSOR);
			user = teacher;
		}
		
		else if (userType.equals("3")) {
			Student student = (Student) factory.getUser(UserType.STUDENT, name, surname, password);

			System.out.println("\nSelect the faculty of the student: \n"
					+ "[1] FIT\n"
					+ "[2] KMA\n"
					+ "[3] SMC");
			String input = reader.readLine();
			
			if (input.equals("1")) {
				student.setFaculty(Faculty.FIT);
				System.out.println("Select the speciality of the student: \n"
						+ "[1] AC\n"
						+ "[2] CSS\n"
						+ "[3] IS");
				input = reader.readLine();
				if (input.equals("1"))
					student.setSpeciality(Speciality.FIT_AC);
				else if (input.equals("2"))
					student.setSpeciality(Speciality.FIT_CSS);
				else if (input.equals("3"))
					student.setSpeciality(Speciality.FIT_IS);
			}
			
			else if (input.equals("2")) {
				student.setFaculty(Faculty.KMA);
				student.setSpeciality(Speciality.KMA_MET);
			}
			else if (input.equals("3")) {
				student.setFaculty(Faculty.SMC);
				student.setSpeciality(Speciality.SMC_MCM);
			}
			
			user = student;
		}
		else if (userType.equals("4")) {
			user = factory.getUser(UserType.LIBRARIAN, name, surname, password);
		}
		else 
			return;
		
		if (user != null && admin.addUser(user))
			System.out.println("--- User is successfully created! ---\n"
					+ "[ID: " + user.getId() + "] [role: " + user.getClass().getSimpleName() + "] [fullname: " + user.getName() + " " + user.getSurname() + "] [username: " + user.getUsername() + "]");
		else 
			System.out.println("--- Something went wrong. Please, try again ---");
	}
	
	
	
	
	
	
}
