package cn.hoover.practice.thread;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest implements Runnable{
	
	private CyclicBarrier barrier;

	public CyclicBarrierTest(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println("I am " + Thread.currentThread().getName() + ", i am ready.");
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("I am " + Thread.currentThread().getName() + ", i am gooing.");
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(3);
		CyclicBarrierTest test = new CyclicBarrierTest(barrier);
		Thread thread1 = new Thread(test, "张三");
		Thread thread2 = new Thread(test, "李四");
		Thread thread3 = new Thread(test, "王五");
		thread1.start();
		thread2.start();
		thread3.start();
		
//		Thread.currentThread().join();
		
		
	}
}
