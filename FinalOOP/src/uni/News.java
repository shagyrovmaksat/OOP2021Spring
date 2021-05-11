package uni;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

public class News implements Serializable {
    
    private String title;
    private String content;
    private Date publishedDate;
    private Vector<Comment> comments;   

    private String getTitle() {
        return this.title;
    }
    private void setTitle(String title) {
        this.title = title;
    }

    private String getContent() {
        return this.content;
    }
    private void setContent(String content) {
        this.content = content;
    }
    
    private Date getPublishedDate() {
        return this.publishedDate;
    }
    private void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
    
    private Vector<Comment> getComments() {
        return this.comments;
    }
    private void setComments(Vector<Comment> comments) {
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
    
    public String toString() {
    	String res = "Title - " + this.title + " Content - " + this.content + " Published date - " + this.publishedDate + "\n";
    	res += "Comments:\n";
    	for(Comment c : comments) {
    		res += c.toString();
    	}
		return res;
    }
}