package uni;

import java.util.HashMap;
import java.util.Vector;

public class Librarian extends Employee {

	private static final long serialVersionUID = 1L;
	private HashMap<Student, Vector<Book>> StudentsWithBooks;
                               
    public void giveBook(Book book, Student student) {

    }

    public void getBookBack(Book book, Student student) {
        
    }

    public Vector<Book> getListOfBooks() {
		return Database.library.getBooks();
    }

    public boolean isThereBookInTheLibrary(Book book) {
		return false;
    }

    public void addBook(Book book) {

    }

    public void deleteBook(Book book) {
        
    }

    public Vector<Student> getStudentsWithBook() {
		return null;
    }

	public HashMap<Student, Vector<Book>> getStudentsWithBooks() {
		return StudentsWithBooks;
	}
	public void setStudentsWithBooks(HashMap<Student, Vector<Book>> studentsWithBooks) {
		StudentsWithBooks = studentsWithBooks;
	}
}