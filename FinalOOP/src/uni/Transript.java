package uni;

import java.io.Serializable;
import java.util.HashMap;

public class Transript implements Serializable {
	HashMap<Course, Mark> coursesAndMarks = new HashMap<Course, Mark>();
	
	public HashMap<Course, Mark> getCoursesAndMarks() {
		return this.coursesAndMarks;
	}
	
	public void addCourseAndMark(Course course, Mark mark) {
		
	}
	
	public void updateCourseMark(Course course, Mark mark) {
		
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
}