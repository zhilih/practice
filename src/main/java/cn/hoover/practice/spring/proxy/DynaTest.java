package cn.hoover.practice.spring.proxy;

import cn.hoover.practice.spring.proxy.impl.Hello;

public class DynaTest {
	//https://www.cnblogs.com/lcngu/p/5339555.html
	public static void main(String[] args) {
		IHello hello = (IHello) new DynaProxyHello().bind(new Hello());
		hello.sayHello("明天");
	}
}
