package cn.hoover.practice.spring.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class DynaProxyHello implements InvocationHandler{
	
	//目标对象
	private Object target;
	
	public Object bind(Object object) {
		this.target = object;
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
				this.target.getClass().getInterfaces(), this);
		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		Logger.start();
		result = method.invoke(this.target, args);
		Logger.end();
		return result;
	}

}
