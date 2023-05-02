package com.nt.runner;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.prod.Product;
import com.nt.entity.promos.Offers;
import com.nt.repository.prod.IProductRepsitory;
import com.nt.repository.promos.IOffersRepository;

@Component
public class MultiDBInteractionTestRunner implements CommandLineRunner {
	@Autowired
	private IProductRepsitory  prodRepo;
	@Autowired
	private  IOffersRepository  offersRepo;

	@Override
	public void run(String... args) throws Exception {
		/*//save  Products 
		 System.out.println(" saving multiple products:::"+prodRepo.saveAll(List.of(new Product("table","furniture",10.0,3000.0),
				                                                                                                               new Product("chair","furniture",12.0,4000.0),
				                                                                                                                new Product("soft","furniture",15.0,40000.0))));
		 System.out.println("________________________");
		
		 //save offers
		 System.out.println(" saving multiple offers:::"+offersRepo.saveAll(List.of(new Offers("summer Offer",25.0,LocalDate.of(2022, 10, 24)),
				                                                                                                                        new Offers("Winter Offer",30.0,LocalDate.of(2025, 11, 18))
		                                                                                                                               )));*/
		
		prodRepo.findAll().forEach(System.out::println);
      System.out.println("_____________________________");
       offersRepo.findAll().forEach(System.out::println);

	}

}
