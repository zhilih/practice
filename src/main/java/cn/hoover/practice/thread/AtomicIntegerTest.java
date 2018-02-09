package cn.hoover.practice.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	private static AtomicInteger ai = new AtomicInteger(0);
	
	public static void main(String[] args) {
		System.out.println(ai.getAndIncrement() );
		System.out.println(ai.get());
	}
}
