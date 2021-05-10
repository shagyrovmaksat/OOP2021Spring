
package uni;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable, Comparable  {

    private String content;
    private Date date;
    private Employee author;
    private Employee receiver;

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

    public Employee getAuthor() {
        return this.author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    public Employee getReceiver() {
        return this.receiver;
    }

    public void setReceiver(Employee receiver) {
        this.receiver = receiver;
    }
    
    public int hashCode() {
        //TODO
        return 0;
    }

    public boolean equals() {
        //TODO
        return false;
    }

    public String toString() {
        //TODO
        return "";
    }

    public int compareTo(Object o) {
        return 0;
    }
}
