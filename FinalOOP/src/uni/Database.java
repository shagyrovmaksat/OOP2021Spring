package uni;
import java.io.*;
import java.util.*;


public class Database implements Serializable {
	public static Library library;
    public static HashSet<User> users;
    public static Vector<News> news;
    public static Vector<LogFile> logFiles;
    public static Vector<Course> courses;

    public static boolean registrationIsOpen;
    
    public Database() {}
    

    public boolean addUser(User user) {
        return users.add(user);
    }
 
    public boolean deleteUser(User user) {
        return users.remove(user);
    }

    //?
    public boolean updateUser(User user) {
    	return true;
    }

    public boolean addNews(News news) {
        return Database.news.add(news);
    }

    public boolean deleteNews(News news) {
        return Database.news.remove(news);
    }

    //?
    public boolean updateNews(News news) {
        
        return true;
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