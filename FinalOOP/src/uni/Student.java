package uni;

import uni.enums.Degree;
import uni.enums.Faculty;
import uni.enums.Speciality;

import java.util.HashSet;
import java.util.Vector;

public class Student extends User {
    
    private int yearOfStudy;
    private Speciality speciality;
    private Faculty faculty;
    private HashSet<Course> courses;
    private Degree degree;
    private Vector<Schedule> schedules;
    private Double gpa;
    private int limitOfCredits;
    private Transript transcript;
    private Vector<Book> books;
    
    public int getYearOfStudy() {
        return this.yearOfStudy;
    }
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Speciality getSpeciality() {
        return this.speciality;
    }
    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Faculty getFaculty() {
        return this.faculty;
    }
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public HashSet<Course> getCourses() {
        return this.courses;
    }
    public void setCourses(HashSet<Course> courses) {
        this.courses = courses;
    }

    public Degree getDegree() {
        return this.degree;
    }
    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Vector<Schedule> getSchedules() {
        return this.schedules;
    }
    public void setSchedules(Vector<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Double getGpa() {
        return this.gpa;
    }
    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public int getLimitOfCredits() {
        return this.limitOfCredits;
    }
    public void setLimitOfCredits(int limitOfCredits) {
        this.limitOfCredits = limitOfCredits;
    }

    public Transript getTranscript() {
        return this.transcript;
    }
    public void setTranscript(Transript transcript) {
        this.transcript = transcript;
    }

    public Vector<Book> getBooks() {
        return this.books;
    }
    public void setBooks(Vector<Book> books) {
        this.books = books;
    }
    
    public Schedule getSchedule() {
        return this.schedule;
    }
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
    public Course getCourse() {
        return this.course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    public Book getBook() {
        return this.book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    
    public Teacher getTeacher() {
        return this.teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Transript getTransript() {
        return this.transript;
    }
    public void setTransript(Transript transript) {
        this.transript = transript;
    }
    

    public int getYearOfStudy() {
    	return this.yearOfStudy;
    }
    
    public void increaseYearOfStudy() {
        this.yearOfStudy++;
    }

    public Faculty getFaculty() {
        return this.faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Speciality getSpeciality() {
        return this.speciality;
    }
 
    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
    
    public void rateTeacher(Teacher teacher, int rate) {
        teacher.updateRate(rate);
    }

    public Vector<Request> viewMyRequests() {
        
    }

    public Schedule viewSchedule() {
        
    }

    public void calculateGpa() {
        
    }

    public double getGpa1() {
        this.calculateGpa();
        return this.gpa;
    }
    
    public double getTechnicalGpa() {
        return 0;
    } 
    
    public int getLimitOfCredits() {
        return this.limitOfCredits;
    }
    public void setLimitOfCredits(int limit) {
        this.limitOfCredits = limit;
    }

    public Vector<Book> getBooks() {
        
    }
    public Book getBook() {
        
    }

    public void returnBook() {
        
    }

    public int compareTo(Student s) {
        return 0;
    }

    public String toString() {
        return "";
    }

    public boolean equals() {
        return false;
    }
 
    public int hashCode() {
        return 0;
    } 
}