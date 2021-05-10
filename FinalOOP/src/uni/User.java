package uni;

import java.util.Objects;
import java.io.Serializable;
import java.util.Vector;

public class User implements Serializable, Comparable<User>  {
    
    private String id;
    private String name;
    private String surname;
    private String username;
    private int password;
    private boolean loginned;
    
    //?
    private Database database;
    
    User() {}
    User(String id, String name, String surname, String username, String password) {
    	this.id = id;
    	this.name = name;
    	this.surname = surname;
    	this.password = password.hashCode();
    }

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}
	
	public void login() {
		this.loginned = true;
	}
	
	public void logout() {
		this.loginned = false;
	}
	
	public boolean isLoginned() {
		return this.loginned;
	}
	
	public void changePassword(String newPassword) {
		this.password = newPassword.hashCode();
	}
	
	//?
	public Vector<News> viewNews() {
		return null;
	}
	
	//?
	public void commentNews(News news, Comment comment) {
		
	}
	
	public int compareTo(User u) {
		if(this.username.compareTo(u.username) == 1) return 1;
		else if(this.username.compareTo(u.username) == -1) return -1;
		
		if(this.name.compareTo(u.name) == 1) return 1;
		else if(this.name.compareTo(u.name) == -1) return -1;
		
		if(this.surname.compareTo(u.surname) == 1) return 1;
		else if(this.surname.compareTo(u.surname) == -1) return -1;
		
		return 0;
	}
	
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj == null || obj.getClass() != this.getClass()) return false;
		
		User u = (User)obj;
		return this.username.equals(u.username) && this.name.equals(u.name) && this.surname.equals(u.surname);
	}
	
	public int hashCode() {
		return Objects.hash(name, surname, username);
	}
	
	public String toString() {
		return "Name - " + this.name + " Surname - " + this.surname + " Logined is " + this.loginned;
	}
}