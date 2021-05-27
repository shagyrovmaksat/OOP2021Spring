package uni;

import java.io.Serializable;

import java.util.Objects;
import java.util.Vector;

/**
 * Represents course information
 *
 */
public class Course implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	/**
	 * Id of the course
	 */
	private int id;
	/**
	 * Name of the course
	 */
	private String name;
	/**
	 * Description of the course
	 */
	private String description;
	/**
	 * Cost in credits
	 */
	private int credits;
	/**
	 * Max count of students that can register for course
	 */
	private int limitOfStudents;
	/**
	 * Count of students that registered for course
	 */
	private int countOfStudents;
	
	/**
	 * Faculty of course
	 */
	private Faculty faculty;
	/**
	 * Course files
	 */
	private Vector<File> courseFiles = new Vector<File>();
	/**
	 * Prerequisites of the course
	 */
	private Vector<Course> prerequisites = new Vector<Course>();
	/**
	 * Type of the Course (Elective, Required)
	 */
	private CourseType courseType;
	
	private Vector<Lesson> lessons = new Vector<Lesson>();
	{
		id = Database.idCounter.get("courseId");
		Database.idCounter.put("courseId", id + 1);
	}
	
	public Course() {}
	
	public Course(String name, String description, int credits, int limitOfStudents, Faculty faculty, CourseType courseType) {
		this.setName(name);
		this.setDescription(description);
		this.setCredits(credits);
		this.setLimitOfStudents(limitOfStudents);
		this.setFaculty(faculty);
		this.setCourseType(courseType);
	}
	
	public Course(String name, String description, int credits, int limitOfStudents, Faculty faculty, CourseType courseType, Vector<Course> prerequisites) {
		this(name, description, credits, limitOfStudents, faculty, courseType);
		this.prerequisites = prerequisites;
	}
	
	public int getId() {
		return id;
	}
	
	/**
	 * Increases count of students registered for course
	 */
	public void increaseCountOfStudents() {
		countOfStudents++;
	}
	
	/**
	 * Decreases count of students registered for course
	 */
	public void decreaseCountOfStudents() {
		countOfStudents--;
	}
	
	public int getCountOfStudents() {
		return countOfStudents;
	}
	
	public void setCountOfStudents(int countOfStudents) {
		this.countOfStudents = countOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getLimitOfStudents() {
		return limitOfStudents;
	}

	public void setLimitOfStudents(int limitOfStudents) {
		this.limitOfStudents = limitOfStudents;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Vector<File> getCourseFiles() {
		return courseFiles;
	}

	/**Adds course file to course
	 * @param courseFile new course file
	 * @return true if successfully added, otherwise false
	 */
	public boolean addCourseFile(File courseFile) {
		return courseFiles.add(courseFile);
	}
	
	/**Removes course file from course
	 * @param courseFile new course file
	 * @return true if successfully removed, otherwise false
	 */
	public boolean deleteCorseFile(File courseFile) {
		return courseFiles.remove(courseFile);
	}

	public Vector<Course> getPrerequisites() {
		return prerequisites;
	}
	
	
	/**Adds prerequisite to course
	 * @param prerequisite prerequisite course
	 * @return true if successfully added, otherwise false
	 */
	public boolean addPrerequisite(Course prerequisite) {
		return prerequisites.add(prerequisite);
	}
	
	/**Removes prerequisite from course
	 * @param prerequisite prerequisite course
	 * @return true if successfully removed, otherwise false
	 */
	public boolean deletePrerequisite(Course prerequisite) {
		return prerequisites.remove(prerequisite);
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	public Vector<Lesson> getLessons() {
		return lessons;
	}

	/**Adds lesson for course
	 * @param lesson
	 * @return true if successfully added, otherwise false
	 */
	public boolean addLesson(Lesson lesson) {
		return lessons.add(lesson);
	}
	
	/**Removes lesson from course
	 * @param lesson
	 * @return true if successfully removed, otherwise false
	 */
	public boolean deleteLesson(Lesson lesson) {
		return lessons.remove(lesson);
	}
	
	public int hashCode() {
		return Objects.hash(name, description, credits, limitOfStudents);
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		
		Course c = (Course) o;
		return id == c.id;
	}
	
	public String toString() {
		return "Course id: " + id + 
				"\nname: " + name + 
				"\ndescription: " + description + 
				"\ncredits: " + credits + 
				"\nlimit of students: " + limitOfStudents + 
				"\nfaculty: " + faculty;
	}
}
