package uni;

import java.util.*;

public abstract class Employee extends User {
    
    protected Department department;
    protected Vector<Message> messages = new Vector<Message>();
    
    public Employee() {
    	super();
    }
    
    public Employee(Department department) {
    	super();
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
    
    public boolean equals(Object o) {
    	if (!super.equals(o))
    		return false;
    	Employee e = (Employee) o;
    	return department.equals(e.department) && messages.equals(e.messages);
    }
    
    public String toString() {
    	return "Department: " + department;
    }
}
