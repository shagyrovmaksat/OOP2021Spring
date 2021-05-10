package uni;

import java.io.Serializable;
import java.util.Vector;

public class Schedule implements Serializable {
    
    private Pair<int, Semester> yearAndSemester;
    private Vector<Lesson> lessons;
    

    private Pair<int, Semester> getYearAndSemester() {
        return this.yearAndSemester;
    }
    private void setYearAndSemester(Pair<int, Semester> yearAndSemester) {
        this.yearAndSemester = yearAndSemester;
    }
    
    private Vector<Lesson> getLessons() {
        return this.lessons;
    }
    private Vector<Lesson> setLessons(Vector<Lesson> lessons) {
        this.lessons = lessons;
    }
    
    public Pair<int, Semester> getYearAndSemester() {
        return this.yearAndSemester;
    }

    public void setYearAndSemester(Pair<int, Semester> yearAndSemester) {
        
    }

    public Vector<Lesson> getLessons() {
    	
    }

    public void addLesson(Lesson lesson) {

    }

    public void removeLesson(Lesson lesson) {

    }

    public String toString() {

    }
}
