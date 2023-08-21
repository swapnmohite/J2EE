package com.jspiders.designpatterns.main;

import com.jspiders.designpatterns.creational.SingletonEager;

public class SingletonEagerMain {

	public static void main(String[] args) {
		SingletonEager singletoneager1 = SingletonEager.getobject();
		System.out.println(singletoneager1);
		SingletonEager singletoneager2 = SingletonEager.getobject();
		System.out.println(singletoneager2);
		SingletonEager singletoneager3 = SingletonEager.getobject();
		System.out.println(singletoneager3);
	}

}
