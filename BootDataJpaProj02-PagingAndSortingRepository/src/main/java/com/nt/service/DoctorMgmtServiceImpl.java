package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;
	
	@Override
	public Iterable<Doctor> showDoctorsBySorting(boolean asc, String... props) {
		//prepare the Sort object
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,props);
		//use Repo
		Iterable<Doctor> it=doctorRepo.findAll(sort);
		return it;
	}//method close

	@Override
	public Page<Doctor> showDoctorsInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String... props) {
		//prepare the Sort object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC, props);
		
		//prepare Pageable object
		Pageable pageable=PageRequest.of(pageNo, pageSize, sort);
		
		//use the repo
		Page<Doctor> page=doctorRepo.findAll(pageable);
		return page;
	}

	@Override
	public void showDataThroughPagination(int pageSize) {
		//decide the no. of pages
		long count=doctorRepo.count();
		long pagesCount= count/pageSize;
		//pagesCount=count%pageSize==0?pagesCount:pagesCount++;
		if(count%pagesCount!=0) {
			pagesCount++;
			
		}
		for(int i=0;i<pagesCount;i++) {
			//create Pageable object
			Pageable pagebale=PageRequest.of(i, pageSize);
			//get each page records
			Page<Doctor> page=doctorRepo.findAll(pagebale);
			System.out.println("Page:: "+(page.getNumber()+1)+"  Rocords of:: "+page.getTotalPages());
			page.getContent().forEach(System.out::println);
			System.out.println("____________________________________");
		}
		
	}

}//class close
