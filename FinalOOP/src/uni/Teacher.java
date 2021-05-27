package uni;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;


public class Teacher extends Employee implements StatisticsViewable {

	private static final long serialVersionUID = 1L;
	
	private Faculty faculty;
    private Rank rank;
    private Double avgRate;
    private HashMap<Course, Vector<Student>> coursesWithStudents = new HashMap<Course, Vector<Student>>();
    
    public Teacher() {
    	super();
    }
    
    public Teacher(String name, String surname, String password) {
    	super(name, surname, password, Department.EDUCATIONAL);
    }
    
    public Teacher(String name, String surname, String password, Faculty faculty, Rank rank) {
    	this(name, surname, password);
    	this.faculty = faculty;
    	this.rank = rank;
    }
    
    public Set<Course> getCourses() {
        return coursesWithStudents.keySet();
    }
    
    public Course getCourseById(int id) {
    	Set<Course> courses = coursesWithStudents.keySet();
        for (Course course : courses) {
            if(course.getId() == id)
                return course;
        }
        return null;
    }
    
    public Vector<Student> getCourseStudents(Course course) {
        return coursesWithStudents.get(course);
    }
    
    public HashMap<Course, Vector<Student>> getCoursesWithStudents() {
    	return coursesWithStudents;
    }
    
    public Student getStudentById(int id) {
        for (User user: Database.users){
            if(user.getId() == id){
                return (Student) user;
            }
        }
        return null;
    }
    
    public Rank getRank() {
    	return this.rank;
    }
    
    public void setRank(Rank rank) {
    	this.rank = rank;
    }
    
    public Faculty getFaculty() {
    	return faculty;
    }
    
    public void setFaculty(Faculty faculty) {
    	this.faculty = faculty;
    }
    
    public void updateRate(int rate) {
    	this.avgRate = (this.avgRate + rate) / 2;
    }
    
    public Vector<File> getFiles(Course course) {
    	return course.getCourseFiles();
    }
    
    public void deleteFile(File file, Course course) {
        course.deleteCorseFile(file);
    }
    
    public void addFile(File file, Course course) {
        course.addCourseFile(file);
    }
    
    public void putMark(Student student, Mark mark, Course course) {
        student.getTranscript().updateCourseMark(course, mark);
    }
    
    public int hashCode() {
    	return Objects.hash(faculty, rank, avgRate, coursesWithStudents);
    }

    public boolean equals(Object o) {
    	if(o == this){ return true; }
        if (!(o instanceof Teacher)) {
            return false;
        }
        Teacher t = (Teacher) o;
        return faculty == t.getFaculty() &&
                rank == t.getRank() && avgRate == t.avgRate &&
                coursesWithStudents.equals(t.coursesWithStudents);
    }

	@Override
	public String toString() {
		return "Teacher [faculty=" + faculty + ", rank=" + rank + ", avgRate=" + avgRate + ", coursesWithStudents="
				+ coursesWithStudents + ", department=" + department + ", messages=" + messages + "]";
	}
    

}