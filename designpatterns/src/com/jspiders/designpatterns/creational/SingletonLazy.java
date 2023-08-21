package com.jspiders.designpatterns.creational;

public class SingletonLazy {
	private static SingletonLazy singletonLazy;

	private SingletonLazy() {
		System.out.println("Constructor is accessed");
	}

	public static SingletonLazy getobject() {
		if (singletonLazy == null) {
			singletonLazy = new SingletonLazy();
		}
		return singletonLazy;
	}
}