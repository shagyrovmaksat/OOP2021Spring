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
	public static void showMenu(Teacher teacher) throws IOException {
		System.out.println("-------- TEACHER: " + teacher.getName() + " " + teacher.getSurname() + " --------");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (teacher.isLoginned()) {
			System.out.println("----------- INPUT ACTION'S NUMBER ------------\n" +
					"[0] EXIT\n" +
					"[1] Teacher's info\n" +
					"[2] Show teacher's courses\n" +
					"[3] Manage files\n" +
					"[4] Messages\n" +
					"[5] Put mark\n" +
					"[6] Change Password\n" +
					"[7] Log Out\n" +
					"----------------------------------------------\n");
			int input;
			input = Integer.parseInt(reader.readLine());
			switch(input){
				case 0:
					break;
				case 1:
					showInfo(teacher);
					break;
				case 2:
					showCourses(teacher);
					break;
				case 3:
					manageFiles(teacher);
					break;
				case 6:
					changePassword(teacher);
					break;
				case 5:
					putMark(teacher);
					break;
				case 4:
					manageMessages(teacher);
					break;
				case 7:
					logOut(teacher);
					break;
			}
		}
	}

	public static void showInfo(Teacher teacher){
		System.out.println("----------------------------------------------");
		System.out.println("\t" + "Name: " + teacher.getName());
		System.out.println("\t" + "Surname: " + teacher.getSurname());
		System.out.println("\t" + "ID: " + teacher.getId());
		System.out.println("\t" + "Rank: " + teacher.getRank());
		System.out.println("----------------------------------------------\n");
	}

	public static void showCourses(Teacher teacher) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("----------- INPUT ACTION'S NUMBER -----------\n" +
				"[0] EXIT\n" +
				"[1] Show course info\n" +
				"[2] Show course students\n" +
				"[3] Show my courses\n");
		System.out.println("----------------------------------------------\n");
		int l_i;
		l_i = Integer.parseInt(reader.readLine());
		switch (l_i){
			case 1:
				int course_id;
				System.out.println("\t Enter course's ID: \n");
				course_id = Integer.parseInt(reader.readLine());
				System.out.println("\t Course name " + teacher.getCourseById(course_id).getName());
				System.out.println("\t Course description " + teacher.getCourseById(course_id).getDescription());
				System.out.println("\t Limit of students on course: " + teacher.getCourseById(course_id).getLimitOfStudents() + " Students on course: "
						+ teacher.getCourseById(course_id).getCountOfStudents());
				System.out.println("\t Type of course: " + teacher.getCourseById(course_id).getCourseType());
				break;
			case 2:
				int course_id2;
				System.out.println("\t Enter course's ID: \n");
				course_id2 = Integer.parseInt(reader.readLine());
				for(Student s: teacher.getCourseStudents(teacher.getCourseById(course_id2))){
					System.out.println("\t" + s.getId() + " " + s.getName() + " " + s.getSurname() + " " + s.getGpa());
				}
				break;
			case 3:
				int i = 1;
				System.out.println("----------------------------------------------");
				for(Course course1: teacher.getCourses()){
					System.out.println("\t" + "[" + i + "]" + course1.getName() + " ID: " + course1.getId());
					i++;
				}
				break;
		}
	}

	public static void manageFiles(Teacher teacher) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("----------- INPUT ACTION'S NUMBER -----------\n" +
				"[0] EXIT\n" +
				"[1] Show course files\n" +
				"[2] Add course files\n" +
				"[3] Delete course files\n");
		System.out.println("----------------------------------------------\n");
		int c_i;
		c_i = Integer.parseInt(reader.readLine());
		switch (c_i){
			case 1:

				System.out.println("\t Enter course's ID:  \n");
				int course_id3;
				Course c2 = null;
				course_id3 = Integer.parseInt(reader.readLine());
				for(Course course: teacher.getCourses()){
					if(course.getId() == course_id3){
						c2 = course;
					}
				}
				int j = 1;
				for(File f: c2.getCourseFiles()){
					System.out.println("\t" + "[" + j + "]" + f.getTitle());
					j++;
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

				System.out.println("\t Enter file's title: \n");
				file_title = reader.readLine();
				System.out.println("\n\t Enter file's content: \n");
				file_content = reader.readLine();
				pubish_date = date.toString();

				file.setTitle(file_title);
				file.setContent(file_content);
				file.setDate(pubish_date);

				teacher.addFile(file, c);

				System.out.println("\t File is added!\n");



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
				if(c1.getCourseFiles().size() != 0){
					for(File file1: c1.getCourseFiles()){
						if(file1.getTitle().equals(course_title)){
							file2 = file1;
						}
					}
				} else{
					System.out.println("No course files!");
					break;
				}

				teacher.deleteFile(file2, c1);
				System.out.println("File is deleted!");
				break;
		}
		System.out.println("--" +
				"--------------------------------------------\n");
	}

	public static void putMark(Teacher teacher) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("----------- INPUT ACTION'S NUMBER ------------\n" +
				"[0] EXIT\n" +
				"[1] Show course journal\n" +
				"[2] Show course students\n" +
				"[3] Show courses\n" +
				"[4] Put mark\n" +
				"----------------------------------------------\n");

		int action_id;
		action_id = Integer.parseInt(reader.readLine());

		switch(action_id){
			case 0:
				break;
			case 1:
				System.out.println("\t Enter course's ID number: ");
				int course_id2;
				course_id2 = Integer.parseInt(reader.readLine());

				Course course = null;
				for(Course course1: Database.courses){
					if(course1.getId() == course_id2) {
						course = course1;
					}
				}
				int cnt = 1;
				for(Student student: teacher.getCourseStudents(course)){
					System.out.println("[" + cnt + "]" + " ID: " + student.getId() + " Name: " + student.getName() + " Surname: "
							+ student.getSurname() + " " + " Mark: " + student.getTranscript().getCourseMark(course) + "\n");
					cnt++;
				}
				break;
			case 2:

				System.out.println("\t Enter course's ID number: ");
				int course_id3;
				course_id3 = Integer.parseInt(reader.readLine());

				Course course4 = null;
				for(Course course1: Database.courses){
					if(course1.getId() == course_id3) {
						course4 = course1;
					}
				}
				int cnt2 = 1;
				for(Student s: teacher.getCourseStudents(course4)){
					System.out.println("[" + cnt2 + "]" + " ID: " + s.getId() + " Name: " + s.getName() + " Surname: "
							+ s.getSurname() + "\n");
					cnt2++;
				}
				break;
			case 3:
				int cnt3 = 1;
				for(Course course3: teacher.getCourses()){
					System.out.println("[" + cnt3 + "]" + course3.getName() + "\n");
					cnt3++;
				}
				break;
			case 4:
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

				Course course2 = null;
				for(Course course1: Database.courses){
					if(course1.getId() == course_id) {
						course2 = course1;
					}
				}

				Mark mark = null;

				System.out.println("----------- INPUT ACTION'S NUMBER -----------\n" +
						"[0] EXIT\n" +
						"[1] Put 1st attestation mark\n" +
						"[2] Put 2nd attestation mark\n" +
						"[3] Put final examination mark\n");
				int k;
				k = Integer.parseInt(reader.readLine());
				switch (k){
					case 1:
						double first_mark;
						first_mark = Double.parseDouble(reader.readLine());
						if(student.getTranscript().getCoursesAndMarks().get(course2) != null){
							mark = student.getTranscript().getCoursesAndMarks().get(course2);
						} else if(student.getTranscript().getCoursesAndMarks().get(course2) == null){
							mark = new Mark();
						}
						mark.setFirstAttMark(first_mark);
						teacher.putMark(student, mark, course2);

						break;
					case 2:
						double second_mark;
						second_mark = Double.parseDouble(reader.readLine());
						if(student.getTranscript().getCoursesAndMarks().get(course2) != null){
							mark = student.getTranscript().getCoursesAndMarks().get(course2);
						} else if(student.getTranscript().getCoursesAndMarks().get(course2) == null){
							mark = new Mark();
						}
						mark.setSecondAttMark(second_mark);
						teacher.putMark(student, mark, course2);

						break;
					case 3:
						double final_mark;
						final_mark = Double.parseDouble(reader.readLine());
						if(student.getTranscript().getCoursesAndMarks().get(course2) != null){
							mark = student.getTranscript().getCoursesAndMarks().get(course2);
						} else if(student.getTranscript().getCoursesAndMarks().get(course2) == null){
							mark = new Mark();
						}
						mark.setFinalExamMark(final_mark);
						teacher.putMark(student, mark, course2);

						break;
				}
				mark.calculateDigitMark();
				mark.calculateLetterMark();
				System.out.println("\t" + "Total attestation digit mark: " + mark.getDigitMark() + "\n");
				if(mark.getFirstAttMark() != 0 && mark.getSecondAttMark() != 0 && mark.getFinalExamMark() != 0){
					System.out.println("\t" + "Total attestation letter mark: " + mark.getLetterMark() + "\n");
				}
				break;
		}
		System.out.println("----------------------------------------------\n");
	}

	public static void manageMessages(Teacher teacher) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("----------- INPUT ACTION'S NUMBER -----------\n" +
				"[0] EXIT\n" +
				"[1] Send message\n" +
				"[2] View my messages\n" +
				"[3] View sent messages");
		System.out.println("----------------------------------------------\n");
		int m_i;
		m_i = Integer.parseInt(reader.readLine());
		switch (m_i){
			case 1:
				int user_id;
				String content;
				Date date = new Date();
				Message message = new Message();
				Teacher teacher1 = null;

				System.out.println("\tEnter receiver's ID: \n");
				user_id = Integer.parseInt(reader.readLine());

				for(User user1: Database.users){
					if(user1 instanceof Teacher){
						if(((Teacher) user1).getId() == user_id){
							teacher1 = (Teacher) user1;
						}
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

				System.out.println("\tMessage is sent!");
				System.out.println("----------------------------------------------\n");


				break;

			case 2:

				if(teacher.viewMessagesToMe(teacher.getId()).size() != 0){
					for(Message message1: teacher.viewMessagesToMe(teacher.getId())){
						System.out.println("----------------------------------------------\n");
						System.out.println("\t" + "From: " + message1.getAuthorFullName() + "\n");
						System.out.println("\t" + message1.getContent() + "\n");
						System.out.println("\t" + "Date: " + message1.getDate() + "\n");
						System.out.println("\t" + "To: " + message1.getReceiverFullName() + "\n");
					}
				} else{
					System.out.println("My messagebox is empty!");
				}
				System.out.println("----------------------------------------------\n");
				break;

			case 3:

				if(teacher.viewMessagesFromMe(teacher.getId()).size() != 0){
					for(Message message1: teacher.viewMessagesFromMe(teacher.getId())){
						System.out.println("----------------------------------------------\n");
						System.out.println("\t" + "From: " + message1.getAuthorFullName() + "\n");
						System.out.println("\t" + message1.getContent() + "\n");
						System.out.println("\t" + "Date: " + message1.getDate() + "\n");
						System.out.println("\t" + "To: " + message1.getReceiverFullName() + "\n");
					}
				} else{
					System.out.println("My messagebox is empty!");
				}
				System.out.println("----------------------------------------------\n");
				break;
		}
	}

	public static void logOut(Teacher teacher){
		teacher.logout();
	}

	public static void changePassword(Teacher teacher) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("--- Change Password ---");

		System.out.print("Password: ");
		String password = reader.readLine();
		System.out.print("New password: ");
		String newPassword = reader.readLine();
		System.out.print("Confirm new password: ");
		String newPassword1 = reader.readLine();

		if (!teacher.checkPassword(password))
			System.out.println("Error, incorrect password. Please, try again.");
		else if (!newPassword.equals(newPassword1))
			System.out.println("Error, new passwords are not same. Please, try again.");
		else {
			teacher.changePassword(newPassword);
			System.out.println("--- Password successfully changed ---");
		}
	}
}