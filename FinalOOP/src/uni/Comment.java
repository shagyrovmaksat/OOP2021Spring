package uni;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private User author;
    private String content;
    private Date publishedDate = new Date();
    
    {
    	id = Database.idCounter.get("commentId");
    	Database.idCounter.put("commentId", id + 1);
    }
    
    public Comment() {}
    
    public Comment(User author, String content, Date publishedDate) {
    	this.author = author;
    	this.content = content;
    	this.publishedDate = publishedDate;
    }
    
	public int getId() {
		return id;
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

	@Override
	public String toString() {
		return "Comment [id=" + id + ", author=" + author + ", content=" + content + ", publishedDate=" + publishedDate
				+ "]";
	}
    
}
