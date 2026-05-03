package com.te.dta;

public class UserAccount {
	
	private int user_id;
	private String user_name;
	private int user_age;
	private String user_city;
	
	public UserAccount() {
		super();
	
	}
	

	public UserAccount(int user_id, String user_name, int user_age, String user_city) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_age = user_age;
		this.user_city = user_city;
	}


	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_city() {
		return user_city;
	}
	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	@Override
	public String toString() {
		return "UserAccount [user_id=" + user_id + ", user_name=" + user_name + ", user_age=" + user_age
				+ ", user_city=" + user_city + "]";
	}
	
}
