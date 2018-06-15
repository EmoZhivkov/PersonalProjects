package com.vmware.talentboost.spring;

import java.util.List;

import com.vmware.talentboost.spring.data.UserAccount;

public interface IRepository {
	public String getCapitalOf(String country);
	public List<String> getCountries();
	public List<UserAccount> getAccounts();
}
