package com.nt.model.prod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="MDS_PRODUCT")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	
	@Column(length=20)
	@NonNull
	private String pname;
	
	@NonNull
	private Double qty;
	
	@NonNull
	private Double price;
}
