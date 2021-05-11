package uni;

import java.io.Serializable;
import java.util.Date;

public class LogFile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
    private LogType type;
    private Date date;
    
    LogFile() {}
    LogFile(User user, LogType type) {
    	this.username = user.getUsername();
    	this.type = type;
    	this.date = new Date();
    }

    public String getUsername() {
        return this.username;
    }
    public void setUser(String username) {
        this.username = username;
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

	@Override
	public String toString() {
		return "LogFile [username=" + username + ", type=" + type + ", date=" + date + "]";
	}
}
