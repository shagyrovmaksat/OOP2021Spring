package uni;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;


public class Library implements Serializable {

	private static final long serialVersionUID = 1L;
	private HashMap<Book, Integer> countOfBooks;
    private Vector<Book> books;
    private Librarian librarian;

    public HashMap<Book, Integer> getCountOfBooks() {
        return this.countOfBooks;
    }
    public void setCountOfBooks(HashMap<Book, Integer> countOfBooks) {
        this.countOfBooks = countOfBooks;
    }

    public Vector<Book> getBooks() {
        return this.books;
    }
    public void setBooks(Vector<Book> books) {
        this.books = books;
    }
   
    public void addBook(Book book) {
    	this.books.add(book);
    }
    
    public void removeBook(Book book) {
    	this.books.remove(book);
    }
}