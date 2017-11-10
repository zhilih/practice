package cn.hoover.practice.thread.blockQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayBlockingQueue {

	private Object notEmpty = new Object();

	private Queue<Object> queue = new LinkedList<Object>();

	private int count = 2;

	public void put(Object object) throws InterruptedException {
		queue.add(object);
		notEmpty.notifyAll();
	}

	public Object take() throws InterruptedException {
		Object object = queue.poll();
		return object;
	}

	public void putQueue() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (notEmpty) {
					for (int i = 0; i < 10; i++) {
						try {
							while (queue.size() == count)
								notEmpty.wait();
							put(i);
							System.out.println(Thread.currentThread().getName() + "put queue num = " + i);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}, "putThread").start();
	}

	public void takeQueue() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (notEmpty) {
					while (queue.size() == 0) {
						try {
							notEmpty.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						while (true) {
							Object takeNum = take();
							System.out.println(Thread.currentThread().getName() + "take queue num = " + takeNum);
						}
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		}, "takeThread").start();
	}

	public static void main(String[] args) {
		ArrayBlockingQueue queue = new ArrayBlockingQueue();
		queue.putQueue();
		queue.takeQueue();
	}
}
