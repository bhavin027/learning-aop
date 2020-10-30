package org.bhavin.aopdemo.dao;

import org.bhavin.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() +": Doing my DB work- Adding an account...");
		
	}
}
