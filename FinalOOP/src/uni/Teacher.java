package uni;

import java.util.HashMap;
import java.util.Vector;

public class Teacher extends Employee implements StatisticsViewable {
    private Faculty faculty;
    private Rank rank;
    private Double avgRate;
    private HashMap<Course,Vector<Student>> coursesWithStudents;
    
    public Vector<Course> getCourses() {
    	
    }
    
    public Course getCourseById(int id) {
    	
    }
    
    public Vector<Student> getCourseStudents(Course course) {
    	
    }
    
    public Student getStudentById(String id) {
		return null;
    }
    
    public Rank getRank() {
    	return this.rank;
    }
    
    public void updateRate(int rate) {
    	this.avgRate = (this.avgRate + rate) / 2;
    }
    
    public Vector<File> getFiles(Course course) {
    	
    }
    
    public void deleteFile(File file, Course course) {
    	 
    }
    
    public void addFile(File file, Course course) {
   	 
    }
    
    public void putMark(Student student, Mark mark, Course course) {
    	
    }
    
    public int compareTo(Teacher teacher) {
    	return 0;
    }
    
    public int hashCode() {
    	return 0;
    }
    
    public boolean equals(Object o) {
    	return true;
    }
    
    public String toString() {
    	return "";
    }

	@Override
	public Vector<Message> viewMessagesToMe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Message> viewMessagesFromMe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getMaxGrade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMinGrade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAvgGrade() {
		// TODO Auto-generated method stub
		return 0;
	}
}
