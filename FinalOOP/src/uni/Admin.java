package uni;

import java.util.Objects;
import java.util.Vector;

public class Admin extends User {
	
    public Admin() {
    	super();
    }
    
    public Admin(String name, String surname, String username, String password) {
    	super(name, surname, username, password);
    }
    
    public Vector<LogFile> seeLogFiles() {
    	return Database.logFiles;
    }
    
    public boolean addUser(User user) {
    	return Database.users.add(user);
    }
    
    public boolean removeUser(User user) {
    	return Database.users.remove(user);
    }
    
    //?
    public boolean updateUser(User user) {
    	return true;
    }
    
    public int hashCode() {
    	return super.hashCode();
    }
    
    public boolean equals(Object o) {
    	return super.equals(o);
    }
    
    //?
    public String toString() {
    	return "";
    }
}
