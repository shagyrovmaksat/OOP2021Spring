package uni;

import java.util.HashMap;
import java.util.Vector;

public class Librarian extends Employee {

	private static final long serialVersionUID = 1L;
	private HashMap<Student, Vector<Book>> studentsWithBooks;
                               
    public void giveBook(Book book, Student student) {
    	studentsWithBooks.get(student).add(book);
    }

    public void getBookBack(Book book, Student student) {
    	studentsWithBooks.get(student).remove(book);
    }

    public Vector<Book> getListOfBooks() {
		return Database.library.getBooks();
    }

    public boolean isThereBookInTheLibrary(Book book) {
		return false;
    }

    public void addBook(Book book) {
    	Database.library.addBook(book);
    }

    public void deleteBook(Book book) {
        Database.library.removeBook(book);
    }

    public Vector<Student> getStudentsWithBook() {
		return null;
    }

	public HashMap<Student, Vector<Book>> getStudentsWithBooks() {
		return studentsWithBooks;
	}
	public void setStudentsWithBooks(HashMap<Student, Vector<Book>> studentsWithBooks) {
		this.studentsWithBooks = studentsWithBooks;
	}
}