package com.nt.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumerRepository;

@Service("OToMService")
public class OToMAssociationMappingServiceImpl implements IOToMAssociationMgmtService {

	@Autowired
	private IPersonRepository personRepo;
	@Autowired
	private IPhoneNumerRepository phoneRepo;
	
	@Override
	public void saveDataUsingParent() {
		//create Parent object
		Person per=new Person("raja","hyd");
		//create child objects
		PhoneNumber ph1=new PhoneNumber(99999999L,"airtel","personal");
		PhoneNumber ph2=new PhoneNumber(88888888L,"vi","office");
		
		//add parent to child
		ph1.setPersonInfo(per);ph2.setPersonInfo(per);
		
		//add childs to parent
		Set<PhoneNumber> phonesSet=new HashSet();
		phonesSet.add(ph1); phonesSet.add(ph2);
		per.setContactDetails(phonesSet);
		
		//save the parent object
		personRepo.save(per);
		System.out.println("Person and his associated phoneNumbers are saved (parent to child)");
	}//method

	@Override
	public void saveDataUsingChild() {
		//create Parent object
		Person per=new Person("ramesh","vizag");
		//create child objects
		PhoneNumber ph1=new PhoneNumber(777777777L,"Jio","personal");
		PhoneNumber ph2=new PhoneNumber(6666666666L,"vi","office");
		
		//add parent to child
		ph1.setPersonInfo(per);  ph2.setPersonInfo(per);
		
		//add childs to parent
		Set<PhoneNumber> phonesSet=new HashSet();
		phonesSet.add(ph1);  phonesSet.add(ph2);
		per.setContactDetails(phonesSet);
		
		//save the parent object
		phoneRepo.save(ph1);  phoneRepo.save(ph2);
		System.out.println("Person and his associated phoneNumbers are saved (child to parent");
	}

	@Override
	public void loadDataUsingParent() {
		//List<Person> list=personRepo.findAll();
		Iterable<Person> it=personRepo.findAll();
		it.forEach(per ->{
			System.out.println("Parent:: "+per);
			//gets child of each parent
		    Set<PhoneNumber> childs=per.getContactDetails();
		    System.out.println("Childs count:: "+childs.size());
		    childs.forEach(ph -> {
		    	System.out.println("Child (Mob no.)::"+ph.getMobileNo());
		    	System.out.println("Child NumberType::"+ph.getNumberType());
		    	System.out.println("Child Provider::"+ph.getProvider());
		    });
		});
	}

	@Override
	public String deleteByPerson(int personId) {
		//load Parent object
		Optional<Person> opt=personRepo.findById(personId);
		if(opt.isPresent()) {
			personRepo.delete(opt.get());
			return "Person and his PhoneNumber are deleted";	
		}
		return personId+" Person not found";
	}

	@Override
	public String deleteAllPhoneNumbersOfAPerson(int personId) {
		//Load Parent object
		Optional<Person> opt=personRepo.findById(personId);
		if(opt.isPresent()) {
			//get all childs of a Parent
			Set<PhoneNumber> childs=opt.get().getContactDetails();
			//delete all childs object by nullifying Parent obj from child object
			childs.forEach(ph -> {
				ph.setPersonInfo(null);
			});
			phoneRepo.deleteAll(childs);
			return childs.size()+" PhoneNumbers of "+personId+" Person are deleted";
		}
		return personId+" Person not found";
	}

	@Override
	public void addNewChildToAParentById(int id) {
		//Load Parent object
		Optional<Person> opt=personRepo.findById(id);
		if(opt.isPresent()) {
			Person per=opt.get();
			//get childs of a Parent
			Set<PhoneNumber> childs=per.getContactDetails();
			//create the new child object
			PhoneNumber ph=new PhoneNumber(7777777777L,"vodafone","personal");
			//link child to Parent
			ph.setPersonInfo(per);
			childs.add(ph);
			phoneRepo.save(ph);
			System.out.println("New Child is added to the existing childs of a Parent");
		}//if
		else {
			System.out.println(id+" Person not found for operation");
		}
	}//method

}//class close
