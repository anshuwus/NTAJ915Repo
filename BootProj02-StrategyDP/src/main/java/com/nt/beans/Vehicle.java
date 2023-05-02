//Vehicle.java (Target class)

package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	//HAS-A property
	@Autowired
	@Qualifier("eEngg")
	private Engine engine;
	
	private Vehicle() {
		System.out.println("Vehicle:: 0-param constructor");
	}
	
	public void move(String sourcePlace,String destPlace) {
		engine.start();
		System.out.println("Journey started from:: "+sourcePlace);
		System.out.println("Journey is going on......");
		engine.stop();
		System.out.println("Journey stopped at:: "+destPlace);
	}
}
