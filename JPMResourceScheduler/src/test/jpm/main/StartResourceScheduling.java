package test.jpm.main;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import test.jpm.messages.Message;
import test.jpm.scheduler.MessageProducer;
import test.jpm.scheduler.MessageProducerImpl;
import test.jpm.scheduler.ResourceManager;

/**
 * Resource scheduling main class
 * @author Kashmira
 */
public class StartResourceScheduling {

	public static void main(String[] args) {
		MessageProducer mp = new MessageProducerImpl();
		ResourceManager r = new ResourceManager();
		Queue<Message> queue = new ConcurrentLinkedQueue<Message>();
		for(int i = 1; i <= 2; i++) {
			for(int j = 1; j <= 4; j++) {
				queue.add(mp.createMessage(j, "G"+i));
			}
		}
		r.startResource(3, queue);
	}
}
