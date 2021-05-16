package uni;

import java.util.*;
import static java.util.Map.entry;  

public class testik {

	public static void main(String[] args) {
		Database database = new Database();
		Manager manager = new Manager("M1", "man", "123", Department.MANAGEMENT);
		Student student1 = new Student();
		Student student2 = new Student();
		News new1 = new News("hello", "world!");
		
		
		manager.addNews(new1);
		student2.commentNews(new1, new Comment());
		
		System.out.println(student2.viewNews());
		
	}
}