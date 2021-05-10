package uni;


import java.util.Queue;
import java.util.Set;

public class Manager extends Employee implements StatisticsViewable {

    private Queue<Request> requests;
    private ManagerType type;
    private Set<Request> request;
    private Set<News> news;
    

    private Queue<Request> getRequests() {
        return this.requests;
    }

    private void setRequests(Queue<Request> requests) {
        this.requests = requests;
    }

    private ManagerType getType() {
        return this.type;
    }

    private void setType(ManagerType type) {
        this.type = type;
    }

    public Request getRequest() {
        return (Request) this.request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public News get() {
        return (News) this.news;
    }

    public void set(News news) {
        this.news = (Set<News>) news;
    }


    //                          Operations                                  

    public countOfRequests() {
        //TODO
    }

    public addRequest() {
        //TODO
    }

    public takeRequest() {
        //TODO
    }

    public addNewCourse() {
        //TODO
    }

    public deleteCourse() {
        //TODO
    }

    public openRegistration() {
        //TODO
    }

    public closeRegistration() {
        //TODO
    }

    public assignTeacherToLesson() {
        //TODO
    }

    public assignLessonToStudents() {
        //TODO
    }

    public getListOfTeachers() {
        //TODO
    }

    public getListOfStudents() {
        //TODO
    }

    public getInfoAboutStudent() {
        //TODO
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
