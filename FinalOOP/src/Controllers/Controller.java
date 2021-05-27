package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import uni.*;

import javax.xml.crypto.Data;

public class Controller {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Admin admin = new Admin("Admin", "Adminovich", "12345");
		Manager manager = new Manager("Manager", "Managerovich", "12345");
		Student student1 = new Student("Aaa", "Aaa", "12345");
		Student student2 = new Student("Bbb", "Bbb", "12345");
		Database.users.add(admin);
		Database.users.add(manager);
		Database.users.add(student1);
		Database.users.add(student2);
		News new1 = new News("hello", "world!");
		News new2 = new News("coco", "ajsdn");
		
		manager.addNews(new1);
		manager.addNews(new2);
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
						
						feed(user);
						
						if (user instanceof Admin)
							AdminController.showMenu((Admin)user);
						else if (user instanceof Manager)
							ManagerController.showMenu((Manager)user);
						else if (user instanceof Student)
							StudentController.showMenu((Student)user);
						else if (user instanceof Teacher)
							TeacherController.showMenu((Teacher) user);
						else if (user instanceof Librarian)
							LibrarianController.showMenu();
					}
				}
			}
			else if (input.equals("2")) {
				System.out.println("\n--- System is closed ---");
				break;
			}
			else {
				System.out.println("\n--- Incorrect input. Please, choose correct one ---");
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
		
		while (true) {
			System.out.println("[0] Menu\n"
					+ "News:");
			if (Database.news.isEmpty())
				System.out.println("--- There is no news yet! ---");
			else
				for (News n: user.viewNews()) {
					System.out.println("[" + cnt + "] title: " + n.getTitle() + ", published date: " + n.getPublishedDate());
					news.put(cnt, n);
					cnt++;
				}
			
			String input = reader.readLine();
			
			if (input.equals("0"))
				return;
			else {
				if (!news.containsKey(Integer.parseInt(input)))
					System.out.println("--- Error, news does not exist. Please, try again ---");
				else {
					News selectedNews = news.get(Integer.parseInt(input));
					while (true) {
						System.out.println("\n--- NEWS DETAIL ---");
						
						System.out.println("title: " + selectedNews.getTitle() + "\ncontent: " +
								selectedNews.getContent() + "\npublished date: " +
								selectedNews.getPublishedDate());
						
						cnt = 1;
						System.out.println("\nComments: ");
						for(Comment comment: selectedNews.getComments()) {
							System.out.println("   " + cnt + ". [author: " + comment.getAuthor().getName() + " " + comment.getAuthor().getSurname() + "] [content: " +
												comment.getContent() + "] [published date: " +
												comment.getPublishedDate() + "]");
							comments.put(cnt, comment);
							cnt++;
						}
						
						System.out.println("[1] Add comment\n"
								+ "[2] Delete comment\n"
								+ "[0] Go back");
						input = reader.readLine();
						
						if (input.equals("1")) {
							System.out.print("content: ");
							String content = reader.readLine();
							user.commentNews(selectedNews, new Comment(user, content));
						}
						else if (input.equals("2")) {
							if (!comments.isEmpty()) {
								System.out.println("Select your comment: ");
								input = reader.readLine();
								if (comments.containsKey(Integer.parseInt(input)) && user.deleteComment(selectedNews, comments.get(Integer.parseInt(input))))
									System.out.println("--- Comment is successfully removed! ---");
								else 
									System.out.println("--- Error, comment does not exist ---");
							}
							else System.out.println("--- Comments are empty ---");
						}
						else {
							break;
						}
					}
				}
			}
		}
		
	}
	
	
	public static void changePassword(User user) throws IOException {
		System.out.println("--- CHANGE PASSWORD ---");
				
		System.out.print("Password: ");
		String password = reader.readLine();
		System.out.print("New password: ");
		String newPassword = reader.readLine();
		System.out.print("Confirm new password: ");
		String newPassword1 = reader.readLine();
		
		if (!user.checkPassword(password))
			System.out.println("--- Error, incorrect password. Please, try again. ---");
		else if (!newPassword.equals(newPassword1))
			System.out.println("--- Error, new passwords are not same. Please, try again. ---");
		else {
			user.changePassword(newPassword);
			System.out.println("--- Password successfully changed ---");
		}
		
	}
}
