package com.nt.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="boot_emp")
@Entity
@SQLDelete(sql="UPDATE BOOT_EMP SET STATUS='DELETED' WHERE EMPNO=?")
@Where(clause="STATUS <> 'DELETED'")
public class Employee {
	@Id
	@SequenceGenerator(name="gen1", sequenceName = "emp_id_seq", initialValue=1, allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer empno;
	@Column(length=20)
	private String ename;
	@Column(length=20)
	private String job;
	private Float sal;
	private Integer deptno;
	private String status="active";
}
