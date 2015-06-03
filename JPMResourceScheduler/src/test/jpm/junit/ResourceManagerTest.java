package test.jpm.junit;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.Before;
import org.junit.Test;

import test.jpm.messages.Message;
import test.jpm.scheduler.MessageProducer;
import test.jpm.scheduler.MessageProducerImpl;
import test.jpm.scheduler.ResourceManager;

public class ResourceManagerTest {
	private Queue<Message> msgQueue;
	private MessageProducer msgProducer;
	private ResourceManager resourceManager;
	
	/**
	 * initialize
	 */
	@Before
	public void init() {
		this.msgProducer = new MessageProducerImpl();
		this.resourceManager = new ResourceManager();
		this.msgQueue = new ConcurrentLinkedQueue<Message>();
		for(int i = 1; i <= 2; i++) {
			for(int j = 1; j <= 4; j++) {
				msgQueue.add(msgProducer.createMessage(j, "Group "+i));
			}
		}
	}
	
	/**
	 * test resources scheduling
	 */
	@Test
	public void testStartResource() {
		resourceManager.startResource(2, msgQueue);
	}
}
