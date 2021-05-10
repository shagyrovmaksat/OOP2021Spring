package uni;

import java.io.Serializable;
import java.util.Date;

public class Request implements Serializable {
    
    private String title;
    private String content;
    private Date date;
    private Student sender;
    private Boolean signed;
    private Status status;
    
    public getTitle() {
    	return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content; 
    }
    public void setContent(String content) {
        
    }

    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Student getSender() {
        return this.sender;
    }
    
    public void sign() {
    	this.signed = true;
    }

    public void changeStatus() {

    }

    public int hashCode() {

    }

    public boolean equals() {

    }

    public String toString() {
    	
    } 
}