package com.vmware.talentboost.spring.data;

public class PlayerResponse {
	public final boolean skipQuestion;
	public final String country;
	public final String capital;
	
	public PlayerResponse(boolean skip, String country, String capital){
		this.skipQuestion = skip;
		this.country = country;
		this.capital = capital;
	}
}
