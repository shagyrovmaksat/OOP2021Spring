package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import uni.*;

public class ManagerController {
	
	static Manager manager = null;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	static String choice;
	static String managerConsole  = 
			"\n---------------------------------------\n"
			+ "[1] Open/close registration\n"
			+ "[2] View students and teachers\n"
			+ "[3] Manage courses\n"
			+ "[4] Manage lessons\n"
			+ "[5] Manage news\n"
			+ "[6] Manage messages\n"
			+ "[7] Change password\n"
			+ "[0] Logout\n"
			+ "----------------------------------------\n";
	
	public static void showMenu(Manager currentManager) throws IOException {
		manager = currentManager;
		while(manager.isLoginned()) {
			System.out.println(managerConsole);
			choice = reader.readLine();
			
			if(choice.equals("1")) {
				if(Database.registrationIsOpen == true) {
					System.out.println("Registration is open now\n"+
							   		   "Enter 1 to close registration\n" +
							   		   "Enter 0 to exit\n");
				}
				else {
					System.out.println("Registration is closed now\n" +
									   "Enter 1 to open registration\n" +
									   "Enter 0 to exit\n");
					
				}
				choice = reader.readLine();
				if(choice.equals("1")) {
					if(Database.registrationIsOpen == true) {
						manager.closeRegistration();
						System.out.println("--- Registration is closed ---");
					}
					else {
						manager.openRegistration();
						System.out.println("--- Registration is open ---");
					}
				} 
				
				
			} else if(choice.equals("2")) {
				while(true) {
					System.out.println("Enter 1 to view students\n"+
					   		   		   "Enter 2 to view teachers\n" +
					   		   		   "Enter 0 to exit\n");
					choice = reader.readLine();
					if(choice.equals("0")) break;
					else if(choice.equals("1")) {
						viewStudents();
					} 
					else if(choice.equals("2")) {
						viewTeachers();
					}
				}
			} 
			
			else if(choice.equals("3")) {
				manageCourses();
			} 
			
			else if(choice.equals("4")) {
				manageLessons();
			} 
			
			else if(choice.equals("5")) {
				manageNews();
			} 
			
			else if(choice.equals("6")) {
				while(true) {
					System.out.println("Enter 1 to view messages from you." 
									 + "Enter 2 to view messages to you." 
									 + "Enter 3 to send message." 
									 + "Enter 0 to back.");
					choice = reader.readLine();
					if(choice.equals("1")) {
						Vector<Message> messages = manager.viewMessagesFromMe(manager.getId());
						for(int i = 0; i < messages.size(); i++) {
							System.out.println(i+1 + ") " + messages.get(i));
						}
					} 
					else if (choice.equals("2")) {
						Vector<Message> messages = manager.viewMessagesToMe(manager.getId());
						for(int i = 0; i < messages.size(); i++) {
							System.out.println(i+1 + ") " + messages.get(i));
						}
					} else if (choice.equals("3")) {
						manager.sendMessage(Controller.createMessage(manager));
					} else break;
				}
			}
			
			else if(choice.equals("7")) {
				Controller.changePassword(manager);
			} 
			
			else {
				manager.logout();
			}
		}
	}
	
	
	public static void viewStudents() throws IOException {
		Vector<Student> students = Database.getStudents();
		while(true) {
			int cnt = 1;
			for (Student s: students) {
				System.out.println(cnt + ". [id: " + s.getId() + "] [fullname: " + s.getName() + " " + s.getSurname() + "] [faculty: " + s.getFaculty() + "] [year of study: " + s.getYearOfStudy() + "]");
				cnt++;
			}
			System.out.println("Enter student's id to view detail information about student\n"+
	   		   		   "Enter 0 to exit\n");
			String input = reader.readLine();
			if (input.equals("0"))
				return;
			else {
				Student student = (Student) Database.getUserById(Integer.parseInt(input));
				System.out.println(student + "\n");
			}
		}
	}
	
	public static void viewTeachers() throws IOException {
		Vector<Teacher> teachers = Database.getTeachers();
		while(true) {
			int cnt = 1;
			for (Teacher t: teachers) {
				System.out.println(cnt + ". [id: " + t.getId() + "] [fullname: " + t.getName() + " " + t.getSurname() + "] [faculty: " + t.getFaculty() + "]");
				cnt++;
			}
			System.out.println("Enter teacher's id to view detail information about teacher\n"+
	   		   		   "Enter 0 to exit\n");
			String input = reader.readLine();
			if (input.equals("0"))
				return;
			else {
				Teacher teacher = (Teacher) Database.getUserById(Integer.parseInt(input));
				System.out.println(teacher + "\n");
			}
		}
	}
	
	
	public static void manageCourses() throws IOException {
		System.out.println("[1] Add new course\n" + 
					"[2] Delete existing course\n"
					+ "[3] Assign course to teacher\n" 
				+ 	"[0] Go back");
		
		choice = reader.readLine();


		if (choice.equals("1")) {
			createNewCourse();
		} 
		else if (choice.equals("2")) {
			removeCourse();
		}
		else if (choice.equals("3")) {
			assignCourseToTeacher();
		}
		else return;
	}
	
	
	public static void assignCourseToTeacher() throws IOException {
		System.out.println("Available courses to assign: ");
		int cnt = 1;
		for (Course c: Database.courses) {
			System.out.println(cnt + ". [id: " + c.getId() + "] [name: " + c.getName() + "]");
			cnt++;
		}
		System.out.println("Available teachers: ");
		cnt = 1;
		for (Teacher t: Database.getTeachers()) {
			System.out.println(cnt + ". [id: " + t.getId() + "] [fullname: " + t.getName() + " " + t.getSurname() + "] [faculty: " + t.getFaculty() + "]");
			cnt++;
		}
		System.out.println("[0] Go back\n"
				+ "[1] Continue");
		String input = reader.readLine();
		if (input.equals("0"))
			return;
		else {
			System.out.print("Select course by id\n"
					+ "Course ID:");
			String courseId = reader.readLine();
			System.out.print("Select teacher by id\n"
					+ "Teacher ID:");
			String teacherId = reader.readLine();
			
			Teacher teacher = (Teacher)Database.getUserById(Integer.parseInt(teacherId));
			Course course = null;
			for (Course c: Database.courses)
				if (c.getId() == Integer.parseInt(courseId)) {
					course = c;
				}
					
			
			if (teacher != null && course != null) {
				if (teacher.addCourse(course)) {
					System.out.println("Course is successfully assigned to teacher");
				}
				else
					System.out.println("Error, teacher already has this course");
			}
			else {
				System.out.println("Error, course or teacher does not exist");
			}
		}
		
	}
	
	
	public static void showAllCourses() {
		System.out.println("--- ALL COURSES ---");
		int cnt = 1;
		Vector<Teacher> teachers = Database.getTeachers();
		for (Course course: Database.courses) {
			System.out.print(cnt + ". [id: " + course.getId() + "] [name: " + course.getName() + "] [teacher:");
			for (Teacher teacher: teachers)
				if (teacher.getCourses().contains(course))
					System.out.print(" " + teacher.getName() + " " + teacher.getSurname());
			System.out.print("] count of students: " + course.getCountOfStudents() + ", credits: ");
		}
	}
	
	
	
	public static void createNewCourse() throws IOException {
		Faculty faculty = null;
		CourseType courseType = null;
		
		System.out.print("--- NEW COURSE ---\n"
				+ "Course name: ");
		String courseName = reader.readLine();
		
		System.out.print("Course description: ");
		String description = reader.readLine();
		
		System.out.print("Course credits: ");
		int creditNumber = Integer.parseInt(reader.readLine());
		
		System.out.print("Limit of students: ");
		int limitOfStudents = Integer.parseInt(reader.readLine());
		
		System.out.println("Choose the faculty: \n"
				+ "[1] FIT\n"
				+ "[2] KMA\n"
				+ "[3] SMC");
		choice = reader.readLine();
		
		if (choice.equals("1"))
			faculty = Faculty.FIT;
		else if (choice.equals("2"))
			faculty = Faculty.KMA;
		else if (choice.equals("2"))
			faculty = Faculty.SMC;
		
		// ??????????????
		System.out.println("Choose the course type: \n"
				+ "[1] Required\n"
				+ "[2] Elective");
		choice = reader.readLine();
		
		if (choice.equals("1"))
			courseType = CourseType.REQUIRED;
		else if (choice.equals("2"))
			courseType = CourseType.ELECTIVE;
		
		Course newCourse = new Course(courseName, description, creditNumber, limitOfStudents, faculty, courseType);
		manager.addNewCourse(newCourse);
		System.out.println("--- Course succesfully created! --- \n"
				+ "name: " + newCourse.getName() + ", credits: " + newCourse.getCredits() + ", limit of students: " + newCourse.getLimitOfStudents());
	}
	
	
	public static void removeCourse() throws NumberFormatException, IOException {
		try {
			System.out.println("--- DELETE COURSE ---");
			showAllCourses();
			
			System.out.println("\nPress 0 to cancel and go back to main menu\n"
					+ "Enter ID of course that you want to delete");
			int courseId = Integer.parseInt(reader.readLine());
			
			for (Course course : Database.courses) {
				if ((course).getId() == courseId) {
					manager.deleteCourse(course);
					System.out.println("--- Course is successfully removed ---");
				}
			}
		}
		catch (NumberFormatException e) {
			System.out.println("Incorrect input");
		}
	}
	
	// ????????????????
	public static void manageLessons() throws IOException {
		System.out.println("Enter 1 to assign teacher to lesson\n" + "Enter 2 to assign lesson to student/n"
                + "Enter 0 to exit/n");
        choice = reader.readLine();
        if (choice.equals("1")) {
            Teacher teacher = null;
            Lesson lesson = null;
            System.out.print("Teacher ID: ");
            int teacherId = Integer.parseInt(reader.readLine());
            for (User user1 : Database.users) {
                if (user1 instanceof User) {
                    if (((Teacher) user1).getId() == teacherId) {
                        teacher = (Teacher) user1;
                    }
                }
            }
        } else if (choice.equals("2")) {

        } else if (choice.equals("2")) {

        }
	}
	
	public static void manageNews() throws IOException {
		System.out.println("--- MANAGE NEWS ---\n"
				+ "[1] Create news\n"
				+ "[2] Delete news");
		
        choice = reader.readLine();

        if (choice.equals("1")) {
            System.out.print("\nNews title: ");
            String newsTitle = reader.readLine();
            System.out.print("News content: ");
            String newsContent = reader.readLine();
            News news = new News(newsTitle, newsContent);
            manager.addNews(news);
            System.out.println("--- News succesfully published! ---\n"
            		+ "id: " + news.getId() + ", title: " + news.getTitle());
        } 
        else if (choice.equals("2")) {
        	int cnt = 1;
        	System.out.println("News: ");
        	for (News n: Database.news) {
        		System.out.println(cnt + ". [id: " + n.getId() + "] [title: " + n.getTitle());
        	}
        	System.out.println("\nPress 0 to cancel and go back to main menu\n"
					+ "Enter ID of course that you want to delete");
        	choice = reader.readLine();
        	
        	if (choice.equals("0"))
        		return;
        	else {
        		for (News news : Database.news) {
                    if (news.getId() == Integer.parseInt(choice)) {
                        manager.deleteNews(news);
                        System.out.println("--- News successfully removed ---\n"
                        		+ "id: " + news.getId() + ", title: " + news.getTitle());
                        return;
                    }
                }
        		System.out.println("--- Error, news with id: " + choice + " does not exist ---");
        	}
        }
        else return;
	}
	
	
	public static void manageRequests() {
		
	}
	
}
