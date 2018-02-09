package cn.hoover.practice.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class UnsafeSequence implements Runnable{

	private int value;
	
	private static AtomicInteger ai = new AtomicInteger(0);
	
	public UnsafeSequence(int value) {
		this.value = value;
	}

	/**
	 * 线程安全
	 * @return
	 */
	public synchronized int getValue() {
		return value ++;
	}
	
	/**
	 * 非线程安全
	 * @return
	 */
	public int getNextValue() {
		return value ++;
	}
	
	@Override
	public void run() {
//		System.out.println(Thread.currentThread().getName() +" --- " + getValue());
//		System.out.println(Thread.currentThread().getName() +" --- " + getNextValue());
		System.out.println("+++" + Thread.currentThread().getName() + " ---- " + ai.getAndIncrement() + " --- " + System.nanoTime());
		System.out.println("---" + Thread.currentThread().getName() + " ---- " + ai.get() + " --- " + System.nanoTime());
	}
	
	public static void main(String[] args) {
		UnsafeSequence uSequence1 = new UnsafeSequence(0);
		Thread a = new Thread(uSequence1);
		Thread b = new Thread(uSequence1);
		a.start();
		b.start();
	}
}
