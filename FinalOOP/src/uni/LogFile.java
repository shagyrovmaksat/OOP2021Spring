package classes;
import java.util.Date;

public class LogFile implements Serializable {

    private User user;
    private LogType type;
    private Date date;
    private Database database;


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

    public Database getDatabase() {
        return this.database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
    

    //                          Operations                                  

    public String toString() {
        //TODO
        return "";
    }
    
}
