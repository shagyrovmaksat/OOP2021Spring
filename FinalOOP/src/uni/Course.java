package uni;

import uni.enums.CourseType;
import uni.enums.Faculty;

import java.io.Serializable;
import java.util.Vector;

public class Course implements Serializable {
    
	private int id;
	private String name;
	private String description;
	private int credits;
	private int limitOfStudents;
	private Faculty faculty;
	private Vector<File> courseFiles = new Vector<File>();
	private Vector<Course> prerequisites = new Vector<Course>();
	private CourseType courseType;
	private Vector<Lesson> lessons = new Vector<Lesson>();
	private static int nextID = 0;
	
	
	{
		id = nextID++;
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

	public boolean addCourseFile(File courseFile) {
		return courseFiles.add(courseFile);
	}
	
	public boolean deleteCorseFile(File courseFile) {
		return courseFiles.remove(courseFile);
	}

	public Vector<Course> getPrerequisites() {
		return prerequisites;
	}

	public boolean addPrerequisite(Course prerequisite) {
		return prerequisites.add(prerequisite);
	}
	
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

	public boolean addLesson(Lesson lesson) {
		return lessons.add(lesson);
	}
	
	public boolean deleteLesson(Lesson lesson) {
		return lessons.remove(lesson);
	}
	
	//?
	public int hashCode() {
		return Objects.hash(name, description, credits, limitOfStudents);
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
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
