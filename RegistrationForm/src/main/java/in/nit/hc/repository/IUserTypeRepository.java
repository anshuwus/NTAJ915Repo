package in.nit.hc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nit.hc.entity.UserType;

public interface IUserTypeRepository extends JpaRepository<UserType, Long> {
	@Query("SELECT typeCode,userRoles FROM UserType")
	List<Object[]> getTypeCodeAndUserType();
}
