package cn.hoover.practice.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicDemo extends Thread{

	//代码段一
	/*//内部使用  private volatile int value;
	private static AtomicInteger ai = new AtomicInteger();
	
	private static int a;
	
	@Override
    public void run() {
		ai.incrementAndGet();
		a++;
    }
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			AtomicDemo demo = new AtomicDemo();
			demo.start();
			try {
				demo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(" --- " + ai.get() + " --- " + a);
	}*/
	
	
	private int value;
	
	private synchronized void increase(int value) {
		value++ ;
	}
	
	//代码段二
	//synchronized
	private static void syncrTest(AtomicDemo demo) throws InterruptedException {
		int count = Runtime.getRuntime().availableProcessors();
		AtomicLong totalMillis = new AtomicLong(0);
		//闭锁  并发流程控制
		CountDownLatch startLatch = new CountDownLatch(1);
		CountDownLatch endLatch = new CountDownLatch(count);
		for (int i = 0; i < count; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						startLatch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					long startSyMillis = System.currentTimeMillis();
					for (int j = 0; j < 1000000; j++) {
						demo.increase(j);
					}
					long endSyMillis = System.currentTimeMillis();
					long length = endSyMillis - startSyMillis;
					totalMillis.addAndGet(length);                  
					endLatch.countDown();
				}
			}).start();
		}
		startLatch.countDown();
		endLatch.await();
		System.out.println("syncr millis = " + totalMillis.get()/8);
	}

	
	//Atomic
	private static void atomicTest() throws InterruptedException {
		
		int count = Runtime.getRuntime().availableProcessors();
		System.out.println("count =" + count);
		AtomicLong totalMillis = new AtomicLong();
		//闭锁
		CountDownLatch endlatch = new CountDownLatch(count);
		CountDownLatch startLatch = new CountDownLatch(1);
		for (int i = 0; i < count; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						startLatch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					long startAtMillis = System.currentTimeMillis();
					AtomicInteger ai = new AtomicInteger(0);
					for (int j = 0; j < 1000000; j++) {
						ai.incrementAndGet();
					}
					long endAtMillis = System.currentTimeMillis();
					long lenght = endAtMillis - startAtMillis;
					totalMillis.addAndGet(lenght);
					endlatch.countDown();
				}
			}).start();
		}
		
		startLatch.countDown();
		endlatch.await();
		System.out.println("Atomic mills = " + (totalMillis.get()/8));
	}
	
	public static void main(String[] args) throws InterruptedException {
		AtomicDemo demo = new AtomicDemo();
		
		//比较synchronized 和 atomic的性能，事实证明 atomic要比synchronized效率高
		syncrTest(demo);
		atomicTest();
		
	}

	
	//TODO  线程池统计两个方法的平均消耗时间
	
	
	
}
