package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.MarriageSeeker;

public interface IMarriageSeekerRepo extends JpaRepository<MarriageSeeker, Long> {

}
