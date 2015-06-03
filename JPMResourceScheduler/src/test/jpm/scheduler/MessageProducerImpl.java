package test.jpm.scheduler;

import test.jpm.messages.Message;

public class MessageProducerImpl implements MessageProducer {

	private final String TEST_MESSAGE = "Test Message";
	
	@Override
	public Message createMessage(int id, String group) {
		return new Message(id, TEST_MESSAGE, group);
	}
	
	
	
}
