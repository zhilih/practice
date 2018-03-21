package cn.hoover.practice.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("111");
		set.add("222");
		set.add("333");
		set.add("444");
		
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
