package cn.hoover.practice.spring.proxy.impl;

import cn.hoover.practice.spring.proxy.IHello;

public class Hello implements IHello{

	@Override
	public void sayHello(String str) {
		System.out.println("hello " + str);
	}

}
