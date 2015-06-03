package test.jpm.scheduler;

import test.jpm.messages.Message;

/**
 * Message producer
 * @author Kashmira
 */
public interface MessageProducer {
	
	/**
	 * Create message
	 * @param id
	 * @param group
	 * @return
	 */
	public Message createMessage(int id, String group);

}
