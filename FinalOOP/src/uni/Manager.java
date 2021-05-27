package uni;

import java.util.Vector;

/**
 * Represents Manager information
 *
 */
public class Manager extends User implements StatisticsViewable, MessageManageable {

	private static final long serialVersionUID = 1L;
    
    public Manager() {
    	super();
    }
    
    public Manager(String name, String surname, String password) {
    	super(name, surname, password);
    }

    /**Adds new course to database
     * @param course
     */
    public void addNewCourse(Course course) {
        Database.courses.add(course);
    }

    /**Deletes course from database
     * @param course
     */
    public void deleteCourse(Course course) {
        Database.courses.remove(course);
        Teacher t = Database.getTeacherByCourse(course);
        for (Student s: t.getCourseStudents(course))
        	s.getCourses().remove(course);
        t.getCoursesWithStudents().remove(course);
        
    }

    /**
     * Opens registration
     */
    public void openRegistration() {
        Database.registrationIsOpen = true;
    }

    /**
     * Closes registration
     */
    public void closeRegistration() {
        Database.registrationIsOpen = false;
    }

    /**Assigns teacher to lesson
     * @param teacher
     * @param lesson
     */
    public void assignTeacherToLesson(Teacher teacher, Lesson lesson) {
        lesson.setInstructor(teacher);
    }

    /**Assigns lesson to student
     * @param lesson
     * @param students
     */
    public void assignLessonToStudents(Lesson lesson, Vector<Student> students) {
        for(Student student : students) {
        	student.getSchedule().addLesson(lesson);
        }
    }

    public String getInfoAboutStudent(Student student) {
        return student.toString();
    }

    public String getInfoAboutTeacher(Teacher teacher) {
        return teacher.toString();
    }

    /**Adds new news to database
     * @param news
     */
    public void addNews(News news) {
        Database.news.add(news);
    }

    /**Removes news from database
     * @param news
     */
    public void deleteNews(News news) {
        Database.news.remove(news);
    }
    
    public String toString() {
        return "Manager - " + super.toString();
    }
}
