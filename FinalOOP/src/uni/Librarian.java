package uni;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class Librarian extends User {

	private static final long serialVersionUID = 1L;
	private HashMap<Student, Vector<Book>> studentsWithBooks = new HashMap<Student, Vector<Book>>();
                               
    public Librarian(String name, String surname, String password) {
		super(name, surname, password);
	}

    public void giveBook(Book book, Student student) {
    	studentsWithBooks.get(student).add(book);
    } // manage books

    public void getBookBack(Book book, Student student) {
    	studentsWithBooks.get(student).remove(book);
    } // manage books

    public Vector<Book> getListOfBooks() {
		return Database.library.getBooks();
    }

    public boolean isThereBookInTheLibrary(Book book) {
		return false;
    } //Show list of books

    public void addBook(Book book) {
    	Database.library.addBook(book);
    } //Show list of books

    public void deleteBook(Book book) {
        Database.library.removeBook(book);
    } //Show list of books

    public Set<Student> getStudentsWithBook() {
		return studentsWithBooks.keySet();
    } // student's book card

	public HashMap<Student, Vector<Book>> getStudentsWithBooks() {
		return studentsWithBooks;
	} // student's book card
	public void setStudentsWithBooks(HashMap<Student, Vector<Book>> studentsWithBooks) {
		this.studentsWithBooks = studentsWithBooks;
	}
}