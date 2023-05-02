package com.nt.runner;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Medal;
import com.nt.document.Player;
import com.nt.document.Sport;
import com.nt.service.ISportsMgmtService;

@Component
public class OneToManyAssociationTestRunner implements CommandLineRunner{
	@Autowired
	private ISportsMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			//child class1 object
			Sport sport1=new Sport(new Random().nextInt(1000),"badminton",new String[] {"racket","scock","net"});
			Sport sport2=new Sport(new Random().nextInt(1000),"tennis",new String[] {"racket","tennis ball","net"});
			
			//child class2 object
			Medal medal1=new Medal("olympic-gold","Gold","Tokyo-olympic","tokyo");
			Medal medal2=new Medal("cwg-silver","silver","cwg-japan","tokyo");
			
			//parent class object
			Player player=new Player(new Random().nextInt(1000),"Sindhu","Hyd",Set.of(sport1,sport2),Map.of("medal1", medal1,"medal2",medal2));
			
			//invoke the method
			//System.out.println(service.registerPlayerWithSportsAndMedals(player));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("===========findAll() operation===========");
		service.fetchAllPlayersInfo().forEach(per -> {
			System.out.println("Parent:: "+per);
			//access child1 objects
			Set<Sport> sports=per.getSports();
			//sports.forEach(System.out::println);
			sports.forEach(sport -> {
				System.out.println("Child1:: "+sport);
			});
			//access child2 objects
			Map<String,Medal> medals=per.getMedals();
			medals.forEach((type,medal) -> {
				System.out.println("child2:: "+type+"......."+medal);
			});
		});
	}

}
