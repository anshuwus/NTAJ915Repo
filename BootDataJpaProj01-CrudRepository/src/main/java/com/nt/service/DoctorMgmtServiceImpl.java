package com.nt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Override
	public String registerDoctor(Doctor doctor) {
		System.out.println("IDoctorRepo(I) impl class name :: "+doctorRepo.getClass());
		System.out.println("Doc Id(before save):: "+doctor.getDocId());
		doctor=doctorRepo.save(doctor);
		return "Doctor obj is saved with id value:: "+doctor.getDocId();
	}

	@Override
	public String registerGroupOfDoctors(Iterable<Doctor> doctors) {
		/*if(doctors!=null) {
			Iterable<Doctor> savedDoctors=doctorRepo.saveAll(doctors);
			int size=((Collection) savedDoctors).size();
			List<Integer> ids=(List<Integer>) ((Collection)savedDoctors).stream().map(d->((Doctor)d).getId()).collect(Collectors.toList());
			return size+" no. of doctors are saved with id values: "+ids.toString();
		}*/
		if(doctors!=null) {
			Iterable<Doctor> savedDoctors=doctorRepo.saveAll(doctors);
			int size=((Collection)savedDoctors).size();
			List<Integer> ids=new ArrayList();
			savedDoctors.forEach(d->{
				ids.add(d.getDocId());
			});
			return size+" no. of doctors are saved with id vales: "+ids.toString();
		}
		else {		
			throw new IllegalArgumentException("Invalid doctors info");
		}

	}

	@Override
	public long fetchDoctorsCount() {
		
		return doctorRepo.count();
	}

	@Override
	public boolean checkDoctorAvailbility(Integer id) {
		
		return doctorRepo.existsById(id);
	}

	@Override
	public Iterable<Doctor> showAllDoctors() {
		
		return doctorRepo.findAll();
	}

	@Override
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids) {
		
		return doctorRepo.findAllById(ids);
	}

	/*@Override
	public Doctor showDoctorById(Integer id) {
		Doctor dutyDoctor=new Doctor();
		dutyDoctor.setSpecialization("Duty Doctor");
		Doctor doctor=doctorRepo.findById(id).orElse(dutyDoctor);
		return doctor;
	}
	*/
	
	/*@Override
	public Doctor showDoctorById(Integer id) {
		Doctor doctor=doctorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid doctor Id"));
		return doctor;
	}*/
	
	@Override
	public Doctor showDoctorById(Integer id) {
		Optional<Doctor> opt=doctorRepo.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			throw new IllegalArgumentException("Invalid doctor id");
	}

	//update partial object
	@Override
	public String updateDoctorIncomeById(Integer id, float hikePercentage) {
		//load object
		Optional<Doctor> opt=doctorRepo.findById(id);
		if(opt.isPresent()) {
			Doctor doctor=opt.get();
			double newIncome=doctor.getIncome()+(doctor.getIncome()*(hikePercentage/100.0f));
			//set new income to Entity object
			doctor.setIncome(newIncome);
			//partially update the object
			return doctorRepo.save(doctor).getDocId()+" is updated with "+newIncome;
			
		
		}
		else {
			return id+" Doctor not found";
		}
	
	}

	//full object modification or insertion
	@Override
	public String registerOrUpdateDoctor(Doctor doctor) {
		//load Doctor object
		Optional<Doctor> opt=doctorRepo.findById(doctor.getDocId());
		if(opt.isPresent()) {
			doctorRepo.save(doctor); //for update obj opertaion
			return doctor.getDocId()+" Doctor details are found and updated";
		}
		else
			return "Doctor is saved with id value: "+doctorRepo.save(doctor).getDocId();//for save obj operation
	}//method

	
	@Override
	public String deleteDoctorById(Integer id) {
		//load object
		Optional<Doctor> opt=doctorRepo.findById(id);
		if(opt.isPresent()) {
			doctorRepo.deleteById(id);
			return id+" doctor is deleted";
		}
		else {
			return id+" doctor not found for deletion";
		}
	}

	@Override
	public String deleteDoctor(Doctor doctor) {
		//load object
		Optional<Doctor> opt=doctorRepo.findById(doctor.getDocId());
		if(opt.isEmpty()) {
			return doctor.getDocId()+" doctor is not found";
		}
		else {
			doctorRepo.delete(opt.get());
			return doctor.getDocId()+" doctor found and deleted";
		}
	}

	@Override
	public String removeAllDoctors() {
		long count=doctorRepo.count();
		if(count>0) {
			doctorRepo.deleteAll();
			return count+" no. of records are deleted";
		}
		return "no records found delete";
	}

	@Override
	public String removeDoctorsByIds(List<Integer> ids) {
		List<Doctor> docList=(List<Doctor>) doctorRepo.findAllById(ids);
		if(docList.size()==ids.size()) {
			doctorRepo.deleteAllById(ids);
			return docList.size()+" no. of records are deleted";
		}
		return "Some of given id value records are not found in the DB table";
	}

	@Override
	public String removeDoctor(List<Doctor> doctor) {
		List<Integer> ids= new ArrayList();
		doctor.forEach(id->ids.add(id.getDocId()));
		List<Doctor> docList=(List<Doctor>) doctorRepo.findAllById(ids);
		ids.forEach(id->System.out.println("From List<Integer>:: "+id));
		System.out.println("Count-> "+ids.size());
		if(!ids.contains(null)) {
			doctorRepo.deleteAll(docList);
			return ids.size()+" no. of records are delete";
		}
		return "Some of given id value records are not found in the DB table";
	}

}//class close
