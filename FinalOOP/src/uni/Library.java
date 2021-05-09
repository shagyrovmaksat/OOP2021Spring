package Library;


/**
* @generated
*/
public class Library implements Serializable {
    
    /**
    * @generated
    */
    private HashMap<Book, int> countOfBooks;
    
    /**
    * @generated
    */
    private Vector<Book> books;
    
    
    /**
    * @generated
    */
    private Set<Librarian> librarian;
    
    /**
    * @generated
    */
    private Database database;
    
    /**
    * @generated
    */
    private Set<Book> book;
    
    
    /**
    * @generated
    */
    public HashMap<Book, int> getCountOfBooks() {
        return this.countOfBooks;
    }
    
    /**
    * @generated
    */
    public HashMap<Book, int> setCountOfBooks(HashMap<Book, int> countOfBooks) {
        this.countOfBooks = countOfBooks;
    }
    
    /**
    * @generated
    */
    public Vector<Book> getBooks() {
        return this.books;
    }
    
    /**
    * @generated
    */
    public Vector<Book> setBooks(Vector<Book> books) {
        this.books = books;
    }
    
    
    /**
    * @generated
    */
    public Librarian getLibrarian() {
        return this.librarian;
    }
    
    /**
    * @generated
    */
    public Librarian setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }
    
    /**
    * @generated
    */
    public Book getBook() {
        return this.book;
    }
    
    /**
    * @generated
    */
    public Book setBook(Book book) {
        this.book = book;
    }
    
    /**
    * @generated
    */
    public Database getDatabase() {
        return this.database;
    }
    
    /**
    * @generated
    */
    public Database setDatabase(Database database) {
        this.database = database;
    }
    
}
