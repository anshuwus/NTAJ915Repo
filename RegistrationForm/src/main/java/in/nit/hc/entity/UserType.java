package in.nit.hc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="UserType_Tab")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserType {
	//child table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long typeCode;
	
	@Column(name="userType_col", length=20)
	private String userRoles;
}
