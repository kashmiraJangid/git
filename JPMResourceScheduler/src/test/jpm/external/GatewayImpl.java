package test.jpm.external;

import test.jpm.messages.Message;

/**
 * Gateway implementation
 * @author Kashmira
 */
public class GatewayImpl implements Gateway {
	
	@Override
	public void send(Message msg) {
		if(!msg.isCompleted())
			msg.markCompleted();
	}
}
