package test.jpm.external;

import test.jpm.messages.Message;

/**
 * Gateway interface which contains method describing how to interact with the external resource
 * @author Kashmira
 */

public interface Gateway {
	/**
	 * send messages to be processed by calling the Gateway's send(Message msg) method to Gateway
	 * @param msg
	 */
	public void send(Message msg);
}

