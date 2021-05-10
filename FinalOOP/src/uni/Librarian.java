package classes;

import java.util.HashMap;
import java.util.Vector;

public class Librarian extends Employee {
    

    private HashMap<Student, Vector<Book>> StudentsWithBooks;
    private Database database;
    private Library library;
    private HashMap<Student, Vector<Book>> getStudentsWithBooks() {
        return this.StudentsWithBooks;
    }


    private void setStudentsWithBooks(HashMap<Student, Vector<Book>> StudentsWithBooks) {
        this.StudentsWithBooks = StudentsWithBooks;
    }

    public Library getLibrary() {
        return this.library;
    }
    

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Database get() {
        return this.database;
    }

    public void set(Database database) {
        this.database = database;
    }
    

    //                          Operations                                  

    public giveBook() {
        //TODO
    }

    public getBookBack() {
        //TODO
    }

    public getListOfBooks() {
        //TODO
    }

    public isThereBookInTheLibrary() {
        //TODO
    }

    public addBook() {
        //TODO
    }

    public deleteBook() {
        //TODO
    }

    public getStudentsWithBook() {
        //TODO
    }
    
}
