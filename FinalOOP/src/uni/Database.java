package uni;
import java.io.*;
import java.util.*;

class Database implements Serializable {
	public static Library library;
    public static HashSet<User> users;
    public static Vector<News> news;
    public static Vector<LogFile> logFiles;
    public static Vector<Course> courses;

    public static boolean registrationIsOpen;
    
    //counters for User, Course classes
//    public static Map<String, Integer> counters = new HashMap<>() {
//    	counters.put("userId", 1);
//    	counters.put("courseId", 1);
//    }
    
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