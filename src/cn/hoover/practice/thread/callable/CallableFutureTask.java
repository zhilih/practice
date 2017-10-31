package cn.hoover.practice.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableFutureTask {

	public static void main(String[] args) {
		//线程池执行
		/*ExecutorService executorService = Executors.newCachedThreadPool();
		CallableTask task = new CallableTask();
		
		FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
		executorService.submit(futureTask);
		executorService.shutdown();*/
		
		//线程执行
		CallableTask ctask = new CallableTask();
		FutureTask<Integer> cfutureTask = new FutureTask<Integer>(ctask);
//		Thread thread = new Thread(cfutureTask);
//		thread.start();
		try {
			//未启动  所以会一直阻塞
			System.out.println(cfutureTask.get());
			//阻塞3s后未拿到结果，继续执行
			System.out.println(cfutureTask.get(3, TimeUnit.SECONDS));
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(cfutureTask.isDone());
		//开始执行
		cfutureTask.run();
		System.out.println(cfutureTask.isDone());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("主线程开始执行...");
		
		try {
			System.out.println(cfutureTask.get());
//			System.out.println(futureTask.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("主线程执行完毕.");
	}

}
