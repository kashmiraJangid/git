package test.jpm.messages;

/**
 * Message 
 * @author Kashmira
 */
public class Message {
	
	private int id;
	private String message;
	private String group;
	private volatile boolean completed = false;
	
	public Message() {
	}
	
	public Message(int id, String message, String group) {
		this.id = id;
		this.message = message;
		this.group = group;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}
	
	/**
	 * Mark complete message once it sends through gateway
	 */
	public void markCompleted() {
		this.completed = true;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	@Override
	public String toString() {
		return "{ Message: "+message+", Group: "+group+"}";
	}

}
