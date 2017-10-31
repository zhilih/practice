package cn.hoover.practice.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteTest {

	//错误的示范
	/*public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		final List<String> newList = new ArrayList<String>(list);
		
		Thread thread = new Thread(new Runnable() {
			int count = -1;
			@Override
			public void run() {
				while (true) {
					newList.add(count ++ +"");
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
		try {
			Thread.currentThread().sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < newList.size(); i++) {
			System.out.println(newList.get(i));
		}
	}*/

	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		final CopyOnWriteArrayList<String> newList = new CopyOnWriteArrayList<String>(list);
		
		Thread thread = new Thread(new Runnable() {
			int count = -1;
			@Override
			public void run() {
				while (true) {
					newList.add(count ++ +"");
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
		try {
			Thread.currentThread();
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < newList.size(); i++) {
			System.out.println(newList.get(i));
		}
	}
}
