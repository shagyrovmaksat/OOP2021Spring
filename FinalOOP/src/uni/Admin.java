package uni;

import java.util.HashSet;
import java.util.Vector;

public class Admin extends User {
	
	private static final long serialVersionUID = 1L;

	public Admin() {
    	super();
    }
	
    public Admin(String name, String surname, String password) {
    	super(name, surname, password);
    }
    
    public Vector<LogFile> viewLogFiles() {
    	return Database.logFiles;
    }
    
    public boolean addUser(User user) {
    	if (!Database.users.contains(user))
    		return Database.users.add(user);
    	return false;
    }
    
    public boolean removeUser(int id) {
    	User user = Database.getUserById(id);
    	if (user != null) 
    		return Database.users.remove(user);
    	return false;
    }
    
    public void increaseStudyYear() {
    	for (User user: Database.users) 
    		if (user instanceof Student) {
    			Student student = (Student) user;
    			student.increaseYearOfStudy();
    		}	
    }
    public HashSet<User> viewAllUsers() {
    	return Database.users;
    }
    
}