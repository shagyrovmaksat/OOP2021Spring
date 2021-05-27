package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import uni.*;

public class Controller {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Admin admin = new Admin("Admin", "Adminovich", "12345");
		Database.users.add(admin);
		start();

	}
	
	public static void start() throws IOException {
		System.out.println("----------- WELCOME TO THE INTRANET! -----------");
		
		while (true) {
			System.out.println("[1] Sign in\n"
					+ "[2] Exit");
			
			String input = reader.readLine();
			
			if (input.equals("1")) {
				User user = loginMenu();
				
				if (user != null) {
					while (user.isLoginned()) {
						
						System.out.println("\n--- Your are successfully signed in ---");
						
<<<<<<< HEAD
						feed(user);

						if (user instanceof Admin)
							AdminController.showMenu(user, reader);
						else if (user instanceof Manager)
							ManagerController.showMenu();
						else if (user instanceof Student)
							StudentController.showMenu();
						else if (user instanceof Teacher)
							TeacherController.showMenu();
						else if (user instanceof Librarian)
							LibrarianController.showMenu();
=======
						input = reader.readLine();
						if (input.equals("1")) {
							if (user instanceof Admin)
								AdminController.showMenu();
							else if (user instanceof Manager)
								ManagerController.showMenu((Manager)user);
							else if (user instanceof Student)
								StudentController.showMenu((Student)user);
							else if (user instanceof Teacher)
								TeacherController.showMenu();
							else if (user instanceof Librarian)
								LibrarianController.showMenu();
						}
						else {
							showNews(user);
						}
>>>>>>> d028f067a76c82c4369675cd208813f6e7b6e7b9
					}
				}
			}
			else if (input.equals("2")) {
				System.out.println("\n--- System is closed ---");
				break;
			}
			else {
				System.out.println("\n--- Incorrect input format. Please, choose correct one ---");
			}
		}
	}
	
	
	public static User loginMenu() throws IOException {
		
		while(true) {
			
			System.out.print("\nUsername: ");
			String username = reader.readLine();
			System.out.print("Password: ");
			String password = reader.readLine();

			User user = Database.getUserByUsername(username);
			if (user != null && user.login(password)) {
				return user;
			}
			else {
				System.out.println("\n--- Incorrect username or password ---\n"
						+ "[1] Try again\n"
						+ "[2] Go back");
				String input = reader.readLine();
				
				if (input.equals("1"))
					continue;
				else 
					break;
			}
		}
		return null;
		
	}
	
	
	public static void feed(User user) throws IOException {
		
		Map<Integer, News> news = new HashMap<Integer, News>();
		Map<Integer, Comment> comments = new HashMap<Integer, Comment>();
		int cnt = 1;
		
		
		System.out.println("[0] Menu\n"
				+ "News:");
		for (News n: Database.news) {
			System.out.println("[" + cnt + "] " + n.getTitle());
			news.put(cnt, n);
			cnt++;
		}
		
		String input = reader.readLine();
		
		if (input.equals("0"))
			return;
		else {
			System.out.print("\n--- News Detail ---");
			News selectedNews = news.get(Integer.parseInt(input));
			
			System.out.println(selectedNews.getTitle() + "\n" +
					selectedNews.getContent() + "\n" +
					selectedNews.getPublishedDate());
			
			cnt = 1;
			System.out.println("Comments: ");
			for(Comment comment: selectedNews.getComments()) {
				System.out.println("   [" + cnt + "] " + comment.getAuthor().getName() + " " + comment.getAuthor().getSurname() + "\n      " +
									comment.getContent() + "\n      " +
									comment.getPublishedDate());
				comments.put(cnt, comment);
				cnt++;
			}
		}
		
	}
	
	public static void changePassword(User user) throws IOException {
		System.out.println("--- Change Password ---");
				
		System.out.print("Password: ");
		String password = reader.readLine();
		System.out.print("New password: ");
		String newPassword = reader.readLine();
		System.out.print("Confirm new password: ");
		String newPassword1 = reader.readLine();
		
		if (!user.checkPassword(password))
			System.out.println("Error, incorrect password. Please, try again.");
		else if (!newPassword.equals(newPassword1))
			System.out.println("Error, new passwords are not same. Please, try again.");
		else {
			user.changePassword(newPassword);
			System.out.println("--- Password successfully changed ---");
		}
		
	}
}
