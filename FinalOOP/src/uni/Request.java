package uni;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Request implements Serializable {
    
    private String title;
    private String content;
    private Date date;
    private Student sender;
    private Boolean signed;
    private Status status;
    
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

    public void changeStatus(Status status) {
    	this.status = status;
    }

    public int hashCode() {
    	return Objects.hash(title, content, date, signed);
    }

    public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj == null || obj.getClass() != this.getClass()) return false;
		
		Request r = (Request) obj;
		return r.signed == this.signed && r.title.equals(this.title) && r.content.equals(this.content) && r.date.equals(this.date);
	}

    public String toString() {
    	return "Title - " + this.title + " Content - " + this.content + " Sender - " + this.sender + " Signed is" + this.signed + " Date - " + this.date;
    } 
}