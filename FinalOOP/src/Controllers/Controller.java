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
						
						System.out.println("\n--- Your are successfully signed in ---\n"
								+ "\n[1] Menu\n"
								+ "[2] News");
						
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
	
	
	public static void showNews(User user) throws IOException {
		
		Map<Integer, News> news = new HashMap<Integer, News>();
		
		Map<Integer, Comment> comments = new HashMap<Integer, Comment>();
		
		
		int cnt = 1;
		
		for (News n: Database.news) {
			System.out.println("[" + cnt + "] " + n.getTitle());
			news.put(cnt, n);
			cnt++;
		}
		
		String input = reader.readLine();
		News selectedNews = news.get(Integer.parseInt(input));
		
		System.out.println(selectedNews.getTitle() + "\n" +
				selectedNews.getContent() + "\n" +
				selectedNews.getPublishedDate());
		
		cnt = 1;
		for(Comment comment: selectedNews.getComments()) {
			System.out.println("   [" + cnt + "] " + comment.getAuthor().getName() + " " + comment.getAuthor().getSurname() + "\n      " +
								comment.getContent() + "\n      " +
								comment.getPublishedDate());
			comments.put(cnt, comment);
			cnt++;
		}
		input = reader.readLine();
		
	}

}
