package com.discoveri.heartihealth.model;

import java.util.List;

public class Memberinfo {
	private int id;
	private String username;
	private String firstname;
	private String lastname;
	private int age;
	private String gender;
	private String email;
	private String phonenumber;
	private List<AddressInfo> addrssinfo;

	public Memberinfo() {
		
	}

	public List<AddressInfo> getAddrssinfo() {
		return addrssinfo;
	}

	public void setAddrssinfo(List<AddressInfo> addrssinfo) {
		this.addrssinfo = addrssinfo;
	}

	public Memberinfo(int id, String username, String firstname, String lastname, int age, String gender, String email,
			String phonenumber, List<AddressInfo> addrssinfo) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phonenumber = phonenumber;
		this.addrssinfo = addrssinfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}
