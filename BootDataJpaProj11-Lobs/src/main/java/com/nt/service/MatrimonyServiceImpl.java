package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MarriageSeeker;
import com.nt.repository.IMarriageSeekerRepo;

@Service("matrimonyService")
public class MatrimonyServiceImpl implements IMatrimonyServiceMgmt {
	
	@Autowired
	private IMarriageSeekerRepo msRepo;
	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		return "Marriage Seeker info is saved with id value "+msRepo.save(seeker).getId();
	}
//
	@Override
	public Optional<MarriageSeeker> searchSeekerById(Long id) {
		return msRepo.findById(id);
	}
}
