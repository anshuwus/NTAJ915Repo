package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.Vehicle;

@SpringBootApplication
public class BootProj02StrategyDpApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj02StrategyDpApplication.class, args);
	    //get Target spring bean class object
		Vehicle vehicle = ctx.getBean("vehicle",Vehicle.class);
	    //invoke the b.method
		vehicle.move("Hyderabad", "Goa");
		
		//close container
		((ConfigurableApplicationContext)ctx).close();
	}

}
