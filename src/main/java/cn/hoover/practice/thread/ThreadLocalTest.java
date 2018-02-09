package cn.hoover.practice.thread;

public class ThreadLocalTest {

//	http://www.cnblogs.com/dolphin0520/p/3920407.html
	
	ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
	ThreadLocal<String> StringLocal = new ThreadLocal<String>();
	
	private void setLocal() {
		longLocal.set(Thread.currentThread().getId());
		StringLocal.set(Thread.currentThread().getName());
	}
	
	private long getLong() {
		return longLocal.get();
	}
	
	private String getString () {
		return StringLocal.get();
	}
	
	public static void main(String[] args) throws Exception{
		ThreadLocalTest test = new ThreadLocalTest();
		
		test.setLocal();
		System.out.println(test.getLong());
		System.out.println(test.getString());
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.setLocal();
				System.out.println(test.getLong());
				System.out.println(test.getString());
			}
		});
		
		thread.start();
		thread.join();
		
		System.out.println(test.getLong());
		System.out.println(test.getString());
	}
}
