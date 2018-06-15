package com.vmware.talentboost.spring;

import com.sun.org.glassfish.gmbal.InheritedAttribute;
import com.vmware.talentboost.spring.data.PlayerResponse;
import com.vmware.talentboost.spring.data.UnauthorizedException;
import com.vmware.talentboost.spring.data.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Game {
	private IAccountManager accountManager;
	private IQuestionManager questionManager;
	private IPlayer player;
	private int wrongAnswers;

	@Autowired
	public Game(@Qualifier("accountManager") IAccountManager accountManager,
				@Qualifier("questionManager") IQuestionManager questionManager,
				@Qualifier("player") IPlayer player) {
		this.accountManager = accountManager;
		this.questionManager = questionManager;
		this.player = player;
		wrongAnswers = 0;
	}
	
	public void takeTurn() {
		String country = questionManager.getQuestion();
		PlayerResponse guess = player.askQuestion(country);
		if (guess.skipQuestion) {
			return;
		}
		if (questionManager.checkResponse(guess)) {
			questionManager.removeQuestion(country);
		} else {
			wrongAnswers++;
		}
	}
	public void run(){
		
		if (!tryLogin()) {
			return;
		}
		
		while (!questionManager.allGuessed() && wrongAnswers <3) {
			takeTurn();
		}
		if (wrongAnswers<3 && questionManager.allGuessed()){
			player.quit(player.getCurrentUser().username + " won the GAME!");
		} else {
			player.quit(player.getCurrentUser().username + " lost the GAME!");
		}
	}
	
	private boolean tryLogin(){
		String userInput = player.askForCredentials();
		try {
			UserAccount user = accountManager.authenticate(userInput);
			player.authorize(user);
			if (player.getCurrentUser().role.equals("admin")){
				player.quit("Admins cannot play!");
				return false;
			}
			return true;
		} catch (UnauthorizedException e){
			return tryLogin();
		}
	}
}
