package test.jpm.junit;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import test.jpm.messages.Message;
import test.jpm.scheduler.MessageProducer;
import test.jpm.scheduler.MessageProducerImpl;

/**
 * Message Producer Test
 * @author Kashmira
 *
 */
public class MessageProducerTest {
	
	private final String GROUP_NAME = "Group1";
	private final int MESSAGE_ID = 123;
	private MessageProducer msgProducer;
	
	/**
	 * initialize
	 */
	@Before
	public void init() {
		msgProducer = new MessageProducerImpl();
	}
	
	/**
	 * unit test for created message
	 */
	@Test
	public void createTestMessage(){
		Message msg = msgProducer.createMessage(MESSAGE_ID, GROUP_NAME);
		Assert.assertTrue(msg.getId() == MESSAGE_ID);
		Assert.assertTrue(msg.getGroup().equals(GROUP_NAME));
	}

}
