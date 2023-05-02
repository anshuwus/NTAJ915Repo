package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerMgmtService;

@Component
public class DateAndTimeTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*Customer cust=new Customer("Ravi","Delhi",
				                         LocalDateTime.of(2000, 04,23,12,00,0),
				                         LocalTime.now(),
				                         LocalDate.now());
		System.out.println(service.registerCustomer(cust));
		*/
	
		service.getAllCustomers().forEach(System.out::println);
	}

}
