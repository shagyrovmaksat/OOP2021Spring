package uni;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User author;
    private String content;
    private Date publishedDate;
    
    public Comment() {}
    
    public Comment(User author, String content, Date publishedDate) {
    	this.author = author;
    	this.content = content;
    	this.publishedDate = publishedDate;
    }
    
    
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getPublishedDate() {
		return publishedDate;
	}
	
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
    
	//?
	public int hashCode() {
		return ;
	}
	
	//?
	public String toString() {
		return content;
	}
    
}
