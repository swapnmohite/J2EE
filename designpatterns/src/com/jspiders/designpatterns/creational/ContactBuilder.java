package com.jspiders.designpatterns.creational;

public class ContactBuilder {
	private String firstname;
	private String middlename;
	private String lastname;
	private String nickname;
	private String email;
	private long mobileNumber;
	private long landlineNumber;
	private String address;
	private String gender;
	private int age;
	private String dateofbirth;

	public ContactBuilder firstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactBuilder middlename(String middlename) {
		this.middlename = middlename;
		return this;
	}

	public ContactBuilder lastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactBuilder nickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	public ContactBuilder email(String email) {
		this.email = email;
		return this;
	}

	public ContactBuilder mobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	public ContactBuilder landlineNumber(long landlineNumber) {
		this.landlineNumber = landlineNumber;
		return this;
	}

	public ContactBuilder address(String address) {
		this.address = address;
		return this;
	}

	public ContactBuilder gender(String gender) {
		this.gender = gender;
		return this;
	}

	public ContactBuilder age(int age) {
		this.age = age;
		return this;
	}

	public ContactBuilder dateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
		return this;
	}

	public Contact getContact() {

		Contact contact = new Contact(firstname, middlename, lastname, nickname, email, mobileNumber, landlineNumber,
				address, gender, age, dateofbirth);
		return contact;
	}

}
