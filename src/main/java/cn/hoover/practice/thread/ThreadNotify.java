package cn.hoover.practice.thread;

public class ThreadNotify {
	
//	http://www.cnblogs.com/paddix/p/5381958.html
	
	public synchronized void notifyTest() {
		System.out.println(Thread.currentThread().getName() + "start");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "end");
	}

	public static void main(String[] args) {
		try {
			ThreadNotify test = new ThreadNotify();
			for (int i = 0; i < 5; i++) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						test.notifyTest();
					}
				}).start();
			}
			
			synchronized (test) {
				test.notify();
			}
			Thread.sleep(3000);
			System.out.println("==================");
			
			synchronized (test) {
				test.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
