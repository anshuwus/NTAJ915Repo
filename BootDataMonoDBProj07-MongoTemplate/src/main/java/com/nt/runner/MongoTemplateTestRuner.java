package com.nt.runner;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.StockDetails;
import com.nt.service.IStockMgmtService;

@Component
public class MongoTemplateTestRuner implements CommandLineRunner{
	@Autowired
	private IStockMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("------save document operation--------");
		StockDetails details=new StockDetails(new Random().nextInt(1000),"SBI",89892,"DSE");
		//String result=service.registerStockDetails(details);
		//System.out.println(result);
		
		System.out.println("-------insertAll(-) to save multiple document-------");
		StockDetails details1=new StockDetails(new Random().nextInt(1000),"SBI",999989892,"BSE");
		StockDetails details2=new StockDetails(new Random().nextInt(1000),"Bajaj",9892,"BSE");
		StockDetails details3=new StockDetails(new Random().nextInt(1000),"PNB",9992,"BSE");
		StockDetails details4=new StockDetails(new Random().nextInt(1000),"RBI",90092,"BSE");
		//System.out.println(service.registerStockDetailsBatch(List.of(details1, details2,details3, details4)));
		
		System.out.println("-------find(-,-) for selecting the documents---------");
		//service.fetchStocksDetailsByExchange("BSE").forEach(System.out::println);
		System.out.println("--------------------------------");
		//service.fetchStockDetailsByPriceRange(80000.0, 100000.0).forEach(System.out::println);;
		//System.out.println("924 stockId stock details are:: "+service.fetchStockDetailsByStockId(924));
		//System.out.println(service.fetchAndUpdateStockDetailsByStockId(46, 44000.0,"NSE"));
		//System.out.println(service.modifyExchangeByStockPriceRange(400, 60000, "NYKSE"));
		//System.out.println(service.registerOrUpdateStockByStockName("PNB", 7800.0, "CHE"));
		System.out.println(service.fetchAndRemoveByStockName("SBH"));
		System.out.println(service.removeStocksByPriceRange(9000, 10000.0));
	}

}
