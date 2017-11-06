package cn.hoover.practice.thread.interrupt;

public class InterruptFailTest extends Thread{
	
	boolean stop = false;

	public static void main(String[] args) throws InterruptedException {
		InterruptFailTest thread = new InterruptFailTest();
		
		System.out.println("thread starting");
		thread.start();
		Thread.sleep(2000);
		
		System.out.println("thread interrupting");
		thread.interrupt();
		thread.sleep(2000);
		
		System.out.println("thread stopping");
	}
	
	@Override
	public void run() {
		while (!stop) {
			System.out.println("thread is running");
			long time = System.currentTimeMillis();
            while((System.currentTimeMillis()-time < 1000)) {
            }
		}
		
		System.out.println("Thread exiting under request..." );
	}
}
