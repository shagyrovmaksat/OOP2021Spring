package uni;

import java.util.Vector;

public class Admin extends User {
	
	private static final long serialVersionUID = 1L;

	public Admin() {
    	super();
    }
	
    public Admin(String name, String surname, String password) {
    	super(name, surname, password);
    }
    
    public Vector<LogFile> seeLogFiles() {
    	return Database.logFiles;
    }
    
    public boolean addUser(User newUser) {
    	for (User user : Database.users) {
    		if(user.getUsername().equals(newUser.getUsername())) {
    			return false;
    		}
    	}
    	
    	Database.users.add(newUser);
    	return true;
    }
    
    public boolean removeUser(User user) {
    	return Database.users.remove(user);
    }
    
    //?
    public void updateUser(User user) {
    	
    }
}