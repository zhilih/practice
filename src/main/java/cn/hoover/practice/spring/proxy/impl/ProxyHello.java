package cn.hoover.practice.spring.proxy.impl;

import cn.hoover.practice.spring.proxy.IHello;
import cn.hoover.practice.spring.proxy.Logger;

public class ProxyHello implements IHello{

	private IHello hello;   
	
    public ProxyHello(IHello hello) {
        super();
        this.hello = hello;
    }
    
    @Override
    public void sayHello(String str) {
        Logger.start();//添加特定的方法
        hello.sayHello(str);
        Logger.end();
    }
}
