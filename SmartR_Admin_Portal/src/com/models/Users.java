package com.models;

public class Users {
	public String username;
	public String password;

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Users() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}	
}
