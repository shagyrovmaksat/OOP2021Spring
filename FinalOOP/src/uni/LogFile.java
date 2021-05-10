package uni;

import java.io.Serializable;
import java.util.Date;

public class LogFile implements Serializable {

    private User user;
    private LogType type;
    private Date date;

    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public LogType getType() {
        return this.type;
    }
    public void setType(LogType type) {
        this.type = type;
    }

    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    //need to add log type
    public String toString() {
        return this.user + " Date - " + this.date;
    }
    
}
