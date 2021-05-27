package uni;
import java.io.*;
import java.util.*;

public class Database implements Serializable {

	private static final long serialVersionUID = 1L;
	public static Library library;
	
    public static HashSet<User> users;
    public static Vector<Message> messages;

    public static boolean registrationIsOpen;

    public static HashSet<Teacher> teachers = new HashSet<Teacher>();
    
    public static HashSet<News> news = new HashSet<News>();
    public static Vector<LogFile> logFiles = new Vector<LogFile>();
    public static Vector<Course> courses = new Vector<Course>();

    public static HashMap<Course, Map<Teacher, Vector<Student>>> courseInfo = new HashMap<Course, Map<Teacher, Vector<Student>>>();
    public static Map<String, Integer> idCounter = new HashMap<String, Integer>();
    static {
    	idCounter.put("userId", 0);
    	idCounter.put("courseId", 0);
    	idCounter.put("newsId", 0);
    	idCounter.put("commentId", 0);
    }
    
    public Database() {}
    
    public static Teacher getTeacherByCourse(Course course) {
    	for (Teacher t: teachers) {
    		if (t.getCoursesWithStudents().containsKey(course))
    			return t;
    	}
    	return null;
    }
    
    public static User getUserByUsername(String username) {
		for (User user: users)
			if (user.getUsername().equals(username))
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