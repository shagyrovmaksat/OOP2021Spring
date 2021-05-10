package uni;

import uni.enums.Department;

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
    
    public abstract Vector<Message> viewMessagesToMe();
    
    public abstract Vector<Message> viewMessagesFromMe();
    
    public abstract void sendMessage(Message);
    
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
