package com.pallelli.mvcpract.security;

public class LoginForm {

	private String name;
	private String hashedPassword;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return hashedPassword;
	}
	public void setPassword(String password) {
		this.hashedPassword = hash(password);
	}
	private String hash(String password) {
		// TODO hash password
		return password;
	}
	
	
}
