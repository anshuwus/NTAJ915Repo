package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("cust")
@Setter
@ToString
@ConfigurationProperties(prefix="cust.info")
public class Customer {
	private Integer custNo;
	private String custName;
	private String custAddrs;
	private Double billAmt;
	
}
