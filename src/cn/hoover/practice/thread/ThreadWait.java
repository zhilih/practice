package cn.hoover.practice.thread;

public class ThreadWait {
	
//	http://www.cnblogs.com/paddix/p/5381958.html
	
	//Exception
	/*public void waitTest() {
		System.out.println("wait start");
		try {
			wait(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("wait end");
	}*/
	
	// wait方法的使用必须在同步环境中
	public synchronized void waitTest() {
		System.out.println("wait start");
		try {
			wait(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("wait end");
	}

	public static void main(String[] args) {
		ThreadWait wait = new ThreadWait();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				wait.waitTest();
			}
		}).start();
	}
}
