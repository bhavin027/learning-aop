package org.bhavin.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyMember() {
		System.out.println(getClass() +": Doing my DB work- Adding a membership...");
		return true;
	}
	
}
