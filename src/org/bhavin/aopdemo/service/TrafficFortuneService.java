package org.bhavin.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {	
			e.printStackTrace();
		}
		
		//return a fortune
		return "Heavy traffic till 7pm";
	}
	
}
