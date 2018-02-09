package cn.hoover.practice.thread;

public class JoinTest implements Runnable{

//	http://www.cnblogs.com/paddix/p/5381958.html
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + "Test start ---");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + "Test end ---");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new JoinTest());
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Test finished");
	}
}
