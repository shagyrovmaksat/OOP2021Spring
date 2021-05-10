package uni;

import java.io.*;

public class File implements Serializable, Cloneable {
    

    private String title;
    private String content;
    private String date;
    
    public File() {}
    
    public File(String title, String content, String date) {
    	this.setTitle(title);
    	this.setContent(content);
    	this.setDate(date);
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    
	public int hashCode() {
		return title.hashCode() * content.hashCode() * date.hashCode();
	}
	
	public Object clone() throws CloneNotSupportedException {
		return (File) super.clone();
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		File f = (File) o;
		return title.equals(f.title) && content.equals(f.content) && date.equals(f.date);
	}
	

	
	public String toString() {
		return "Title: " + title + ", date: " + date;
	}
    
}
