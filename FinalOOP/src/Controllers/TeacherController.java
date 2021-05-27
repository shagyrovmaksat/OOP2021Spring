package Controllers;

import uni.*;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

public class TeacherController {
	Database database = new Database();
	static Manager manager = new Manager("Adil", "Kumashev", "123456");
	static Teacher teacher = new Teacher("Beisenbek", "Baisakov", "123456");


	public static void showMenu(Teacher teacher) throws IOException {
		System.out.println("------------- " + teacher.getName() + " " + teacher.getSurname() + " ------------");
		System.out.println();

		Database.users.add(teacher);

		Student student1 = new Student("Adil", "Kumashev", "a_kumashev@kbtu.kz");
		Student student2 = new Student("Magzhan", "Zhumadilov", "m_zhumadilov@kbtu.kz");
		Student student3 = new Student("Roman", "Biryukov", "r_biryukov@kbtu.kz");
		Student student4 = new Student("Adilzhan", "Dzhumakanov", "a_dzhumakanov@kbtu.kz");

		System.out.println(teacher.getId() + " Name: " + teacher.getName());


		Course course = new Course("PP2", "basics", 4, 50, Faculty.FIT, CourseType.REQUIRED);
		Course course2 = new Course("PP1", "basics", 4, 50, Faculty.FIT, CourseType.REQUIRED);
		Course course3 = new Course("ADS", "basics", 4, 50, Faculty.FIT, CourseType.REQUIRED);


		Vector<Student> students = new Vector<Student>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		teacher.getCoursesWithStudents().put(course, students);
		teacher.getCoursesWithStudents().put(course2, students);
		teacher.getCoursesWithStudents().put(course3, students);

		Database.courses.add(course);
		Database.courses.add(course2);
		Database.courses.add(course3);

		Database.users.add(student1);
		Database.users.add(student2);
		Database.users.add(student3);
		Database.users.add(student4);

		System.out.println( course.getName() + " " + course.getId());

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("----------- INPUT ACTION'S NUMBER -----------\n" +
					"[1] Teacher's info\n" +
					"[2] Show teacher's courses\n" +
					"[3] Manage files\n" +
					"[4] \n" +
					"[5] Put mark\n" +
					"[6] Messages\n" +
					"[7] \n" +
					"----------------------------------------------\n");
			int input;
			input = Integer.parseInt(reader.readLine());
			switch(input){
				case 1:
					showInfo();
					break;
				case 2:
					showCourses();
					break;
				case 3:
					manageFiles();
					break;
				case 4:
					break;
				case 5:
					putMark(teacher);
					break;
				case 6:
					manageMessages(teacher);
					break;
				case 7:
					break;
			}
		}
	}

	public static void showInfo(){
		System.out.println("----------------------------------------------");
		System.out.println("\t" + "Name: " + teacher.getName());
		System.out.println("\t" + "Surname: " + teacher.getSurname());
		System.out.println("\t" + "ID: " + teacher.getId());
		System.out.println("\t" + "Rank: " + teacher.getRank());
		System.out.println("----------------------------------------------\n");
	}

	public static void showCourses() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int i = 1;
		System.out.println("----------------------------------------------");
		for(Course course1: teacher.getCourses()){
			System.out.println("\t" + "[" + i + "]" + course1.getName());
			i++;
		}
		String input2;
		input2 = reader.readLine();
		System.out.println("----------- INPUT ACTION'S NUMBER -----------\n" +
				"[1] Show course students\n" +
				"[2] Put 2nd attestation mark\n" +
				"[3] Put final examination mark\n");
		System.out.println("----------------------------------------------\n");
	}

	public static void manageFiles() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("----------- INPUT ACTION'S NUMBER -----------\n" +
				"[1] Show course files\n" +
				"[2] Add course files\n" +
				"[3] Delete course files\n");
		System.out.println("----------------------------------------------\n");
		int c_i;
		c_i = Integer.parseInt(reader.readLine());
		switch (c_i){
			case 1:
				String courseInput;
				courseInput = reader.readLine();
				int j = 1;
				for(File file: teacher.getFiles(courseInput)){
					System.out.println("\t" + "[" + j + "]" + file.getTitle());
				}
				break;
			case 2:
				System.out.println("\t Enter course's ID:  \n");
				int course_id;
				Course c = null;
				course_id = Integer.parseInt(reader.readLine());
				for(Course course: teacher.getCourses()){
					if(course.getId() == course_id){
						c = course;
					}
				}

				File file = new File();
				String file_title;
				String file_content;
				String pubish_date;
				Date date = new Date();

				System.out.println("\t Enter file's title:  \n");
				file_title = reader.readLine();
				System.out.println("\n\t Enter file's content:  \n");
				file_content = reader.readLine();
				pubish_date = date.toString();

				file.setTitle(file_title);
				file.setContent(file_content);
				file.setDate(pubish_date);

				teacher.addFile(file, c);

				break;
			case 3:
				System.out.println("\t Enter course's ID:  \n");
				int course_id2;
				Course c1 = null;
				course_id2 = Integer.parseInt(reader.readLine());
				for(Course course: teacher.getCourses()){
					if(course.getId() == course_id2){
						c1 = course;
					}
				}

				System.out.println("\t Enter file's title:  \n");
				String course_title;
				File file2 = null;
				course_title = reader.readLine();
				for(File file1: c1.getCourseFiles()){
					if(file1.getTitle().equals(course_title)){
						file2 = file1;
					}
				}

				teacher.deleteFile(file2, c1);
				break;
		}
		System.out.println("----------------------------------------------\n");
	}

	public static void putMark(Teacher teacher) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int student_id;

		System.out.println("\t Enter student's ID number: ");

		student_id = Integer.parseInt(reader.readLine());

		Student student = null;
		for(User user: Database.users){
			if(user instanceof Student){
				if(((Student) user).getId() == student_id){
					student = (Student) user;
				}
			}
		}

		int course_id;

		System.out.println("\t Enter course's ID number: ");

		course_id = Integer.parseInt(reader.readLine());

		Course course = null;
		for(Course course1: Database.courses){
			if(course1.getId() == course_id) {
				course = course1;
			}
		}

		Mark mark = null;

		System.out.println("----------- INPUT ACTION'S NUMBER -----------\n" +
				"[1] Put 1st attestation mark\n" +
				"[2] Put 2nd attestation mark\n" +
				"[3] Put final examination mark\n");
		int k;
		k = Integer.parseInt(reader.readLine());
		switch (k){
			case 1:
				double first_mark;
				first_mark = Double.parseDouble(reader.readLine());
				if(student.getTranscript().getCoursesAndMarks().get(course) != null){
					mark = student.getTranscript().getCoursesAndMarks().get(course);
				} else if(student.getTranscript().getCoursesAndMarks().get(course) == null){
					mark = new Mark();
				}
				mark.setFirstAttMark(first_mark);
				teacher.putMark(student, mark, course);
				break;
			case 2:
				double second_mark;
				second_mark = Double.parseDouble(reader.readLine());
				if(student.getTranscript().getCoursesAndMarks().get(course) != null){
					mark = student.getTranscript().getCoursesAndMarks().get(course);
				} else if(student.getTranscript().getCoursesAndMarks().get(course) == null){
					mark = new Mark();
				}
				mark.setSecondAttMark(second_mark);
				teacher.putMark(student, mark, course);
				break;
			case 3:
				double final_mark;
				final_mark = Double.parseDouble(reader.readLine());
				if(student.getTranscript().getCoursesAndMarks().get(course) != null){
					mark = student.getTranscript().getCoursesAndMarks().get(course);
				} else if(student.getTranscript().getCoursesAndMarks().get(course) == null){
					mark = new Mark();
				}
				mark.setFinalExamMark(final_mark);
				teacher.putMark(student, mark, course);
				break;
		}
		mark.calculateDigitMark();
		mark.calculateLetterMark();
		System.out.println("\t" + "Total attestation digit mark: " + mark.getDigitMark() + "\n");
		if(mark.getFirstAttMark() != 0 && mark.getSecondAttMark() != 0 && mark.getFinalExamMark() != 0){
			System.out.println("\t" + "Total attestation letter mark: " + mark.getLetterMark() + "\n");
		}
		System.out.println("----------------------------------------------\n");
	}

	public static void manageMessages(Teacher teacher) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("----------- INPUT ACTION'S NUMBER -----------\n" +
				"[1] Send message\n" +
				"[2] View my messages\n" +
				"[3] View sent messages");

		int m_i;
		m_i = Integer.parseInt(reader.readLine());
		switch (m_i){
			case 1:
				int user_id;
				String content;
				Date date = new Date();
				Message message = new Message();
				Teacher teacher1 = null;

				System.out.println("\tEnter receiver's username: \n");
				user_id = Integer.parseInt(reader.readLine());

				for(User user1: Database.users){
						if(((Teacher) user1).getId() == user_id){
							teacher1 = (Teacher) user1;
						}
				}

				System.out.println("\tEnter message content: \n");
				content = reader.readLine();

				message.setAuthor(teacher);
				message.setContent(content);
				message.setDate(date);
				message.setReceiver(teacher1);
				teacher.sendMessage(message);
				Database.messages.add(message);
				break;

			case 2:
				for(Message message1: teacher.viewMessagesToMe(teacher.getId())){
					System.out.println("----------------------------------------------\n");
					System.out.println("\t" + message1.getAuthor() + "\n");
					System.out.println("\t" + message1.getContent() + "\n");
					System.out.println("\t" + message1.getDate() + "\n");
					System.out.println("\t" + message1.getReceiver() + "\n");
				}
				break;

			case 3:
				for(Message message1: teacher.viewMessagesFromMe(teacher.getId())){
					System.out.println("----------------------------------------------\n");
					System.out.println("\t" + message1.getAuthor() + "\n");
					System.out.println("\t" + message1.getContent() + "\n");
					System.out.println("\t" + message1.getDate() + "\n");
					System.out.println("\t" + message1.getReceiver() + "\n");
				}
				break;
		}
		System.out.println("----------------------------------------------\n");
	}



	public static void main(String[] args) throws IOException {
		showMenu(teacher);
	}
}