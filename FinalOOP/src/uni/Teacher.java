package uni;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

/**
 * Represents Teacher information
 *
 */
public class Teacher extends User implements StatisticsViewable, MessageManageable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Faculty of the teacher
	 */
	private Faculty faculty;
    /**
     * Rank of the teacher
     */
    private Rank rank;
    /**
     * Average rating of the teacher
     */
    private Double avgRate;
    /**
     * HasMap which contains courses of the teacher and students that registered for these courses
     */
    private HashMap<Course, Vector<Student>> coursesWithStudents = new HashMap<Course, Vector<Student>>();
    
    public Teacher() {
    	super();
    }
    
    public Teacher(String name, String surname, String password) {
    	super(name, surname, password);
    }
    
    public Teacher(String name, String surname, String password, Faculty faculty, Rank rank) {
    	this(name, surname, password);
    	this.faculty = faculty;
    	this.rank = rank;
    }
    
    public Set<Course> getCourses() {
        return coursesWithStudents.keySet();
    }
    
    /**Gets courses of the teacher by id
     * @param id course id
     * @return course if exists, otherwise null
     */
    public Course getCourseById(int id) {
    	Set<Course> courses = coursesWithStudents.keySet();
        for (Course course : courses) {
            if(course.getId() == id)
                return course;
        }
        return null;
    }
    
    /**Gets students that registered for course
     * @param course 
     * @return vector of students
     */
    public Vector<Student> getCourseStudents(Course course) {
        return coursesWithStudents.get(course);
    }
    
    public HashMap<Course, Vector<Student>> getCoursesWithStudents() {
    	return coursesWithStudents;
    }
    
    
    /**Adds new course to teacher
     * @param course
     * @return true if successfully added, otherwise false
     */
    public boolean addCourse(Course course) {
    	if (!coursesWithStudents.containsKey(course)) {
    		coursesWithStudents.put(course, new Vector<Student>());
    		return true;
    	}
    	return false;
    }
    
    /**Gets student that registered to teacher's course by id
     * @param id student id
     * @return student if exists, otherwise null
     */
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
    
    /**Updates average rating of the teacher
     * @param rate new rate
     */
    public void updateRate(int rate) {
    	this.avgRate = (this.avgRate + rate) / 2;
    }
    
    public Vector<File> getFiles(Course course_name) {
        for(Course course: Database.courses){
                return course.getCourseFiles();
        }
        return null;
    }
    
    public void deleteFile(File file, Course course) {
        course.deleteCorseFile(file);
    }
    
    public void addFile(File file, Course course) {
        course.addCourseFile(file);
    }
    
    /**Puts mark to student
     * @param student selected student
     * @param mark 
     * @param course
     */
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
				+ coursesWithStudents + "]";
	}
    

}