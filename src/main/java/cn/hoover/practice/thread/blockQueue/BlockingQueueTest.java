package cn.hoover.practice.thread.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest{
	
	final BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(1);
	

	public void takeQueue() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						Object takeNum = blockingQueue.take();
						System.out.println("take blockingQueue num = " + takeNum);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	
	public void putQueue() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						blockingQueue.put(i);
						System.out.println("put blockingQueue num = " + i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}
	
	public static void main(String[] args) {
		BlockingQueueTest test = new BlockingQueueTest();
		test.putQueue();
		test.takeQueue();
	}
}
