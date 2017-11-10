package cn.hoover.practice.thread.reentrantLook;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLookTest extends Thread{
	
	private ReentrantLock lock = new ReentrantLock();
	
	@Override
	public void run() {
		try {
			lock.lock();
			for (int i = 0; i < 2; i++) {
			    System.out.println("ThreadName = " + Thread.currentThread().getName() + 
			            ", i  = " + i);
			}
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ReentrantLookTest test = new ReentrantLookTest();
		Thread thread1 = new Thread(test);
		Thread thread2 = new Thread(test);
		Thread thread3 = new Thread(test);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
