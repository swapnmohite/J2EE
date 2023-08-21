package com.jspiders.designpatterns.creational;

public class SingletonEager {
	private static SingletonEager singletongager = new SingletonEager();

	private SingletonEager() {

	}

	public static SingletonEager getobject() {
		return singletongager;
	}
}
