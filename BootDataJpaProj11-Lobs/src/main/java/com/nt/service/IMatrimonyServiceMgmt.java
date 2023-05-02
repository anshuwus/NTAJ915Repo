package com.nt.service;

import java.util.Optional;

import com.nt.entity.MarriageSeeker;

public interface IMatrimonyServiceMgmt {
	public String registerMarriageSeeker(MarriageSeeker seeker);
	public Optional<MarriageSeeker> searchSeekerById(Long id);
}
