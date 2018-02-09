package cn.hoover.practice.thread.reentrantLook;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest extends Thread {

	private ReentrantLock lock = new ReentrantLock();

	private Condition condition = lock.newCondition();

	public  void await() {
		try {
			lock.lock();
			System.out.println("await时间为：" + System.currentTimeMillis());
			condition.await();
			System.out.println("await等待结束");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public  void signal() {
		try {
			lock.lock();
			System.out.println("await时间为：" + System.currentTimeMillis());
			condition.signal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	@Override
	public void run() {
		await();
	}

	public static void main(String[] args) {
		ConditionTest test = new ConditionTest();
		Thread thread = new Thread(test);
		thread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.signal();
	}
}
