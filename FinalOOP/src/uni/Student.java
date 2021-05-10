package uni;

import java.util.HashSet;
import java.util.Vector;

public class Student extends User {
    
    private int yearOfStudy;
    private Speciality speciality;
    private Faculty faculty;
    private HashSet<Course> courses;
    private Degree degree;
    private Schedule schedule;
    private Double gpa;
    private int limitOfCredits;
    private Transript transcript;
    private Vector<Book> books;
    
    private int getYearOfStudy() {
        return this.yearOfStudy;
    }
    private int setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    
    private Speciality getSpeciality() {
        return this.speciality;
    }
    private Speciality setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
    
    private Faculty getFaculty() {
        return this.faculty;
    }
    private Faculty setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    private HashSet<Course> getCourses() {
        return this.courses;
    }
    private HashSet<Course> setCourses(HashSet<Course> courses) {
        this.courses = courses;
    }
    
    private Degree getDegree() {
        return this.degree;
    }
    private Degree setDegree(Degree degree) {
        this.degree = degree;
    }

    public Schedule getSchedule() {
        return this.schedule;
    }
    private Schedule setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
    public Double getGpa() {
        return this.gpa;
    }
    private Double setGpa(Double gpa) {
        this.gpa = gpa;
    }
    
    private int getLimitOfCredits() {
        return this.limitOfCredits;
    }
    private int setLimitOfCredits(int limitOfCredits) {
        this.limitOfCredits = limitOfCredits;
    }

    private Transript getTranscript() {
        return this.transcript;
    }
    private Transript setTranscript(Transript transcript) {
        this.transcript = transcript;
    }
    
    private Vector<Book> getBooks() {
        return this.books;
    }
    private Vector<Book> setBooks(Vector<Book> books) {
        this.books = books;
    }
    
    public Schedule getSchedule() {
        return this.schedule;
    }
    public Schedule setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
    public Course getCourse() {
        return this.course;
    }
    public Course setCourse(Course course) {
        this.course = course;
    }

    public Book getBook() {
        return this.book;
    }
    public Book setBook(Book book) {
        this.book = book;
    }
    
    public Teacher getTeacher() {
        return this.teacher;
    }
    public Teacher setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Transript getTransript() {
        return this.transript;
    }
    public Transript setTransript(Transript transript) {
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

    public setFaculty(Faculty faculty) {
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

    public double getGpa() {
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
        
    }

    public boolean equals() {

    }
 
    public int hashCode() {

    } 
}