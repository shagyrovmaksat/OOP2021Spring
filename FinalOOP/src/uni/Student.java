package uni;

import java.util.HashSet;
import java.util.Objects;
import java.util.Vector;

public class Student extends User {
    
	private int yearOfStudy;
    private Speciality speciality;
    private Faculty faculty;
    private HashSet<Course> courses;
    private Degree degree;
    private Schedule schedule;
    private double gpa;
    private int limitOfCredits;
    private Transript transcript;
    private Vector<Book> books;
    
    public Student() {
    	super();
    }
    
    public Student(String id, String name, String surname, String username, String password, int yearOfStudy, Speciality speciality, Faculty faculty, Degree degree, int limitOfCredits) {
    	super(id, name, surname, username, password);
    	this.yearOfStudy = yearOfStudy;
    	this.setFaculty(faculty);
    	this.setDegree(degree);
    	this.setLimitOfCredits(limitOfCredits);
    }

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void increaseYearOfStudy() {
		yearOfStudy += 1;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public HashSet<Course> getCourses() {
		return courses;
	}

	public void setCourses(HashSet<Course> courses) {
		this.courses = courses;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Double getGpa() {
		return gpa;
	}
	
	
	//?
	public Double getTechnicalGpa() {
		return gpa;
	}
	
	//?
	public void calculateGpa() {
		
	}
	

	public int getLimitOfCredits() {
		return limitOfCredits;
	}
	
	
	public void setLimitOfCredits(int limitOfCredits) {
		this.limitOfCredits = limitOfCredits;
	}

	public Transript getTranscript() {
		return transcript;
	}

	public Vector<Book> getBooks() {
		return books;
	}
	
	//?
	public void getBook(Book book) {
		
	}
	
	//?
	public void returnBook(Book book) {
		
	}
	
	public Vector<Request> getMyRequests() {
		return new Vector<Request>();
	}
	
	public void rateTeacher(Teacher teacher, int rate) {
		
	}
		
  public int compareTo(Student s) {
      return 0;
  }

  public boolean equals(Object o) {
    if (!super.equals(o))
      return false;
    Student s = (Student) o;
    return (yearOfStudy == s.yearOfStudy) && (speciality.equals(s.speciality)) && (faculty.equals(s.faculty)) && (degree.equals(s.degree)) && (gpa == s.gpa);
  }

  public int hashCode() {
    return Objects.hash(yearOfStudy, speciality, faculty, degree, gpa);
  }

  public String toString() {
      return super.toString() + ", year of study - " + yearOfStudy + ", speciality - " + speciality + ", faculty - " + faculty + ", degree - " + degree + ", gpa - " + gpa;
  }
}