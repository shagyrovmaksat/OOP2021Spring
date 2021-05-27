package uni;
import java.io.*;
import java.util.*;

public class Database implements Serializable {

	private static final long serialVersionUID = 1L;
	public static Library library;
    public static HashSet<User> users = new HashSet<User>();

    public static Vector<Message> messages = new Vector<>();
    public static boolean registrationIsOpen;

    
    public static HashSet<News> news = new HashSet<News>();
    public static Vector<LogFile> logFiles = new Vector<LogFile>();
    public static Vector<Course> courses = new Vector<Course>();


    public static Map<String, Integer> idCounter = new HashMap<String, Integer>();
    static {
    	idCounter.put("userId", 1);
    	idCounter.put("courseId", 1);
    	idCounter.put("newsId", 1);
    	idCounter.put("commentId", 1);
    	idCounter.put("requestId", 1);
    	
//    	users.put("Teachers", new HashSet<User>());
//    	users.put("Students", new HashSet<User>());
//    	users.put("Managers", new HashSet<User>());
//    	users.put("Admins", new HashSet<User>());
//    	users.put("Librarians", new HashSet<User>());
    }
    
    public Database() {}
    
    
    public static Teacher getTeacherByCourse(Course course) {
    	for (User user: users) {
    		if (user instanceof Teacher) {
    			Teacher t = (Teacher) user;
    			if (t.getCoursesWithStudents().containsKey(course))
    				return t;
    		}
    	}
    	return null;
    }
    
    public static User getUserByUsername(String username) {
		for (User user: users)
			if (user.getUsername().equals(username))
				return user;
		return null;
//    	for (String key: users.keySet())
//    		for (User user: users.get(key))
//    			if (user.getUsername().equals(username))
//    				return user;
//    	return null;
	}
    
    public static User getUserById(int id) {
    	for (User user: users)
    		if (user.getId() == id)
    			return user;
    	return null;
    }

    public static Vector<Teacher> getTeachers() {
    	Vector<Teacher> teachers = new Vector<Teacher>(); 
    	for(User u : users) {
    		if(u instanceof Teacher) teachers.add((Teacher) u);
    	}
    	return teachers;
    }
    
    public static Vector<Student> getStudents() {
    	Vector<Student> students = new Vector<Student>(); 
    	for(User u : users) {
    		if(u instanceof Student) students.add((Student) u);
    	}
    	return students;
    }

    public void loadDatabase() {
        
    }

    public void saveDatabase() {
       
    }   
}