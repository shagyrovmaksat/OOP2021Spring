package uni;

import java.util.Vector;

public interface StatisticsViewable {
	public default double getMaxGrade(Course course, Teacher teacher) {
		double res = 0;
		Vector<Student> students = teacher.getCourseStudents(course);
		for(Student s : students) {
			double curMark = s.getCourseMark(course).getDigitMark();
			if(curMark > res) {
				res = curMark;
			}
		}
		return res;
	}
	
	public default double getMinGrade(Course course, Teacher teacher) {
		double res = 100;
		Vector<Student> students = teacher.getCourseStudents(course);
		for(Student s : students) {
			double curMark = s.getCourseMark(course).getDigitMark();
			if(curMark < res) {
				res = curMark;
			}
		}
		return res;	
	}
	
	public default double getAvgGrade(Course course, Teacher teacher) {
		Vector<Student> students = teacher.getCourseStudents(course);
		double sum = 0;
		for(Student s : students) {
			sum += s.getCourseMark(course).getDigitMark();
		}
		return sum / students.size();
	}
}
