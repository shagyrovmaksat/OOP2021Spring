package uni;

import java.io.Serializable;
import java.util.Set;

public class Lesson implements Serializable {

    private Course course;
    private String startTime;
    private String endTime;
    private int room;
    private Teacher instructor;
    private WeekDay weekDay;

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String time) {
       	this.startTime = time;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String time) {
       	this.endTime = time;
    }

    public WeekDay getWeekDay() {
    	return this.weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
    	this.weekDay = weekDay;
    }

    public int getRoom() {
        return this.room;
    }

    public void setRoom(int room) {
    	this.room = room;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course coure) {
        this.course = course;
    }

    public Teacher getInstructor() {
        return this.instructor;
    }

    public void setInstructor(Teacher teacher) {
        this.instructor = teacher;
    }

    //need to add week day
    public String toString() {
        return " Course - " + this.course + " " + this.startTime + " - " + this.endTime + " Room - " + this.room + " Instructor - " + this.instructor;
    }
}
