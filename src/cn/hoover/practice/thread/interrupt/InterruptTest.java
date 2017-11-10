package cn.hoover.practice.thread.interrupt;

public class InterruptTest extends Thread{

	public static void main(String[] args) throws InterruptedException {
		InterruptTest thread = new InterruptTest();
		
		System.out.println("thread is startting");
		thread.start();
		Thread.sleep(2000);
		
		thread.stop();
	}
}
