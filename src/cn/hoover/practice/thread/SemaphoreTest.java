package cn.hoover.practice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Semaphore semaphore = new Semaphore(5);
		for (int i = 0; i < 20; i++) {
			int indexNo = i;
			Runnable run = new Runnable() {
				
				@Override
				public void run() {
					try {
						semaphore.acquire();
						System.out.println("accessing = " + indexNo);
						Thread.sleep((long) (Math.random() * 10000));
						semaphore.release();
						System.out.println("-----------------"+semaphore.availablePermits());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			
			executor.submit(run);
		}
		
		executor.shutdown();
	}
}
