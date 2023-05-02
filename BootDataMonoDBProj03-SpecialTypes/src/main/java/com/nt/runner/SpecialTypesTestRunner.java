package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.PlayerInfo;
import com.nt.service.IPlayerMmtService;

@Component
public class SpecialTypesTestRunner implements CommandLineRunner {
	@Autowired
	private IPlayerMmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		PlayerInfo info=new PlayerInfo();
		info.setPid(new Random().nextInt(10000));
		info.setPname("jadeja"); info.setPaddrs("jaipur"); info.setNickNames(List.of("jaddu","laddo","jadu","sir"));
		info.setFriends(new String[] {"dhoni","ashwin","raina","kholi"});
		info.setImpKnocks(Map.of("asia cup","35 runs","2019 world cup semi-final","60+runs"));
		info.setContactNumbers(Set.of(93482499L,89123923L,924929234L));
		Properties props=new Properties();
		props.put("aadhar", "999324GHGHS88");
		props.put("panCard", "88138388JASA12");
	    info.setIdDetails(props);
	    System.out.println(service.registerPlayer(info));
	}

}
