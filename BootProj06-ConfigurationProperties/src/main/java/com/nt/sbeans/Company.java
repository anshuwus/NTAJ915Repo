//Company.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("comp")
@Setter
@ToString
@PropertySource("com/nt/resource/App.properties")
@ConfigurationProperties(prefix="org.nit")
public class Company {
	@Value("${org.nit.cname}")
	private String name;
	private String addrs;
	private Long pincode;
	private Long contact;
	
	@Value("${nit.size}")
	private Integer size;
	/*@Value("${org.nit.name}")
	private String name;
	@Value("${org.nit.addrs}")
	private String addrs;
	@Value("${org.nit.pincode}")
	private Long pincode;
	@Value("${org.nit.contact}")
	private Long contact;*/
}
