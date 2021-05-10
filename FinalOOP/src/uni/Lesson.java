package uni;

import uni.enums.WeekDay;

import java.io.Serializable;
import java.util.Set;

public class Lesson implements Serializable, Comparable  {

    private Course course;
    private String startTime;
    private String endTime;
    private int room;
    private Teacher instructor;
    private WeekDay weekDay;
    private Set<Schedule> schedule;


    private Course getCourse() { return this.course; }

    private void setCourse(Course course) {
        this.course = course;
    }

    private String getStartTime() {
        return this.startTime;
    }

    private void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    private String getEndTime() {
        return this.endTime;
    }

    private void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    private int getRoom() {
        return this.room;
    }

    private void setRoom(int room) {
        this.room = room;
    }

    private Teacher getInstructor() {
        return this.instructor;
    }

    private void setInstructor(Teacher instructor) {
        this.instructor = instructor;
    }

    private WeekDay getWeekDay() {
        return this.weekDay;
    }

    private void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public Schedule getSchedule() {
        return (Schedule) this.schedule;
    }

    public void setSchedule(Set<Schedule> schedule) {
        this.schedule = schedule;
    }

    public Course get() { return this.course; }

    public void set(Course course) { this.course = course; }


    //                          Operations

    public getStartTime() {
        //TODO
    }

    public setStartTime() {
        //TODO
    }

    public getEndTime() {
        //TODO
    }

    public setEndTime() {
        //TODO
    }

    public getWeekDay() {
        //TODO
    }

    public setWeekDay() {
        //TODO
    }

    public getRoom() {
        //TODO
    }

    public setRoom() {
        //TODO
    }

    public getCourse() {
        //TODO
    }

    public setCourse() {
        //TODO
    }

    public getInstructor() {
        //TODO
    }

    public setInstructor() {
        //TODO
    }

    public boolean equals() {
        //TODO
        return false;
    }

    public int hashCode() {
        //TODO
        return 0;
    }

    public String toString() {
        //TODO
        return "";
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
