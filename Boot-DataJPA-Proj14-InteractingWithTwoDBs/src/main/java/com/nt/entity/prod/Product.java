//Product.java
package com.nt.entity.prod;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="JPA_PRODUCT")
public class Product {
	@Id
	@GeneratedValue
  private Integer pid;
	@NonNull
	@Column(length = 20)
	private String pname;
	@NonNull
	@Column(length = 20)
	private  String category;
	@NonNull
	private  Double qty;
	@NonNull
	private  Double price;
}
