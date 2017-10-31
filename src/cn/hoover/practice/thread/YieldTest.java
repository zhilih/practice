package cn.hoover.practice.thread;

public class YieldTest implements Runnable{
	
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++ ) {
			System.out.println(Thread.currentThread().getName() + " ---" + i);
			if (i == 30) {
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) {
		YieldTest test = new YieldTest();
		Thread thread1 = new Thread(test, "1 test");
		Thread thread2 = new Thread(test, "2 test");
		thread1.start();
		thread2.start();
	}

}
