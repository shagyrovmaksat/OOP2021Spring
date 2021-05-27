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

	public static FileInputStream fis;
	public static ObjectInputStream oin;


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

    public static void loadDatabase() {
		loadCourses();
		loadMessages();
		loadFiles();
		loadNews();
		loadUsers();
		loadIdCounter();
    }

    public static void saveDatabase() {
       saveUser();
       saveCourses();
       saveIdCounter();
       saveNews();
       saveMessages();
       saveLogFiles();
    }

    //------------------------------------------------SERIALIZATION------------------------------------------------

    public static void saveUser(){
    	try(ObjectOutputStream oot =  new ObjectOutputStream(new FileOutputStream("users.txt"))){
    		oot.writeObject(users);
			oot.flush();
		} catch (IOException e){
    		System.err.println("IOException - users");
		}
	}

    public static void saveCourses(){
    	try(ObjectOutputStream oot =  new ObjectOutputStream(new FileOutputStream("courses.txt"))){
    		oot.writeObject(courses);
			oot.flush();
		} catch (IOException e){
    		System.err.println("IOException - courses");
		}
	}

    public static void saveIdCounter(){
    	try(ObjectOutputStream oot =  new ObjectOutputStream(new FileOutputStream("idCounter.txt"))){
    		oot.writeObject(idCounter);
			oot.flush();
		} catch (IOException e){
    		System.err.println("IOException - idCounter");
		}
	}

	public static void saveMessages(){
    	try(ObjectOutputStream oot =  new ObjectOutputStream(new FileOutputStream("messages.txt"))){
    		oot.writeObject(messages);
			oot.flush();
		} catch (IOException e){
    		System.err.println("IOException - messages");
		}
	}

	public static void saveNews(){
    	try(ObjectOutputStream oot =  new ObjectOutputStream(new FileOutputStream("news.txt"))){
    		oot.writeObject(news);
			oot.flush();
		} catch (IOException e){
    		System.err.println("IOException - news");
		}
	}

	public static void saveLogFiles(){
    	try(ObjectOutputStream oot =  new ObjectOutputStream(new FileOutputStream("logFiles.txt"))){
    		oot.writeObject(logFiles);
			oot.flush();
		} catch (IOException e){
    		System.err.println("IOException - logFiles");
		}
	}

	//----------------------------------------------DESERIALIZATION------------------------------------------------

	public static void loadUsers(){
    	try {
			fis = new FileInputStream("users.txt");
			oin = new ObjectInputStream(fis);
			users = (HashSet<User>) oin.readObject();
			oin.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void loadFiles(){
    	try {
			fis = new FileInputStream("logFiles.txt");
			oin = new ObjectInputStream(fis);
			logFiles= (Vector<LogFile>) oin.readObject();
			oin.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void loadNews(){
    	try {
			fis = new FileInputStream("news.txt");
			oin = new ObjectInputStream(fis);
			news = (HashSet<News>) oin.readObject();
			oin.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void loadMessages(){
    	try {
			fis = new FileInputStream("messages.txt");
			oin = new ObjectInputStream(fis);
			messages = (Vector<Message>) oin.readObject();
			oin.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void loadCourses(){
    	try {
			fis = new FileInputStream("courses.txt");
			oin = new ObjectInputStream(fis);
			courses = (Vector<Course>) oin.readObject();
			oin.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void loadIdCounter(){
    	try {
			fis = new FileInputStream("idCounter.txt");
			oin = new ObjectInputStream(fis);
			idCounter = (Map<String, Integer>) oin.readObject();
			oin.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


}