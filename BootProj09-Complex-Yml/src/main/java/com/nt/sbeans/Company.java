package com.nt.sbeans;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class Company {
	private Integer id;
	private String name;
	private String addrs;
	private String size;
}
