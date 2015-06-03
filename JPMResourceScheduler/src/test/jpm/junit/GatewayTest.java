package test.jpm.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import test.jpm.external.Gateway;
import test.jpm.external.GatewayImpl;
import test.jpm.messages.Message;
import test.jpm.scheduler.MessageProducer;
import test.jpm.scheduler.MessageProducerImpl;

/**
 * Test Gateway units
 * @author Kashmira
 */
public class GatewayTest {
	private final String GROUP_NAME = "Group1";
	private final int MESSAGE_ID = 123;
	private Gateway gateway;
	private MessageProducer msgProducer;
	
	/**
	 * initialize
	 */
	@Before
	public void init() {
		gateway = new GatewayImpl();
		msgProducer = new MessageProducerImpl();
	}
	
	/**
	 * test send method and message completed flag
	 */
	@Test
	public void testSendMessageFlag() {
		Message msg = msgProducer.createMessage(MESSAGE_ID, GROUP_NAME);
		Assert.assertTrue(msg.getId() == MESSAGE_ID);
		Assert.assertFalse(msg.isCompleted());
		gateway.send(msg);
		Assert.assertTrue(msg.isCompleted());
	}

}
