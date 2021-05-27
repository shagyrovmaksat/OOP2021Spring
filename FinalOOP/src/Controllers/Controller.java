package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import uni.*;

public class Controller {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Database.loadDatabase();
		Admin admin = new Admin("Admin", "Adminovich", "12345");
		Teacher teacher = new Teacher("Beisenbek", "Baisakov", "123456");
		Librarian librarian = new Librarian("Sample", "Sample", "123456");

		Student student1 = new Student("Adil", "Kumashev", "a_kumashev@kbtu.kz");
		Student student2 = new Student("Magzhan", "Zhumadilov", "m_zhumadilov@kbtu.kz");
		Student student3 = new Student("Roman", "Biryukov", "r_biryukov@kbtu.kz");
		Student student4 = new Student("Adilzhan", "Dzhumakanov", "a_dzhumakanov@kbtu.kz");

		Course course = new Course("PP2", "basics", 4, 50, Faculty.FIT, CourseType.REQUIRED);
		Course course2 = new Course("PP1", "basics", 4, 50, Faculty.FIT, CourseType.REQUIRED);
		Course course3 = new Course("ADS", "basics", 4, 50, Faculty.FIT, CourseType.REQUIRED);

		Vector<Student> students = new Vector<Student>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);

		teacher.getCoursesWithStudents().put(course, students);
		teacher.getCoursesWithStudents().put(course2, students);
		teacher.getCoursesWithStudents().put(course3, students);

		Book book1 = new Book("To Kill a Mockingbird", "Harper Lee");
		Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
		Book book3 = new Book("Jane Eyre", "Charlotte Bronte");

		librarian.addBook(book1);
		librarian.addBook(book2);
		librarian.addBook(book3);

		//librarian.giveBook(book1, student1);
		//librarian.giveBook(book2, student1);
		//librarian.giveBook(book3, student1);

		Database.users.add(librarian);

		Database.courses.add(course);
		Database.courses.add(course2);
		Database.courses.add(course3);

		Database.users.add(student1);
		Database.users.add(student2);
		Database.users.add(student3);
		Database.users.add(student4);


		Database.users.add(admin);
		Database.users.add(teacher);

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
							AdminController.showMenu(user, reader);
						else if (user instanceof Manager)
							ManagerController.showMenu((Manager)user);
						else if (user instanceof Student)
							StudentController.showMenu((Student)user);
						else if (user instanceof Teacher)
							TeacherController.showMenu((Teacher) user);
						else if (user instanceof Librarian)
							LibrarianController.showMenu((Librarian) user);
					}
				}
			}
			else if (input.equals("2")) {
				Database.saveDatabase();
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
