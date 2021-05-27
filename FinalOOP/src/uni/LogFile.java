package uni;

import java.io.Serializable;
import java.util.Date;

public class LogFile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String username;
    private LogType type;
    private Date date;
    
    LogFile() {}
    LogFile(User user, LogType type) {
    	this.username = user.getUsername();
    	this.userId = user.getId();
    	this.type = type;
    	this.date = new Date();
    }

    public String getUsername() {
        return this.username;
    }
    
    public int getUserId() {
    	return this.userId;
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
    

	@Override
	public String toString() {
		return "LogFile [username=" + username + ", type=" + type + ", date=" + date + "]";
	}
}
