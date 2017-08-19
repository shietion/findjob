package com.jqdu.cms.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicHandler implements InvocationHandler {
	
	private Object obj ;
	
	public DynamicHandler(){
		
	}
	
	public DynamicHandler(Object obj) {
		this.obj = obj ;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("执行之前");
		Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this) ;
		method.invoke(obj, args) ;
		System.out.println("执行之后");
		return null;
	}

}
