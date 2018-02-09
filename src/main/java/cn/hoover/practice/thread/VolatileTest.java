package cn.hoover.practice.thread;

public class VolatileTest extends Thread{

	private boolean isRunning = true;
	
	//当一个线程要使用volatile变量时，它会直接从主内存中读取，而不使用自己工作内存中的副本。
	//当一个线程对一个volatile变量写时，它会将变量的值刷新到共享内存(主内存)中。
//	private volatile boolean isRunning = true;

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	@Override
	public void run() {
		System.out.println("子线程进入run方法");
		while (isRunning == true) {
//			System.out.println("进入死循环");
		}
		System.out.println("子线程执行完毕");
	}
	
	public static void main(String[] args) {
		VolatileTest test = new VolatileTest();
		try {
			test.start();
			Thread.sleep(3000);
			test.setRunning(false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
