package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="CUSTOMER_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer custId;
	
	@Column(length=20)
	@NonNull
	private String custName;
	
	@Column(length=20)
	@NonNull
	private String custAddrs;
	
	@NonNull
	private LocalDateTime dob;
	
	@NonNull
	private LocalTime top;
	
	@NonNull
	private LocalDate dop;
}
