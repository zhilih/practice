package cn.hoover.practice.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDemo {

	public static void main(String[] args) {
//		List<String> list = new LinkedList<>();
//		list.add("aaa");
//		list.add("bbb");
//		list.add("ccc");
//		list.add("ddd");
//		
//		Iterator<String> iterator = list.iterator();
//		if (iterator.hasNext()) {
//			iterator.next();
//			iterator.remove();
//		}
//		
//		ListIterator<String> lit = list.listIterator();
//		if (lit.hasNext()) {
//			lit.next();
//			lit.remove();
//		}
//		
//		lit.next();
//		//添加在下一个元素之前的位置
//		lit.add("eee");
		
		
//		if (lit.hasPrevious()) {
//			lit.previous();
//			lit.remove();
//		}
	
//		List<String> al = Arrays.asList("aa","bb","cc","dd");
//		System.out.println(al.get(1));
//		
//		//array to set.  set to array
//		String [] as = new String[]{"aaa","bbb","ccc"};
//		HashSet<String> hSet = new HashSet<String>(Arrays.asList(as));
//		String [] bs = hSet.toArray(new String[0]);
//		
//		List<String> bl = Collections.nCopies(100, "hahaha");
//		System.out.println(bl.size());
		
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(22);
		aList.add(8);
		aList.add(12);
		aList.add(43);
		aList.add(86);
		aList.add(87);
		aList.add(23);
		
		//倒序排序，采用归并排序
		Collections.sort(aList, Collections.reverseOrder());
		//正序排序，采用归并排序
		Collections.sort(aList);
		int x = 27;
		/**
		 * 使用Collections.binarySearch参与查找元素的列表必须是有序的;
		 * 查找是否存在(x)元素，如果存在则返回正数y(该元素在列表中的index值),
		 * 如果不存在，则返回一个负数y(-y-1的值代表该元素x插入有序列表的正确index).
		 */
		int y = Collections.binarySearch(aList, x);
		System.out.println(y);
		aList.add(-y-1, x);
		
		int b = aList.get(0);
		if (aList.size()> 0) {
			for (int i = 0; i < aList.size(); i++) {
				if (b < aList.get(i)) {
					b = aList.get(i);
				}
			}
			
//			System.out.println(b);
		}
		
//		Iterator<Integer> ii = aList.iterator();
//		int c = ii.next();
//		while (ii.hasNext()) {
//			int d = ii.next();
//			if (c < d) {
//				c = d;
//			}
//		}
//		System.out.println(c);
		
		int [] inta = {3,45,2,4,63,23,25};
		if (inta.length > 0) {
			for (int i = 0; i < inta.length - 1; i++) {
				for(int j = 0; j < inta.length -1 -i; j ++) {
					if (inta[j] > inta[j+1]) {
						int temp = inta[j];
						inta[j] = inta[j+1];
						inta[j] = temp;
					}
				}
			}
		}
		
		for (int i = 0; i < inta.length; i++) {
			System.out.println(inta[i]);
		}
	}

}
