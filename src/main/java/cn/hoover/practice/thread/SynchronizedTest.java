package cn.hoover.practice.thread;

public class SynchronizedTest {

//	http://www.cnblogs.com/paddix/p/5367116.html
//	http://www.cnblogs.com/cielosun/p/6650161.html

	//代码段一
	/*private void method1() {
		System.out.println("method 1 start");
		
		try {
			System.out.println("method 1 execute");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("method 1 end");
	}
	
	private void method2() {
		System.out.println("method 2 start");
		
		try {
			System.out.println("method 2 execute");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("method 2 end");
	}
	
	public static void main(String[] args) {
		SynchronizedTest test1 = new SynchronizedTest();
		SynchronizedTest test2 = new SynchronizedTest();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test1.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test2.method2();
			}
		}).start();
	}*/

	
	//代码段二
	/*private synchronized void method1() {
		System.out.println("method 1 start");
		
		try {
			System.out.println("method 1 execute");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("method 1 end");
	}
	
	private synchronized void method2() {
		System.out.println("method 2 start");
		
		try {
			System.out.println("method 2 execute");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("method 2 end");
	}
	
	
	public static void main(String[] args) {
		SynchronizedTest test = new SynchronizedTest();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.method2();
			}
		}).start();
	}*/
	
	
	//代码段三
	/*private static synchronized void method1() {
		System.out.println("method 1 start");
		
		try {
			System.out.println("method 1 execute");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("method 1 end");
	}
	
	private static synchronized void method2() {
		System.out.println("method 2 start");
		
		try {
			System.out.println("method 2 execute");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("method 2 end");
	}
	
	
	public static void main(String[] args) {
		SynchronizedTest test1 = new SynchronizedTest();
		SynchronizedTest test2 = new SynchronizedTest();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test1.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test2.method2();
			}
		}).start();
	}*/
	
	
	//代码段4
	private void method1() {
		System.out.println("method 1 start");
		
		try {
			synchronized (this) {
				System.out.println("method 1 execute");
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("method 1 end");
	}
	
	private void method2() {
		System.out.println("method 2 start");
		
		try {
			synchronized (this) {
				System.out.println("method 2 execute");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("method 2 end");
	}
	
	
	public static void main(String[] args) {
		SynchronizedTest test = new SynchronizedTest();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.method2();
			}
		}).start();
	}
	
	//内存可见性
	/*private static int x;
	
	private synchronized void method1() {
		System.out.println("method 1 start");
		try {
			x = 1;
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.err.println("method 1 end x=" + x);
	}
	
	private synchronized void method2() {
		System.out.println("method 2 start");
		int i = 0;
		try {
			 i = x;
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.err.println("method 2 end x=" + x + " i=" + i);
	}
	
	public static void main(String[] args) {
		SynchronizedTest test = new SynchronizedTest();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.method2();
			}
		}).start();
	}*/
}
