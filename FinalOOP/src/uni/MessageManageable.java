package uni;

import java.util.Vector;

public interface MessageManageable {
	
	public default Vector<Message> viewMessagesToMe(int id) {
    	Vector<Message> temp = new Vector<Message>();
    	for(Message m : Database.messages) {
    		if(m.getReceiver().getId() == id) {
    			temp.add(m);
    		}
    	}
		return temp;
    }
    
    public default Vector<Message> viewMessagesFromMe(int id) {
    	Vector<Message> temp = new Vector<Message>();
    	for(Message m : Database.messages) {
    		if(m.getAuthor().getId() == id) {
    			temp.add(m);
    		}
    	}
		return temp;
    }
    
    public default void sendMessage(Message message) {
    	Database.messages.add(message);
    }
}
