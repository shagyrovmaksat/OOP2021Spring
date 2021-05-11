package uni;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

public class News implements Serializable {
    
    private String title;
    private String content;
    private Date publishedDate;
    private Vector<Comment> comments;   

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Date getPublishedDate() {
        return this.publishedDate;
    }
    
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
    
    public Vector<Comment> getComments() {
        return this.comments;
    }
    
    public void setComments(Vector<Comment> comments) {
        this.comments = comments;
    }

    public void updateDate() {
        
    }
    
    public void update(String content) {
    	this.setContent(content);
    	//update date
    }

    public void updateComment(Comment comment) {
    	
    }
    
    public void deleteComment(Comment comment) {
        this.comments.remove(comment);
    }
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((publishedDate == null) ? 0 : publishedDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		News other = (News) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (publishedDate == null) {
			if (other.publishedDate != null)
				return false;
		} else if (!publishedDate.equals(other.publishedDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "News [title=" + title + ", content=" + content + ", publishedDate=" + publishedDate + ", comments="
				+ comments + "]";
	}
    
  
}
