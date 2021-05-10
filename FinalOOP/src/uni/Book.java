package uni;

import java.io.*;


public class Book implements Serializable, Cloneable {
    
    private String author;
    private String title;
    
    public Book() {}
    
    public Book(String author, String title) {
    	this.setAuthor(author);
    	this.setTitle(title);
    }
    
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	public Object clone() throws CloneNotSupportedException {
		return (Book) super.clone();
	}

	public String toString() {
		return "Author: " + author + ", title: " + title;
	}

}
