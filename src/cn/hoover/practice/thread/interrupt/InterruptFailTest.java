package cn.hoover.practice.thread.interrupt;

public class InterruptFailTest extends Thread {

	public static void main(String[] args) throws InterruptedException {
		InterruptFailTest thread = new InterruptFailTest();

		System.out.println("thread starting");
		thread.start();

		System.out.println("thread interrupting");
		thread.interrupt();
		thread.sleep(2000);

		System.out.println("thread stopping");
	}

	/*
	 * 线程无法中断，break只是跳出for循环，还会继续执行下边的操作
	 * 
	 * @Override 
	 * 
	 * 
	 */

	@Override
	public void run() {
		try {
			// Thread.sleep(10000);
			for (int i = 0; i < 500000; i++) {
				// if (Thread.interrupted()) {
				// System.out.println("should be stopped and exit");
				// throw new InterruptedException();
				// }
				System.out.println("i=" + (i + 1));
				if (!Thread.currentThread().isInterrupted()) {
					interruptMethod();
				} else {
					
				}
			}
			System.out.println("this line is also executed. thread does not stopped");// 尽管线程被中断,但并没有结束运行。这行代码还是会被执行
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void interruptMethod() throws InterruptedException {
		
	}
}
