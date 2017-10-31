package cn.hoover.practice.thread;

public class ReorderingTest {

//	private static AtomicBoolean isRead = new AtomicBoolean();
//	private static AtomicInteger number = new AtomicInteger();
	
	private static boolean isRead;
	
	private static int number;
	
	private static class ReadThread extends Thread{
		public void run() {
			while (isRead) {
				System.out.println(" --- " + number);
			}
		}
	}
	
	public static void main(String[] args) {
		new ReadThread().start();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		number = 10 ;
		isRead = true;
//		isRead.set(true);
//		number.set(10);
	}
}
