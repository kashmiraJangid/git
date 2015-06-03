package test.jpm.scheduler;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

import test.jpm.external.Gateway;
import test.jpm.external.GatewayImpl;
import test.jpm.messages.Message;

/**
 * Manage resource
 * @author Kashmira
 *
 */
public class ResourceManager  {
	// Concurrent Linked Queue for message
	private Queue<Message> msgQueue;
	// Gateway
	private Gateway gateway;
	
	/**
	 * initialize
	 */
	public ResourceManager() {
		this.msgQueue = new ConcurrentLinkedQueue<Message>();
		this.gateway = new GatewayImpl();
	}
	
	/**
	 * inner class for start all resources at once, also start listening to queue and consume a message
	 */
	private class ResourceStart implements Runnable {
		
		CountDownLatch countDownLatch;
		private final Random r;
		
		public ResourceStart(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
			 r = new Random();
		}
		
		@Override
		public void run() {
			try {
				countDownLatch.await();
				consume();
				while (true) {
					synchronized (msgQueue) {
						msgQueue.wait();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		private void consume() throws InterruptedException {
	        while (!msgQueue.isEmpty()) {
	            Message m = msgQueue.poll();
	            if (m != null) {
	                gateway.send(m);
	                System.out.println("Message sent to gateway: " + m.toString());
	                Thread.sleep(5000);
	            }
	        }
	    }
		
	}
	
	/**
	 * Initialize and start resources 
	 * @param totalResource
	 * @param msgQueue
	 */
	public void startResource(int totalResource, Queue<Message> msgQueue) {
		CountDownLatch cd = new CountDownLatch(1);
		this.msgQueue = msgQueue;
		for(int i = 0; i < totalResource; i++) {
			Thread t = new Thread(new ResourceStart(cd));
			t.start();
		}
		System.out.println("All resources are up.. ");
		cd.countDown();
		
	}
	
}
