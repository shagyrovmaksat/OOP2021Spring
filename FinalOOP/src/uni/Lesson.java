package uni;

import java.io.Serializable;

public class Lesson implements Serializable {

	private static final long serialVersionUID = 1L;
	private int courseId;
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

    public int getCourseId() {
        return this.courseId;
    }
    public void setCourse(int courseId) {
    	this.courseId = courseId;
    }

    
    public Teacher getInstructor() {
        return this.instructor;
    }

    public void setInstructor(Teacher teacher) {
        this.instructor = teacher;
    }

	@Override
	public String toString() {
		return "Lesson [course - " + Database.getCourseById(this.courseId).getName() + ", startTime=" + startTime + ", endTime=" + endTime + ", room=" + room
				+ ", instructor=" + instructor + ", weekDay=" + weekDay + "]";
	}
}
