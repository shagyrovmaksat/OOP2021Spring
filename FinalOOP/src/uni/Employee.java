package uni;

import java.util.*;

public abstract class Employee extends User {
    
	private static final long serialVersionUID = 1L;
	protected Department department;
    protected Vector<Message> messages = new Vector<Message>();
    
    public Employee() {}
    public Employee(String name, String surname, String password, Department department) {
    	super(name, surname, password);
    	this.department = department;
    }
    
    public Vector<Message> viewMessagesToMe() {
    	Vector<Message> temp = new Vector<Message>();
    	for(Message m : messages) {
    		if(m.getAuthor().getName() != this.getName()) {
    			temp.add(m);
    		}
    	}
		return temp;
    }
    
    public Vector<Message> viewMessagesFromMe() {
    	Vector<Message> temp = new Vector<Message>();
    	for(Message m : messages) {
    		if(m.getAuthor().getName() == this.getName()) {
    			temp.add(m);
    		}
    	}
		return temp;
    }
    
    public void sendMessage(Message message, Employee employee) {
    	employee.messages.add(message);
    }
    
    public String toString() {
    	return " Employee of " + department + " department, " + super.toString();
    }
}
