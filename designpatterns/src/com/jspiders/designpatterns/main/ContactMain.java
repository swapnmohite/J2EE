package com.jspiders.designpatterns.main;

import com.jspiders.designpatterns.creational.Contact;
import com.jspiders.designpatterns.creational.ContactBuilder;

public class ContactMain {
	public static void main(String[] args) {
		Contact contact = new ContactBuilder().firstname("Swapnil").lastname("Mohite").mobileNumber(9876543210L)
				.getContact();
		System.out.println(contact);
	}
}
