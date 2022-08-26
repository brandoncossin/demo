package com.example.demo;

public class Signup {
	private String phoneNumber;
    private String firstName;
	private String lastName;
    private String password;

	public String phoneNumber() {
		return phoneNumber;
	}

	public void phoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String firstName() {
		return firstName;
	}

	public void firstName(String firstName) {
		this.firstName = firstName;
	}
    public String lastName() {
		return lastName;
	}

	public void lastName(String lastName) {
		this.lastName = lastName;
	}
    public String password() {
		return password;
	}

	public void password(String password) {
		this.password = password;
	}
}
