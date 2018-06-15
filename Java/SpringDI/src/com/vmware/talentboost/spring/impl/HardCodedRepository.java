package com.vmware.talentboost.spring.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.vmware.talentboost.spring.IRepository;
import com.vmware.talentboost.spring.data.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("repository")
public class HardCodedRepository implements IRepository{

	private SortedMap<String, String> capitals;
	private List<UserAccount> accounts;

	@Autowired
	public HardCodedRepository(@Qualifier("capitals") SortedMap<String, String> capitals,
                               @Qualifier("accounts") List<UserAccount> accounts) {
	    this.accounts = accounts;
	    this.capitals = capitals;
	}
	
	public String getCapitalOf(String country){
		return capitals.get(country);
	}
	public List<String> getCountries(){
		return new ArrayList<String>(capitals.keySet());
	}
	public List<UserAccount> getAccounts(){
		return accounts;
	}

}
