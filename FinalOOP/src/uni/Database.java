package uni;
import java.io.*;
import java.util.*;

public class Database implements Serializable {

	private static final long serialVersionUID = 1L;
	public static Library library;
    public static HashSet<User> users = new HashSet<User>();
    public static HashSet<News> news = new HashSet<News>();
    public static Vector<LogFile> logFiles = new Vector<LogFile>();
    public static Vector<Course> courses = new Vector<Course>();
    public static Map<String, Integer> idCounter = new HashMap<String, Integer>();

    public static boolean registrationIsOpen;

    public Database() {
    	idCounter.put("userId", 0);
    	idCounter.put("courseId", 0);
    	idCounter.put("commentId", 0);
    }
    
    public boolean addCourse(Course course) {
        return courses.add(course);
    }

    public boolean deleteCourse(Course course) {
        return courses.remove(course);
    }
  
    public boolean addLogFile(LogFile logfile) {
        return logFiles.add(logfile);
    }

    public void loadDatabase() {
        
    }

    public void saveDatabase() {
       
    }   
}
