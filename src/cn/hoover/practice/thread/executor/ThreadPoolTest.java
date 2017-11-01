package cn.hoover.practice.thread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadPoolTest {
	
	private int value;

	public int getValue() {
		return value;
	}

	public void increase(int value) {
		value ++ ;
	}

	public static void main(String[] args) {
		increaseMillis();
	}
	
	private static void increaseMillis() {
		ThreadPoolTest test = new ThreadPoolTest();
		int count = Runtime.getRuntime().availableProcessors();
		AtomicLong totalMillis = new AtomicLong(0);
		ExecutorService service = Executors.newFixedThreadPool(count);
		List<Future<Long>> taskList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			Callable<Long> callable = new Callable<Long>() {
				@Override
				public Long call() throws Exception {
					long startMillis = System.currentTimeMillis();
					for (int j = 0; j < 1000000; j++) {
						test.increase(j);
					}
					long endSyMillis = System.currentTimeMillis();
					long length = endSyMillis - startMillis;
					return length;
				}
			};
			
			//由于Future.get()会阻塞线程，所以将task执行结果添加到list中
			taskList.add(service.submit(callable));
		}
		
		//循环任务列表  累加执行总时间
		for (int i = 0; i < taskList.size(); i++) {
			Future<Long> task = taskList.get(i);
			try {
				totalMillis.getAndSet(task.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		service.shutdown();
		System.out.println("totalMillis =" + totalMillis);
	}
}
