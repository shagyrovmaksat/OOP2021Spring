package uni;
import java.io.*;
import java.util.*;

public class Database implements Serializable {
	public static Library library;
    public static HashSet<User> users;
    public static Vector<News> news;
    public static Vector<LogFile> logFiles;
    public static Vector<Course> courses;
    public static Map<String, Integer> idCounter = Map.of("userId", 0, "courseId", 0, "commentId", 0);

    public static boolean registrationIsOpen;

    public Database() {}
    
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
