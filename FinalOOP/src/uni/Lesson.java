package uni;

import java.io.Serializable;

public class Lesson implements Serializable {

	private static final long serialVersionUID = 1L;
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
    public void setCourse(Course course) {
    	this.course = course;
    }
    
    public Teacher getInstructor() {
        return this.instructor;
    }

    public void setInstructor(Teacher teacher) {
        this.instructor = teacher;
    }

	@Override
	public String toString() {
		return "Lesson [course=" + course + ", startTime=" + startTime + ", endTime=" + endTime + ", room=" + room
				+ ", instructor=" + instructor + ", weekDay=" + weekDay + "]";
	}
}
