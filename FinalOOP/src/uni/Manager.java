package uni;

import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class Manager extends Employee implements StatisticsViewable {

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

    public Teacher[] getListOfTeachers() {
        return (Teacher[]) Database.users.toArray();
    }

    public Student[] getListOfStudents() {
        return Database.
    }

    public String getInfoAboutStudent(Student student) {
        return student;
    }

    public getInfoAboutTeacher() {
        //TODO
    }

    public getType() {
        //TODO
    }

    public setType() {
        //TODO
    }

    public addNews() {
        //TODO
    }

    public deleteNews() {
        //TODO
    }

    public updateOneNews() {
        //TODO
    }

    public compareTo() {
        //TODO
    }

    public int hashCode() {
        //TODO
        return 0;
    }

    public boolean equals() {
        //TODO
        return false;
    }

    public String toString() {
        //TODO
        return "";
    }
    
}
