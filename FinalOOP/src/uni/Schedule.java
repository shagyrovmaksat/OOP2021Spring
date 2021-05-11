package uni;

import java.io.Serializable;
import java.util.Vector;

public class Schedule implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lessons == null) ? 0 : lessons.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (lessons == null) {
			if (other.lessons != null)
				return false;
		} else if (!lessons.equals(other.lessons))
			return false;
		return true;
	}

	public String toString() {
    	String res = "";
    	for(Lesson l : this.lessons) {
    		res += l.toString() + "\n";
    	}
    	return res;
    }
}
