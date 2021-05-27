package uni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class testik {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


	public static void main(String[] args) throws IOException {
		Manager manager = new Manager("M1", "man", "123");
		User student1 = new Student();
		Student student2 = new Student();
		News new1 = new News("hello", "world!");
		News new2 = new News("coco", "ajsdn");
		
		manager.addNews(new1);
		manager.addNews(new2);
		student2.commentNews(new1, new Comment());
		
		System.out.print(student1.getClass().getSimpleName());
		
//		while (true) {
//			showNews();
//		}

		
//		System.out.println(student2.getId());
//		System.out.println(student2.viewNews());
		
	}
	
	public static void showNews() throws IOException {
		
		Map<Integer, News> news = new HashMap<Integer, News>();
		
		Map<Integer, Comment> comments = new HashMap<Integer, Comment>();
		int cnt = 1;
		
		for (News n: Database.news) {
			System.out.println("[" + cnt + "] " + n.getTitle());
			news.put(cnt, n);
			cnt++;
		}
		
		String input = reader.readLine();
		News selectedNews = news.get(Integer.parseInt(input));
		
		System.out.println(selectedNews.getTitle() + "\n" +
				selectedNews.getContent() + "\n" +
				selectedNews.getPublishedDate());
		
		cnt = 1;
		for(Comment comment: selectedNews.getComments()) {
			System.out.println("   [" + cnt + "] " + comment.getAuthor().getName() + " " + comment.getAuthor().getSurname() + "\n      " +
								comment.getContent() + "\n      " +
								comment.getPublishedDate());
			comments.put(cnt, comment);
			cnt++;
		}
		input = reader.readLine();
		
	}
	
	
	public static void registrationForCourse() {
		
	}
	
	
	
	
}

