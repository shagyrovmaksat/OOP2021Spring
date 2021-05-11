package uni;

import java.util.Queue;
import java.util.Vector;

public class Manager extends Employee implements StatisticsViewable {

	private static final long serialVersionUID = 1L;
	
	private Queue<Request> requests;
    private ManagerType type;

    public int countOfRequests() {
        return this.requests.size();
    }

    public void addRequest(Request request) {
        this.requests.add(request);
    }

    public Request takeRequest() {
        return this.requests.poll();
    }

    public void addNewCourse(Course course) {
        Database.courses.add(course);
    }

    public void deleteNewCourse(Course course) {
        Database.courses.remove(course);
    }

    public void openRegistration() {
        Database.registrationIsOpen = true;
    }

    public void closeRegistration() {
        Database.registrationIsOpen = false;
    }

    public void assignTeacherToLesson(Teacher teacher, Lesson lesson) {
        lesson.setInstructor(teacher);
    }

    public void assignLessonToStudents(Lesson lesson, Vector<Student> students) {
        for(Student student : students) {
        	student.getSchedule().addLesson(lesson);
        }
    }

    public Vector<Teacher> getListOfTeachers() {
		return null;
    }

    public Vector<Student> getListOfStudents() {
		return null;
    }

    public String getInfoAboutStudent(Student student) {
        return student.toString();
    }

    public String getInfoAboutTeacher(Teacher teacher) {
        return teacher.toString();
    }

    public ManagerType getType() {
        return this.type;
    }

    public void setType(ManagerType type) {
        this.type = type;
    }

    public void addNews(News news) {
        Database.news.add(news);
    }

    public void deleteNews(News news) {
        Database.news.remove(news);
    }

    public void updateOneNews(News news, String newContent) {
        Database.news.elementAt(Database.news.indexOf(news)).update(newContent);
    }
    
    public String toString() {
        return "Manager - " + super.toString();
    }
}
