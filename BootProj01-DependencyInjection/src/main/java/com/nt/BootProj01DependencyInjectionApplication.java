package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {

	@Bean(name="id")
	public LocalDate createDate() {
		return LocalDate.now();
	}
	
	
	public static void main(String[] args) {
	    //get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
	    //get target spring bean class object
		SeasonFinder finder = ctx.getBean("sf", SeasonFinder.class);
	    //invoke the b.method
		String seasonName=finder.findSeason();
		System.out.println("Season Name:: "+seasonName);
		//close the IOC container
		((ConfigurableApplicationContext)ctx).close();
	
	}

}
