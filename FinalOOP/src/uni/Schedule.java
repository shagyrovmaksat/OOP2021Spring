package uni;

import java.io.Serializable;
import java.util.Vector;

public class Schedule implements Serializable {
	
    private Vector<Lesson> lessons;

    public Vector<Lesson> getLessons() {
    	return this.lessons;
    }

    public void addLesson(Lesson lesson) {
    	this.lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
    	this.lessons.remove(lesson);
    }

    public String toString() {
    	String res = "";
    	for(Lesson l : this.lessons) {
    		res += l.toString() + "\n";
    	}
    	return res;
    }
}
