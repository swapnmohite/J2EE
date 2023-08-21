package com.jspiders.designpatterns.main;

import com.jspiders.designpatterns.creational.SingletonLazy;

public class SingletonLazyMain {

	public static void main(String[] args) {
		SingletonLazy singletonlazy1 = SingletonLazy.getobject();
		System.out.println(singletonlazy1);
		SingletonLazy singletonlazy2 = SingletonLazy.getobject();
		System.out.println(singletonlazy2);
		SingletonLazy singletonlazy3 = SingletonLazy.getobject();
		System.out.println(singletonlazy3);
	}

}