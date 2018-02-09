package cn.hoover.practice.thread.callable;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("子线程正在进行计算...");
		Thread.sleep(2000);
		int count = 0;
		for (int i = 0; i < 100; i++) {
			count += i;
		}
		return count;
	}

}
