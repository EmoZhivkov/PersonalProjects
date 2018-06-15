package com.vmware.talentboost.spring.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.vmware.talentboost.spring.IPlayer;
import com.vmware.talentboost.spring.data.PlayerResponse;
import com.vmware.talentboost.spring.data.UserAccount;
import org.springframework.stereotype.Component;

@Component("player")
public class ConsolePlayer implements IPlayer{
	
	private UserAccount user;
	
	public String askForCredentials(){
		System.out.println("Login as: ");
		return getInput();
	}
	
	public void authorize(UserAccount user){
		this.user = user;
	}
	
	public PlayerResponse askQuestion(String country){
		System.out.println("Guess the capital of " + country + ":");
		String answer = getInput();
		if (answer.equals("skip")) {
			return new PlayerResponse(true, null, null);
		} else {
			return new PlayerResponse(false, country, answer);
		}
	}
	private String getInput(){
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Something terrible has happened";
	}
	public void quit(String message){
		System.out.println(message);
	}
	public UserAccount getCurrentUser(){
		return user;
	}
}
