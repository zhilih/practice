package cn.hoover.practice.collection;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapStructure {

	public static void main(String[] args) {
		HashMap<Object, String> countryMap = new HashMap<Object, String>();
		countryMap.put("india","Delhi");
		countryMap.put("india","Tokyo");
	
		
		Iterator<Object> iterator = countryMap.keySet().iterator();
		while (iterator.hasNext()) {
			Object country = iterator.next();
            String capital = countryMap.get(country);
            System.out.println(country + "----" + capital);
		}
	}
}
