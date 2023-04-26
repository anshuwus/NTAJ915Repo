package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="DEPT")
public class Department {
	@Id
	private Integer deptno;
	private String dname;
	private String loc;
}
