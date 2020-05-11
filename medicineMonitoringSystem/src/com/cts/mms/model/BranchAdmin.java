package com.cts.mms.model;

public class BranchAdmin {
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String phoneNumber;
	private int branchAdminId;
	private String password;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getBranchAdminId() {
		return branchAdminId;
	}
	public void setBranchAdminId(int branchAdminId) {
		this.branchAdminId = branchAdminId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "branchAdmin [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", branchAdminId=" + branchAdminId + ", password=" + password + "]";
	}
	

}
