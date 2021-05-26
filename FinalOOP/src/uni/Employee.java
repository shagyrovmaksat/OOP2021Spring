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
    
    public String toString() {
    	return " Employee of " + department + " department, " + super.toString();
    }
}
