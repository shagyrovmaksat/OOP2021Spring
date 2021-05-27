package Controllers;

import uni.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LibrarianController {
	public static void showMenu(Librarian librarian) throws IOException {
		System.out.println("-------- Librarian: " + librarian.getName() + " " + librarian.getSurname() + " --------");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (librarian.isLoginned()) {
			System.out.println("----------- INPUT ACTION'S NUMBER ------------\n" +
					"[0] EXIT\n" +
					"[1] Librarian's info\n" +
					"[2] List of books\n" +
					"[3] Manage books\n" +
					"[4] Check student's card\n" +
					"[5] Change Password\n" +
					"[6] Log Out\n" +
					"----------------------------------------------\n");
			int input;
			input = Integer.parseInt(reader.readLine());
			switch(input){
				case 0:
					break;
				case 1:
					showInfo(librarian);
					break;
				case 2:
					showBooks(librarian);
					break;
				case 3:
					manageBooks(librarian);
					break;
				case 4:
					studentCard(librarian);
					break;
				case 5:
					changePassword(librarian);
					break;
				case 6:
					logOut(librarian);
					break;
			}
		}
	}

	public static void showInfo(Librarian librarian){
		System.out.println("----------------------------------------------");
		System.out.println("\t" + "Name: " + librarian.getName());
		System.out.println("\t" + "Surname: " + librarian.getSurname());
		System.out.println("\t" + "ID: " + librarian.getId());
		System.out.println("----------------------------------------------\n");
	}

	public static void showBooks(Librarian librarian) throws IOException {
		System.out.println("----------------------------------------------");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("----------- INPUT ACTION'S NUMBER -----------\n" +
				"[0] EXIT\n" +
				"[1] Check book\n" +
				"[2] Add book\n" +
				"[3] Delete book\n" +
				"[4] Show all books");
		System.out.println("----------------------------------------------\n");
		int i;
		i = Integer.parseInt(reader.readLine());
		String book_title;
		String book_author;
		Book book_sample = null;
		switch (i){
			case 0:
				break;
			case 1:
				System.out.println("\t Enter book's title: \n");
				book_title = reader.readLine();
				System.out.println("\t Enter book's author: \n");
				book_author = reader.readLine();

				for(Book book: Database.library.getBooks()){
					if(book.getTitle().equals(book_title) && book.getAuthor().equals(book_author)){
						System.out.println("\t Book exists!" + book.toString() + "\n");
					}
				}
				break;
			case 2:
				System.out.println("\t Enter book's title: \n");
				book_title = reader.readLine();
				System.out.println("\t Enter book's author: \n");
				book_author = reader.readLine();

				for(Book book: Database.library.getBooks()){
					if(book.getTitle().equals(book_title) && book.getAuthor().equals(book_author)){
						System.out.println("\t Book already exists!" + book.toString() + "\n");
					} else{
						book_sample = new Book(book_author, book_title);
					}
				}

				librarian.addBook(book_sample);

				break;
			case 3:
				System.out.println("\t Enter book's title: \n");
				book_title = reader.readLine();
				System.out.println("\t Enter book's author: \n");
				book_author = reader.readLine();

				for(Book book: Database.library.getBooks()){
					if(book.getTitle().equals(book_title) && book.getAuthor().equals(book_author)){
						librarian.deleteBook(book);
					}
				}
				break;
			case 4:
				for(Book book: Database.library.getBooks()){
					System.out.println("\t" + book.toString() + "\n");
				}
				break;
			}
		System.out.println("----------------------------------------------\n");
		}

	public static void manageBooks(Librarian librarian) throws IOException{
		System.out.println("----------------------------------------------");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("----------- INPUT ACTION'S NUMBER -----------\n" +
				"[0] EXIT\n" +
				"[1] Give book\n" +
				"[2] Get book back\n");
		System.out.println("----------------------------------------------\n");
		int i;
		String book_title;
		String book_author;
		Book book_sample = null;
		Student student_sample = null;
		int student_id;
		i = Integer.parseInt(reader.readLine());
		switch (i){
			case 0:
				break;
			case 1:
				System.out.println("\t Enter book's title: \n");
				book_title = reader.readLine();
				System.out.println("\t Enter book's author: \n");
				book_author = reader.readLine();

				for(Book book: Database.library.getBooks()){
					if(book.getTitle().equals(book_title) && book.getAuthor().equals(book_author)){
						book_sample = book;
					} else{
						System.out.println("\tBook does not exist!");
					}
				}

				System.out.println("\t Enter book's title: \n");
				student_id= Integer.parseInt(reader.readLine());

				for(User user: Database.users){
					if(user instanceof Student){
						if(user.getId() == student_id){
							student_sample = (Student) user;
						}
					} else{
						System.out.println("\t Student does not exist!");
					}
				}

				librarian.giveBook(book_sample, student_sample);
				System.out.println("\t Book is successfully given!\n");
				System.out.println("----------------------------------------------\n");
				break;
			case 2:
				System.out.println("\t Enter book's title: \n");
				book_title = reader.readLine();
				System.out.println("\t Enter book's author: \n");
				book_author = reader.readLine();

				for(Book book: Database.library.getBooks()){
					if(book.getTitle().equals(book_title) && book.getAuthor().equals(book_author)){
						book_sample = book;
					} else{
						System.out.println("\tBook does not exist!");
					}
				}

				System.out.println("\t Enter book's title: \n");
				student_id= Integer.parseInt(reader.readLine());

				for(User user: Database.users){
					if(user instanceof Student){
						if(user.getId() == student_id){
							student_sample = (Student) user;
						}
					} else{
						System.out.println("\t Student does not exist!");
					}
				}

				librarian.getBookBack(book_sample, student_sample);
				System.out.println("\t Book is successfully taken back!\n");
				System.out.println("----------------------------------------------\n");
				break;
		}
	}

	public static void studentCard(Librarian librarian) throws IOException{
		System.out.println("----------------------------------------------");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("----------- INPUT ACTION'S NUMBER -----------\n" +
				"[0] EXIT\n" +
				"[1] Students list\n");
		System.out.println("----------------------------------------------\n");
		int i;
		i = Integer.parseInt(reader.readLine());
		switch (i){
			case 0:
				break;
			case 1:
				int cnt = 1;
				for(Student student: librarian.getStudentsWithBook()){
					System.out.println("\t" + "[" + cnt + "]" + " ID: " + student.getId()+ " "
							+ student.getName() + " " + student.getSurname());
					cnt++;
				}
				break;
		}
	}

	public static void changePassword(Librarian librarian) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("--- Change Password ---");

		System.out.print("Password: ");
		String password = reader.readLine();
		System.out.print("New password: ");
		String newPassword = reader.readLine();
		System.out.print("Confirm new password: ");
		String newPassword1 = reader.readLine();

		if (!librarian.checkPassword(password))
			System.out.println("Error, incorrect password. Please, try again.");
		else if (!newPassword.equals(newPassword1))
			System.out.println("Error, new passwords are not same. Please, try again.");
		else {
			librarian.changePassword(newPassword);
			System.out.println("--- Password successfully changed ---");
		}
	}

	public static void logOut(Librarian librarian){
		librarian.logout();
	}
}
