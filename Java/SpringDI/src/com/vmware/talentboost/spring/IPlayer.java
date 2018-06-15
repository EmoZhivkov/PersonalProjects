package com.vmware.talentboost.spring;

import com.vmware.talentboost.spring.data.PlayerResponse;
import com.vmware.talentboost.spring.data.UserAccount;

public interface IPlayer {
	public String askForCredentials();
	public void authorize(UserAccount user);
	public PlayerResponse askQuestion(String country);
	public void quit(String message);

	public UserAccount getCurrentUser();
}
