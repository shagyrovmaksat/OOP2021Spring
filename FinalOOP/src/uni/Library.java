package uni;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;


public class Library implements Serializable {

	private static final long serialVersionUID = 1L;
	private HashMap<Book, Integer> countOfBooks;
    private Vector<Book> books;    

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
}