package com.jqdu.cms.test.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.naming.InitialContext;

import org.apache.ibatis.transaction.Transaction;

public class TxHandler implements InvocationHandler {
	
	private Object obj ;
	
	public Object bind(Object obj) {
		this.obj = obj ;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this) ;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object result = null ;
		if(method.getName().startsWith("save")) {
			Transaction trans = null ;
			try {
				trans = (Transaction) new InitialContext().lookup("java:tx") ;
				result = method.invoke(obj, args) ;
				trans.commit(); 
			} catch (Exception e) {
				trans.rollback();
			}
		} else {
			
		}
		return result;
	}

}
