package classes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;


public class Library implements Serializable {

    private HashMap<Book, int> countOfBooks;
    private Vector<Book> books;
    private Set<Librarian> librarian;
    private Database database;
    private Set<Book> book;
    
    

    public HashMap<Book, int> getCountOfBooks() {
        return this.countOfBooks;
    }

    public void setCountOfBooks(HashMap<Book, int> countOfBooks) {
        this.countOfBooks = countOfBooks;
    }

    public Vector<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Vector<Book> books) {
        this.books = books;
    }

    public Librarian getLibrarian() {
        return (Librarian) this.librarian;
    }

    public void setLibrarian(Librarian librarian) {
        //this.librarian = (Set<Librarian>) librarian;
    }

    public Book getBook() {
        return (Book) this.book;
    }

    public void setBook(Book book) {
     //   this.book = (Set<Book>) book;
    }

    public Database getDatabase() {
        return this.database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
    
}
