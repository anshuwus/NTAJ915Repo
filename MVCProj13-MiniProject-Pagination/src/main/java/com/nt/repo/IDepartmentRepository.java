package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
	@Query("select deptno from Department")
	public List<Integer> getAllDeptNo();
}
