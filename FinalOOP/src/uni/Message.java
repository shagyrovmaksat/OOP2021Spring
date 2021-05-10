
package uni;

import java.io.Serializable;
import java.util.Date;



public class Message implements Serializable, Comparable  {

    private String content;
    private Date date;
    private Employee author;
    private Employee receiver;
    private Employee employee;
    private Database database;


    private String getContent() {
        return this.content;
    }

    private void setContent(String content) {
        this.content = content;
    }

    private Date getDate() {
        return this.date;
    }

    private void setDate(Date date) {
        this.date = date;
    }

    private Employee getAuthor() {
        return this.author;
    }

    private void setAuthor(Employee author) {
        this.author = author;
    }

    private Employee getReceiver() {
        return this.receiver;
    }

    private void setReceiver(Employee receiver) {
        this.receiver = receiver;
    }

    public Database getDatabase() {
        return this.database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    

    //                          Operations                                  

    public getContent() {
        //TODO
    }

    public setContent() {
        //TODO
    }

    public getDate() {
        //TODO
    }

    public setDate() {
        //TODO
    }

    public compareTo() {
        //TODO
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

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
