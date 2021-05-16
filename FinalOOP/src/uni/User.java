package uni;

import java.io.Serializable;
import java.util.*;

public abstract class User implements Serializable, Comparable<User>  {
    
	private static final long serialVersionUID = 1L;
	
	private int id;
    private String name;
    private String surname;
    private String username;
    private int password;
    private boolean loginned;
    
    
    
    {
    	id = Database.idCounter.getOrDefault("userId", null);
    	Database.idCounter.put("userId", id + 1);
    }
    
    public User() {}
    public User(String name, String surname, String password) {
    	this.name = name;
    	this.surname = surname;
    	this.username = name.toLowerCase().charAt(0) + "_" + surname.toLowerCase() + "@kbtu.kz";
    	this.password = password.hashCode();
    }

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
		
		String newUsername = name.toLowerCase().charAt(0) + this.username.substring(1);
		this.username = newUsername;
	}

	public String getSurname() {
		return this.surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
		
		String newUsername = this.name.toLowerCase().charAt(0) + "_" + surname.toLowerCase() + "@kbtu.kz";
    	this.username = newUsername;
	}

	public String getUsername() {
		return this.username;
	}
	
	public int getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password.hashCode();
	}
	
	//?
	public void login() {
		this.loginned = true;
	}
	
	//?
	public void logout() {
		this.loginned = false;
	}
	
	public boolean isLoginned() {
		return this.loginned;
	}
	
	final public void changePassword(String newPassword) {
		this.setPassword(newPassword);
	}
	
	public HashSet<News> viewNews() {
		return Database.news;
	}
	

	public void commentNews(News news, Comment comment) {
		if (Database.news.contains(news))
			news.addComment(comment);
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (loginned != other.loginned)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password != other.password)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (loginned ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + password;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", username=" + username + ", password="
				+ password + ", loginned=" + loginned + "]";
	}
}