package com.jqdu.cms.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal dog = new DogAnimal() ;
		InvocationHandler ih = new DynamicHandler(dog) ;
		Animal am = (Animal) Proxy.newProxyInstance(dog.getClass().getClassLoader(), dog.getClass().getInterfaces(), ih) ;
		am.food();
				
	}

}
