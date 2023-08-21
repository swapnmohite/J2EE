package com.jspiders.designpatterns.creational;

public class Contact {

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

	public Contact(String firstname, String middlename, String lastname, String nickname, String email,
			long mobileNumber, long landlineNumber, String address, String gender, int age, String dateofbirth) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.nickname = nickname;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.landlineNumber = landlineNumber;
		this.address = address;
		this.gender = gender;
		this.age = age;
		this.dateofbirth = dateofbirth;
	}

	@Override
	public String toString() {
		return "Contact [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", nickname=" + nickname + ", email=" + email + ", mobileNumber=" + mobileNumber + ", landlineNumber="
				+ landlineNumber + ", address=" + address + ", gender=" + gender + ", age=" + age + ", dateofbirth="
				+ dateofbirth + "]";
	}

}
