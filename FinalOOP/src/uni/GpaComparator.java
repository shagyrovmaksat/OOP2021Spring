package uni;

import java.util.Comparator;

public class GpaComparator implements Comparator<Student> {
    
   public int compare(Student student1, Student student2) {
	   return student1.getGpa().compareTo(student2.getGpa());
   }
}