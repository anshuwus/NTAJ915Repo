package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootDataJpaProj04FinderMethodsApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(BootDataJpaProj04FinderMethodsApplication.class, args);
		//System.out.println("Value of i is:: "+callMyself(8));
	}
	
	/*public static long callMyself(long i) {
		if(i==1) {
			System.out.println("in if block i=1");
			return 1;
		}
		if(i==2) {
			System.out.println("in if block i=2");
			return 2;
		}
		System.out.println("Before i::"+i);
		i+=callMyself(--i-1);
		System.out.println("After i::"+i);
	
	
		return i;
	}*/

}
