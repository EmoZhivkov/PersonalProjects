package com.vmware.talentboost.spring.data;

public class UserAccount {
	public final String username;
	public final String role;
	
	public UserAccount(String username, String role) {
		this.username = username;
		this.role = role;
	}
}
