package com.vmware.talentboost.spring;

import com.vmware.talentboost.spring.data.UserAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

@Configuration
@ComponentScan(basePackageClasses = MainApp.class)
public class ApplicationConfig {
    @Bean("capitals")
    public SortedMap<String, String> getCapitals() {
        SortedMap<String, String> capitals = new TreeMap<String, String>();
        capitals.put("Bulgaria", "Sofia");
        capitals.put("Serbia", "Belgrade");
        capitals.put("Kosovo", "Pristina");
        capitals.put("Macedonia", "Skopje");
        capitals.put("Montenegro", "Podgorica");
        capitals.put("Greece", "Athens");
        capitals.put("Albania", "Tirana");
        capitals.put("Romania", "Bucharest");
        capitals.put("Slovakia", "Bratislava");
        capitals.put("Croatia", "Zagreb");
        capitals.put("Bosnia and Herzegovina", "Sarajevo");
        return capitals;
    }

    @Bean("accounts")
    public List<UserAccount> getAccounts() {
        List<UserAccount> accounts = new ArrayList<UserAccount>();
        accounts.add(new UserAccount("dushan", "player"));
        accounts.add(new UserAccount("tanya", "player"));
        accounts.add(new UserAccount("oggy", "admin"));
        return accounts;
    }
}
