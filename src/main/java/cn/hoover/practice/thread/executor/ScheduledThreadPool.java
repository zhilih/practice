package cn.hoover.practice.thread.executor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

	public static void main(String[] args) throws InterruptedException {
		int corePoolSize = Runtime.getRuntime().availableProcessors();
		ScheduledExecutorService service = Executors.newScheduledThreadPool(corePoolSize);
		
		//schedule to run after sometime
        System.out.println("Current Time = "+new Date());
        
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			
			Runnable run = new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName()+" Start. Time = "+new Date());
			        try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			        System.out.println(Thread.currentThread().getName()+" End. Time = "+new Date());
				}
			};
			
			// 延迟10s执行
//			service.schedule(run, 10, TimeUnit.SECONDS);
			
			//每10s执行一次
//			service.scheduleAtFixedRate(run, 0, 10, TimeUnit.SECONDS);
			
			//延迟周期性执行   每次延迟15秒执行
			service.scheduleWithFixedDelay(run, 0, 15, TimeUnit.SECONDS);
		}
		
		Thread.sleep(30000);
		service.shutdown();
		while(!service.isTerminated()){
            //wait for all tasks to finish
        }
		System.out.println("Finished all threads");
	}
}
