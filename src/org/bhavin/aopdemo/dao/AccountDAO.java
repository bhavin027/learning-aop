package org.bhavin.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.bhavin.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() +": Doing my DB work- Adding an account...");
		
	}
	
	public boolean doWork() {
		System.out.println(getClass() +": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() +": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() +": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() +": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() +": setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<>();
		
		// create sample account
		Account temp1= new Account("Ronaldinho","Level Ultimate");
		Account temp2= new Account("Rooney","Level 8");
		Account temp3= new Account("Jane Dao","Level 5");
		Account temp4= new Account("Ronaldo","Level 8");
		
		// add the to account list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		myAccounts.add(temp4);
		
		return myAccounts;
	}
	
}
