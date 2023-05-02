
package com.nt.entity.promos;

import java.time.LocalDate;

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
@Table(name="JPA_OFFERS")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Offers {
	@Id
	@GeneratedValue
   private  Integer ofid;
	@NonNull
	@Column(length = 20)
	private  String  offerName;
	@NonNull
	private  double   discountPercentage;
	@NonNull
	private  LocalDate validTo;
	
	
	
	
}
