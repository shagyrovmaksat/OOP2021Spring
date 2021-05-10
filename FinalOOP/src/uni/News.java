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
    private Date setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
    
    private Vector<Comment> getComments() {
        return this.comments;
    }
    private Vector<Comment> setComments(Vector<Comment> comments) {
        this.comments = comments;
    }

    public void updateDate() {
        
    }
    public void update(String content) {
       
    }

    public void updateComment(Comment comment) {
    	
    }
    
    public void deleteComment(Comment comment) {
        
    }
    
    public String toString() {
		return "";
    }
}
