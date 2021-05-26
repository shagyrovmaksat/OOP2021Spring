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
    
    public Comment() {
    }
    
    public Comment(User author, String content) {
    	this.author = author;
    	this.content = content;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + id;
		result = prime * result + ((publishedDate == null) ? 0 : publishedDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (publishedDate == null) {
			if (other.publishedDate != null)
				return false;
		} else if (!publishedDate.equals(other.publishedDate))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Comment [id=" + id + ", author=" + author + ", content=" + content + ", publishedDate=" + publishedDate
				+ "]";
	}
    
}
